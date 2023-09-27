package com.linthias.bookingapp.dtomappers;

import com.linthias.bookingapp.dtos.HotelInputDto;
import com.linthias.bookingapp.dtos.HotelOutputDto;
import com.linthias.bookingapp.dtos.RoomDto;
import com.linthias.bookingapp.models.Hotel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HotelDtoMapper implements BaseDtoMapper<Hotel, HotelInputDto, HotelOutputDto> {
    @Override
    public HotelOutputDto toDto(Hotel entity) {
        return null;
    }

    public HotelOutputDto customToDto(Hotel entity, List<RoomDto> rooms) {
        return new HotelOutputDto(
                entity.getId(),
                entity.getHotelName(),
                entity.getGrade(),
                entity.getLatitude(),
                entity.getLongitude(),
                rooms);
    }

    public HotelInputDto customToSmallDto(Hotel entity) {
        return new HotelInputDto(
                entity.getId(),
                entity.getHotelName(),
                entity.getGrade(),
                entity.getLatitude(),
                entity.getLongitude());
    }

    @Override
    public Hotel toEntity(HotelInputDto input) {
        return new Hotel(
                input.getId(),
                input.getHotelName(),
                input.getGrade(),
                input.getLatitude(),
                input.getLongitude());
    }
}
