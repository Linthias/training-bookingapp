package com.linthias.bookingapp.dtomappers;

import com.linthias.bookingapp.dtos.UserDto;
import com.linthias.bookingapp.models.Role;
import com.linthias.bookingapp.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper implements BaseDtoMapper<User, UserDto, UserDto> {
    @Override
    public UserDto toDto(User entity) {
        return new UserDto(
                entity.getId(),
                entity.getUserName(),
                entity.getPassword(),
                entity.getRole().name());
    }

    @Override
    public User toEntity(UserDto input) {
        return new User(
                input.getId(),
                input.getUserName(),
                input.getPassword(),
                Role.valueOf(input.getRole()));
    }
}
