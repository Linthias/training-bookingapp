package com.linthias.bookingapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class BookingInputDto {
    private Long bookingId;
    private Long bookingRoomId;
    private String userName;
    private Long bookingHotelId;
    private LocalDate bookingStart;
    private LocalDate bookingEnd;
}
