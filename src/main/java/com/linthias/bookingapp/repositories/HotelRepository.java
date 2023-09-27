package com.linthias.bookingapp.repositories;

import com.linthias.bookingapp.models.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.linthias.bookingapp.prepstatements.HotelPrepStatement.DELETE_BY_ID;
import static com.linthias.bookingapp.prepstatements.HotelPrepStatement.GET_ALL;
import static com.linthias.bookingapp.prepstatements.HotelPrepStatement.GET_BY_ID;
import static com.linthias.bookingapp.prepstatements.HotelPrepStatement.GET_BY_NAME;
import static com.linthias.bookingapp.prepstatements.HotelPrepStatement.INSERT;
import static com.linthias.bookingapp.prepstatements.HotelPrepStatement.UPDATE_BY_ID;

@Repository
public class HotelRepository extends BaseRepository<Hotel> {

    @Autowired
    public HotelRepository(RowMapper<Hotel> mapper, JdbcTemplate jdbcTemplate) {
        super(mapper, jdbcTemplate);
    }

    public Hotel create(Hotel entity) {
        int rows = jdbcTemplate.update(
                INSERT,
                entity.getHotelName(),
                entity.getGrade(),
                entity.getLatitude(),
                entity.getLongitude());

        return jdbcTemplate.queryForObject(GET_BY_NAME, entityMapper, entity.getHotelName());
    }

    public Hotel findById(Long id) {
        return jdbcTemplate.queryForObject(GET_BY_ID, entityMapper, id);
    }

    @Override
    public List<Hotel> findByUserId(Long userId) {
        return null;
    }

    @Override
    public List<Hotel> findByRoomId(Long roomId) {
        return null;
    }

    @Override
    public List<Hotel> findByHotelId(Long hotelId) {
        return null;
    }

    @Override
    public Hotel findByName(String name) {
        return null;
    }

    public List<Hotel> findAll() {
        return jdbcTemplate.query(GET_ALL, entityMapper);
    }

    public Hotel update(Hotel entity) {
        int rows = jdbcTemplate.update(
                UPDATE_BY_ID,
                entity.getHotelName(),
                entity.getGrade(),
                entity.getLatitude(),
                entity.getLongitude(),
                entity.getId());

        return jdbcTemplate.queryForObject(GET_BY_NAME, entityMapper, entity.getHotelName());
    }

    public void deleteById(Long id) {
        jdbcTemplate.update(DELETE_BY_ID, id);
    }
}
