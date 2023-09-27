package com.linthias.bookingapp.prepstatements;

public class UserPrepStatement {

    private UserPrepStatement() {}

    public final static String INSERT = "INSERT INTO users "
            + "(id, user_name, user_password, user_role) "
            + "VALUES (DEFAULT, ?, ?, ?) "
            + "ON CONFLICT DO NOTHING";

    public final static String GET_ALL = "SELECT * FROM users";

    public final static String GET_BY_ID = GET_ALL + " WHERE id = ?";

    public final static String GET_BY_AUTH = GET_ALL + " WHERE user_name = ?";

    public final static String UPDATE_BY_ID = "UPDATE users SET "
            + "user_name = ?, "
            + "user_password = ?, "
            + "user_role = ? "
            + "WHERE id = ?";

    public final static String DELETE_BY_ID = "DELETE FROM users WHERE id = ?";
}
