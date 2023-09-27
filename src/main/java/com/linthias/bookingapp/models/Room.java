package com.linthias.bookingapp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class Room {
    private Long id;
    private Long hotelId;
    private Integer capacity;
    private String roomName;
    private BigDecimal pricePerNight;
}
