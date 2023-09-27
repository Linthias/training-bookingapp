package com.linthias.bookingapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class RoomDto {
    private Long id;
    private Long hotelId;
    private Integer capacity;
    private String roomName;
    private BigDecimal pricePerNight;
}
