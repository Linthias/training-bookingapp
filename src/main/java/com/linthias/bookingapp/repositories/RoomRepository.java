package com.linthias.bookingapp.repositories;

import com.linthias.bookingapp.models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.linthias.bookingapp.prepstatements.RoomPrepStatement.DELETE_BY_ID;
import static com.linthias.bookingapp.prepstatements.RoomPrepStatement.GET_ALL;
import static com.linthias.bookingapp.prepstatements.RoomPrepStatement.GET_BY_HOTEL;
import static com.linthias.bookingapp.prepstatements.RoomPrepStatement.GET_BY_ID;
import static com.linthias.bookingapp.prepstatements.RoomPrepStatement.INSERT;
import static com.linthias.bookingapp.prepstatements.RoomPrepStatement.UPDATE_BY_ID;

@Repository
public class RoomRepository extends BaseRepository<Room> {

    @Autowired
    public RoomRepository(RowMapper<Room> mapper, JdbcTemplate jdbcTemplate) {
        super(mapper, jdbcTemplate);
    }

    @Override
    public Room create(Room entity) {
        jdbcTemplate.update(INSERT,
                entity.getHotelId(),
                entity.getCapacity(),
                entity.getRoomName(),
                entity.getPricePerNight());

        return jdbcTemplate.queryForObject(GET_BY_ID, entityMapper, entity.getId());
    }

    @Override
    public Room findById(Long id) {
        return jdbcTemplate.queryForObject(GET_BY_ID, entityMapper, id);
    }

    @Override
    public List<Room> findByUserId(Long userId) {
        return null;
    }

    @Override
    public List<Room> findByRoomId(Long roomId) {
        return null;
    }

    @Override
    public List<Room> findByHotelId(Long hotelId) {
        return jdbcTemplate.query(GET_BY_HOTEL, entityMapper, hotelId);
    }

    @Override
    public Room findByName(String name) {
        return null;
    }

    @Override
    public List<Room> findAll() {
        return jdbcTemplate.query(GET_ALL, entityMapper);
    }

    @Override
    public Room update(Room entity) {
        jdbcTemplate.update(UPDATE_BY_ID,
                entity.getHotelId(),
                entity.getCapacity(),
                entity.getRoomName(),
                entity.getPricePerNight(),
                entity.getId());

        return jdbcTemplate.queryForObject(GET_BY_ID, entityMapper, entity.getId());
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update(DELETE_BY_ID, id);
    }
}
