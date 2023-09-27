package com.linthias.bookingapp.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public abstract class BaseRepository<E> {
    protected final RowMapper<E> entityMapper;
    protected final JdbcTemplate jdbcTemplate;

    protected BaseRepository(RowMapper<E> entityMapper, JdbcTemplate jdbcTemplate) {
        this.entityMapper = entityMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    public abstract E create(E entity);
    public abstract E findById(Long id);
    public abstract List<E> findByUserId(Long userId);
    public abstract List<E> findByRoomId(Long roomId);
    public abstract List<E> findByHotelId(Long hotelId);
    public abstract E findByName(String name);
    public abstract List<E> findAll();
    public abstract E update(E entity);
    public abstract void deleteById(Long id);

}
