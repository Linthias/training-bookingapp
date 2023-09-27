package com.linthias.bookingapp.validators;

import com.linthias.bookingapp.dtos.BookingInputDto;
import org.springframework.stereotype.Component;

@Component
public class BookingValidator extends BaseValidator<BookingInputDto> {
    @Override
    public boolean isValid(BookingInputDto entity) {
        return !isBlankString(entity.getUserName());
    }
}
