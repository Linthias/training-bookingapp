package com.linthias.bookingapp.rowmappers;

import com.linthias.bookingapp.models.Role;
import com.linthias.bookingapp.models.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(
                rs.getLong("id"),
                rs.getString("user_name"),
                rs.getString("user_password"),
                Role.valueOf(rs.getString("user_role")));
    }
}
