package com.linthias.bookingapp.validators;

import com.linthias.bookingapp.dtos.HotelInputDto;
import org.springframework.stereotype.Component;

@Component
public class HotelValidator extends BaseValidator<HotelInputDto> {
    @Override
    public boolean isValid(HotelInputDto entity) {
        return !isBlankString(entity.getHotelName())
                && entity.getGrade() > 0
                && entity.getGrade() < 6;
                //&& entity.getLatitude() != null
                //&& entity.getLongitude() != null;
    }
}
