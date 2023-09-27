package com.linthias.bookingapp.services;

import com.linthias.bookingapp.dtomappers.BaseDtoMapper;
import com.linthias.bookingapp.dtos.RoomDto;
import com.linthias.bookingapp.models.Room;
import com.linthias.bookingapp.repositories.BaseRepository;
import com.linthias.bookingapp.validators.BaseValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    private final BaseRepository<Room> repository;
    private final BaseValidator<RoomDto> validator;
    private final BaseDtoMapper<Room, RoomDto, RoomDto> mapper;

    @Autowired
    public RoomService(BaseRepository<Room> repository,
                       BaseValidator<RoomDto> validator,
                       BaseDtoMapper<Room, RoomDto, RoomDto> mapper) {
        this.repository = repository;
        this.validator = validator;
        this.mapper = mapper;
    }

    public RoomDto add(RoomDto input) {
        if (!validator.isValid(input)) {
            throw new RuntimeException("");
        }

        return mapper.toDto(repository.create(mapper.toEntity(input)));
    }

    public RoomDto getById(Long id) {
        return mapper.toDto(repository.findById(id));
    }

    public RoomDto update(RoomDto input) {
        if (!validator.isValid(input)) {
            throw new RuntimeException("");
        }

        return mapper.toDto(repository.update(mapper.toEntity(input)));
    }
}
