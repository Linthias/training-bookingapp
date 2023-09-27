package com.linthias.bookingapp.rowmappers;

import com.linthias.bookingapp.models.Room;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class RoomRowMapper implements RowMapper<Room> {
    @Override
    public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Room(
                rs.getLong("id"),
                rs.getLong("hotel_id"),
                rs.getInt("capacity"),
                rs.getString("room_name"),
                rs.getBigDecimal("price_per_night"));
    }
}
