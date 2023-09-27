package com.linthias.bookingapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HotelInputDto {
    private Long id;
    private String hotelName;
    private Integer grade;
    private Double latitude;
    private Double longitude;
}
