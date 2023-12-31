package com.linthias.bookingapp.services;

import com.linthias.bookingapp.dtomappers.BaseDtoMapper;
import com.linthias.bookingapp.dtomappers.BookingDtoMapper;
import com.linthias.bookingapp.dtomappers.HotelDtoMapper;
import com.linthias.bookingapp.dtos.BookingInputDto;
import com.linthias.bookingapp.dtos.BookingOutputDto;
import com.linthias.bookingapp.dtos.HotelInputDto;
import com.linthias.bookingapp.dtos.RoomDto;
import com.linthias.bookingapp.exceptions.DatesAreOccupiedException;
import com.linthias.bookingapp.exceptions.DtoNotValidException;
import com.linthias.bookingapp.models.Booking;
import com.linthias.bookingapp.models.Room;
import com.linthias.bookingapp.models.User;
import com.linthias.bookingapp.repositories.BaseRepository;
import com.linthias.bookingapp.repositories.BookingRepository;
import com.linthias.bookingapp.repositories.HotelRepository;
import com.linthias.bookingapp.repositories.UserRepository;
import com.linthias.bookingapp.validators.BaseValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository repository;
    private final BaseRepository<Room> roomRepository;
    private final UserRepository userRepository;
    private final HotelRepository hotelRepository;
    private final BaseValidator<BookingInputDto> validator;
    private final BookingDtoMapper mapper;
    private final BaseDtoMapper<Room, RoomDto, RoomDto> roomMapper;
    private final HotelDtoMapper hotelMapper;

    private void validateInput(BookingInputDto input) throws DtoNotValidException {
        if (!validator.isValid(input)) {
            throw new DtoNotValidException("incorrect input: " + input.getClass().getName());
        }
    }

    private void validateAvailability(BookingInputDto input) throws DatesAreOccupiedException {
        List<Booking> existingBookings = repository.findByRoomId(input.getBookingRoomId());

        for (Booking bk : existingBookings) {
            if (input.getBookingStart().isBefore(bk.getBookingEnd())
                    && input.getBookingStart().isAfter(bk.getBookingStart())
                    || input.getBookingEnd().isBefore(bk.getBookingEnd())
                    && input.getBookingEnd().isAfter(bk.getBookingStart())) {
                throw new DatesAreOccupiedException("occupied period: " + input.getBookingStart() + "-" + input.getBookingEnd());
            }
        }
    }

    public BookingOutputDto add(BookingInputDto input) throws DtoNotValidException, DatesAreOccupiedException {
        validateInput(input);

        validateAvailability(input);

        User user = userRepository.findByName(input.getUserName());

        Booking booking = repository.create(mapper.customToEntity(input, user));

        HotelInputDto hotel = hotelMapper.customToSmallDto(hotelRepository.findById(booking.getHotelId()));

        return mapper.customToDto(
                booking,
                user,
                roomMapper.toDto(roomRepository.findById(booking.getRoomId())),
                hotel);
    }

    public BookingOutputDto getById(Long id) {
        Booking booking = repository.findById(id);
        User user = userRepository.findById(booking.getUserId());

        HotelInputDto hotel = hotelMapper.customToSmallDto(hotelRepository.findById(booking.getHotelId()));

        return mapper.customToDto(
                booking,
                user,
                roomMapper.toDto(roomRepository.findById(booking.getRoomId())),
                hotel);
    }

    public List<BookingOutputDto> getAll() {
        return repository.findAll().stream().map(booking
                -> mapper.customToDto(
                        booking,
                userRepository.findById(booking.getUserId()),
                roomMapper.toDto(roomRepository.findById(booking.getRoomId())),
                hotelMapper.customToSmallDto(
                        hotelRepository.findById(booking.getHotelId())))).collect(Collectors.toList());
    }

    public List<BookingOutputDto> getMyBookings(String user) {
        User currentUser = userRepository.findByName(user);

        List<Booking> bookings = repository.findByUserId(currentUser.getId());

        return bookings.stream().map(booking
                -> mapper.customToDto(
                booking,
                userRepository.findById(booking.getUserId()),
                roomMapper.toDto(roomRepository.findById(booking.getRoomId())),
                hotelMapper.customToSmallDto(
                        hotelRepository.findById(booking.getHotelId())))).collect(Collectors.toList());
    }

    public BookingOutputDto update(BookingInputDto input) throws DtoNotValidException, DatesAreOccupiedException {
        validateInput(input);

        validateAvailability(input);

        Booking booking = repository.update(mapper.toEntity(input));
        User user = userRepository.findById(booking.getUserId());

        HotelInputDto hotel = hotelMapper.customToSmallDto(hotelRepository.findById(booking.getHotelId()));

        return mapper.customToDto(
                booking,
                user,
                roomMapper.toDto(roomRepository.findById(booking.getRoomId())),
                hotel);
    }
}
