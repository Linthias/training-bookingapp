package com.linthias.bookingapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class HotelOutputDto {
    private Long id;
    private String hotelName;
    private Integer grade;
    private Double latitude;
    private Double longitude;
    private List<RoomDto> rooms;
}
