package com.linthias.bookingapp.validators;

import com.linthias.bookingapp.dtos.RoomDto;
import org.springframework.stereotype.Component;

@Component
public class RoomValidator extends BaseValidator<RoomDto> {
    @Override
    public boolean isValid(RoomDto entity) {
        return entity.getCapacity() > 0
                && !isBlankString(entity.getRoomName())
                && entity.getPricePerNight().doubleValue() > 0;
    }
}
