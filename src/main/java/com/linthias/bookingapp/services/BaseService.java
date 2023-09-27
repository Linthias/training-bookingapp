package com.linthias.bookingapp.services;

import com.linthias.bookingapp.repositories.BaseRepository;

import java.util.List;

public abstract class BaseService<E, I, O> {
    protected final BaseRepository<E> mainEntityRepository;

    public BaseService(BaseRepository<E> mainEntityRepository) {
        this.mainEntityRepository = mainEntityRepository;
    }

    public abstract O add(I input);
    public abstract O getById(Long id);
    public abstract List<O> getAll();
    public abstract List<O> getMyBookings(String user);
    public abstract List<O> getAvailable();
    public abstract O update(I input);
}
