package com.linthias.bookingapp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class Booking {
    private Long id;
    private Long roomId;
    private Long userId;
    private Long hotelId;
    private LocalDate bookingStart;
    private LocalDate bookingEnd;
}
