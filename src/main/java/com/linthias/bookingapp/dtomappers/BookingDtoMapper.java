package com.linthias.bookingapp.dtomappers;

import com.linthias.bookingapp.dtos.BookingInputDto;
import com.linthias.bookingapp.dtos.BookingOutputDto;
import com.linthias.bookingapp.dtos.HotelInputDto;
import com.linthias.bookingapp.dtos.RoomDto;
import com.linthias.bookingapp.models.Booking;
import com.linthias.bookingapp.models.User;
import org.springframework.stereotype.Component;

@Component
public class BookingDtoMapper implements BaseDtoMapper<Booking, BookingInputDto, BookingOutputDto> {
    @Override
    public BookingOutputDto toDto(Booking entity) {
        return null;
    }

    public BookingOutputDto customToDto(Booking entity, User user, RoomDto room, HotelInputDto hotel) {
        return new BookingOutputDto(
                entity.getId(),
                room,
                user.getUserName(),
                hotel,
                entity.getBookingStart(),
                entity.getBookingEnd());
    }

    @Override
    public Booking toEntity(BookingInputDto input) {
        return null;
    }

    public Booking customToEntity(BookingInputDto input, User user) {
        return new Booking(
                input.getBookingId(),
                input.getBookingRoomId(),
                user.getId(),
                input.getBookingHotelId(),
                input.getBookingStart(),
                input.getBookingEnd());
    }
}
