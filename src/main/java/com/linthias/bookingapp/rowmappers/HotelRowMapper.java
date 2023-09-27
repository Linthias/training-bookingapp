package com.linthias.bookingapp.rowmappers;

import com.linthias.bookingapp.models.Hotel;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class HotelRowMapper implements RowMapper<Hotel> {
    @Override
    public Hotel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Hotel(
                rs.getLong("id"),
                rs.getString("hotel_name"),
                rs.getInt("grade"),
                rs.getDouble("latitude"),
                rs.getDouble("longitude"));
    }
}
