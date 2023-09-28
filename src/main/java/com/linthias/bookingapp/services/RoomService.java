package com.linthias.bookingapp.services;

import com.linthias.bookingapp.dtomappers.BaseDtoMapper;
import com.linthias.bookingapp.dtos.RoomDto;
import com.linthias.bookingapp.exceptions.DtoNotValidException;
import com.linthias.bookingapp.models.Room;
import com.linthias.bookingapp.repositories.BaseRepository;
import com.linthias.bookingapp.validators.BaseValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final BaseRepository<Room> repository;
    private final BaseValidator<RoomDto> validator;
    private final BaseDtoMapper<Room, RoomDto, RoomDto> mapper;

    private void validateInput(RoomDto input) throws DtoNotValidException {
        if (!validator.isValid(input)) {
            throw new DtoNotValidException("incorrect input: " + input.getClass().getName());
        }
    }

    public RoomDto add(RoomDto input) throws DtoNotValidException {
        validateInput(input);

        return mapper.toDto(repository.create(mapper.toEntity(input)));
    }

    public RoomDto getById(Long id) {
        return mapper.toDto(repository.findById(id));
    }

    public RoomDto update(RoomDto input) throws DtoNotValidException {
        validateInput(input);

        return mapper.toDto(repository.update(mapper.toEntity(input)));
    }
}
