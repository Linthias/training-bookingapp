package com.linthias.bookingapp.dtomappers;

import com.linthias.bookingapp.dtos.RoomDto;
import com.linthias.bookingapp.models.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomDtoMapper implements BaseDtoMapper<Room, RoomDto, RoomDto> {
    @Override
    public RoomDto toDto(Room entity) {
        return new RoomDto(
                entity.getId(),
                entity.getHotelId(),
                entity.getCapacity(),
                entity.getRoomName(),
                entity.getPricePerNight());
    }

    @Override
    public Room toEntity(RoomDto input) {
        return new Room(
                input.getId(),
                input.getHotelId(),
                input.getCapacity(),
                input.getRoomName(),
                input.getPricePerNight());
    }
}
