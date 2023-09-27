package com.linthias.bookingapp.validators;

import com.linthias.bookingapp.dtos.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserValidator extends BaseValidator<UserDto> {
    @Override
    public boolean isValid(UserDto entity) {
        return !isBlankString(entity.getUserName())
                && !isBlankString(entity.getPassword());
    }
}
