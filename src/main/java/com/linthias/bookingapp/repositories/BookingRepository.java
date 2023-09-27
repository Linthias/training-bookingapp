package com.linthias.bookingapp.repositories;

import com.linthias.bookingapp.models.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.linthias.bookingapp.prepstatements.BookingPrepStatement.DELETE_BY_ID;
import static com.linthias.bookingapp.prepstatements.BookingPrepStatement.GET_ALL;
import static com.linthias.bookingapp.prepstatements.BookingPrepStatement.GET_BY_ROOM;
import static com.linthias.bookingapp.prepstatements.BookingPrepStatement.GET_BY_ID;
import static com.linthias.bookingapp.prepstatements.BookingPrepStatement.GET_BY_USER_ID;
import static com.linthias.bookingapp.prepstatements.BookingPrepStatement.INSERT;
import static com.linthias.bookingapp.prepstatements.BookingPrepStatement.UPDATE_BY_ID;

@Repository
public class BookingRepository extends BaseRepository<Booking> {

    @Autowired
    public BookingRepository(RowMapper<Booking> mapper, JdbcTemplate jdbcTemplate) {
        super(mapper, jdbcTemplate);
    }

    public Booking create(Booking entity) {
        jdbcTemplate.update(INSERT,
                entity.getRoomId(),
                entity.getUserId(),
                entity.getHotelId(),
                entity.getBookingStart(),
                entity.getBookingEnd());

        return jdbcTemplate.queryForObject(GET_BY_ID, entityMapper, entity.getId());
    }


    public Booking findById(Long id) {
        return jdbcTemplate.queryForObject(GET_BY_ID, entityMapper, id);
    }


    public List<Booking> findByUserId(Long id) {
        return jdbcTemplate.query(GET_BY_USER_ID, entityMapper, id);
    }


    public List<Booking> findAll() {
        return jdbcTemplate.query(GET_ALL, entityMapper);
    }


    public Booking update(Booking entity) {
        jdbcTemplate.update(UPDATE_BY_ID,
                entity.getRoomId(),
                entity.getUserId(),
                entity.getHotelId(),
                entity.getBookingStart(),
                entity.getBookingEnd(),
                entity.getId());

        return jdbcTemplate.queryForObject(GET_BY_ID, entityMapper, entity.getId());
    }


    public void deleteById(Long id) {
        jdbcTemplate.update(DELETE_BY_ID, id);
    }


    public List<Booking> findByRoomId(Long roomId) {
        return jdbcTemplate.query(GET_BY_ROOM, entityMapper, roomId);
    }

    @Override
    public List<Booking> findByHotelId(Long hotelId) {
        return null;
    }

    @Override
    public Booking findByName(String name) {
        return null;
    }
}
