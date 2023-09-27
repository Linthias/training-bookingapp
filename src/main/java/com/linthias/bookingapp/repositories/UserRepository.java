package com.linthias.bookingapp.repositories;

import com.linthias.bookingapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.linthias.bookingapp.prepstatements.UserPrepStatement.DELETE_BY_ID;
import static com.linthias.bookingapp.prepstatements.UserPrepStatement.GET_ALL;
import static com.linthias.bookingapp.prepstatements.UserPrepStatement.GET_BY_AUTH;
import static com.linthias.bookingapp.prepstatements.UserPrepStatement.GET_BY_ID;
import static com.linthias.bookingapp.prepstatements.UserPrepStatement.INSERT;
import static com.linthias.bookingapp.prepstatements.UserPrepStatement.UPDATE_BY_ID;

@Repository
public class UserRepository extends BaseRepository<User> {

    @Autowired
    public UserRepository(RowMapper<User> mapper, JdbcTemplate jdbcTemplate) {
        super(mapper, jdbcTemplate);
    }

    @Override
    public User create(User entity) {
        jdbcTemplate.update(INSERT, entity.getUserName(), entity.getPassword(), entity.getRole());

        return jdbcTemplate.queryForObject(GET_BY_ID, entityMapper, entity.getId());
    }

    @Override
    public User findById(Long id) {
        return jdbcTemplate.queryForObject(GET_BY_ID, entityMapper, id);
    }

    @Override
    public List<User> findByUserId(Long userId) {
        return null;
    }

    @Override
    public List<User> findByRoomId(Long roomId) {
        return null;
    }

    @Override
    public List<User> findByHotelId(Long hotelId) {
        return null;
    }

    @Override
    public User findByName(String name) {
        return jdbcTemplate.queryForObject(GET_BY_AUTH, entityMapper, name);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(GET_ALL, entityMapper);
    }

    @Override
    public User update(User entity) {
        jdbcTemplate.update(UPDATE_BY_ID,
                entity.getUserName(), entity.getPassword(), entity.getRole(), entity.getId());

        return jdbcTemplate.queryForObject(GET_BY_ID, entityMapper, entity.getId());
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update(DELETE_BY_ID, id);
    }
}
