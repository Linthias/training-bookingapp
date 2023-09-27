package com.linthias.bookingapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class BookingOutputDto {
    private Long id;
    private RoomDto room;
    private String userName;
    private HotelInputDto hotel;
    private LocalDate bookingStart;
    private LocalDate bookingEnd;
}
