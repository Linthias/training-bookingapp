package com.linthias.bookingapp.dtomappers;

public interface BaseDtoMapper<E, I, O> {
    O toDto(E entity);
    E toEntity(I input);
}
