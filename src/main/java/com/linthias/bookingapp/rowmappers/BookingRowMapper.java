package com.linthias.bookingapp.rowmappers;

import com.linthias.bookingapp.models.Booking;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Component
public class BookingRowMapper implements RowMapper<Booking> {
    @Override
    public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Booking(
                rs.getLong("id"),
                rs.getLong("room_id"),
                rs.getLong("user_id"),
                rs.getLong("hotel_id"),
                LocalDate.parse(rs.getString("booking_start")),
                LocalDate.parse(rs.getString("booking_end")));
    }
}
