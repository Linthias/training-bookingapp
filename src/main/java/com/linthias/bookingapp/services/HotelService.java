package com.linthias.bookingapp.services;

import com.linthias.bookingapp.dtomappers.BaseDtoMapper;
import com.linthias.bookingapp.dtomappers.HotelDtoMapper;
import com.linthias.bookingapp.dtos.HotelInputDto;
import com.linthias.bookingapp.dtos.HotelOutputDto;
import com.linthias.bookingapp.dtos.RoomDto;
import com.linthias.bookingapp.exceptions.DtoNotValidException;
import com.linthias.bookingapp.models.Booking;
import com.linthias.bookingapp.models.Hotel;
import com.linthias.bookingapp.models.Room;
import com.linthias.bookingapp.repositories.BaseRepository;
import com.linthias.bookingapp.repositories.BookingRepository;
import com.linthias.bookingapp.repositories.HotelRepository;
import com.linthias.bookingapp.validators.BaseValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository repository;
    private final BaseRepository<Room> roomRepository;
    private final BookingRepository bookingRepository;
    private final BaseValidator<HotelInputDto> validator;
    private final HotelDtoMapper mapper;
    private final BaseDtoMapper<Room, RoomDto, RoomDto> roomMapper;

    private void validateInput(HotelInputDto input) throws DtoNotValidException {
        if (!validator.isValid(input)) {
            throw new DtoNotValidException("incorrect input: " + input.getClass().getName());
        }
    }

    public HotelOutputDto add(HotelInputDto input) throws DtoNotValidException {
        validateInput(input);

        Hotel hotel = repository.create(mapper.toEntity(input));

        return mapper.customToDto(
                hotel,
                roomRepository.findByHotelId(hotel.getId())
                        .stream().map(roomMapper::toDto).collect(Collectors.toList()));
    }

    public HotelOutputDto getById(Long id) {
        return mapper.customToDto(
                repository.findById(id),
                roomRepository.findByHotelId(id)
                        .stream().map(roomMapper::toDto).collect(Collectors.toList()));
    }

    public List<HotelOutputDto> getAll() {
        return repository.findAll().stream()
                .map(hotel -> mapper.customToDto(hotel,
                roomRepository.findByHotelId(hotel.getId())
                        .stream().map(roomMapper::toDto).collect(Collectors.toList()))).collect(Collectors.toList());
    }

    public List<HotelOutputDto> getAvailable(LocalDate bookingStart, LocalDate bookingEnd) {
        return repository.findAll().stream()
                .map(hotel -> {
                    List<Room> rooms = roomRepository.findByHotelId(hotel.getId());
                    List<Room> availableRooms = new ArrayList<>();
                    for (Room room : rooms) {
                        List<Booking> bookings = bookingRepository.findByRoomId(room.getId());
                        boolean isAvailable = true;

                        for (Booking booking : bookings) {
                            if (bookingStart.isBefore(booking.getBookingEnd())
                                    && bookingStart.isAfter(booking.getBookingStart())
                                    || bookingEnd.isBefore(booking.getBookingEnd())
                                    && bookingEnd.isAfter(booking.getBookingStart())) {
                                isAvailable = false;
                                break;
                            }
                        }

                        if (isAvailable) {
                            availableRooms.add(room);
                        }
                    }

                    return mapper.customToDto(
                            hotel,
                            availableRooms
                                    .stream().map(roomMapper::toDto).collect(Collectors.toList()));
                }).collect(Collectors.toList());
    }

    public HotelOutputDto update(HotelInputDto input) throws DtoNotValidException {
        validateInput(input);

        Hotel hotel = repository.update(mapper.toEntity(input));

        return mapper.customToDto(
                hotel,
                roomRepository.findByHotelId(hotel.getId())
                        .stream().map(roomMapper::toDto).collect(Collectors.toList()));
    }
}
