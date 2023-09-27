package com.linthias.bookingapp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Hotel {
    private Long id;
    private String hotelName;
    private Integer grade;
    private Double latitude;
    private Double longitude;
}
