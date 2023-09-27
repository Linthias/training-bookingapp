package com.linthias.bookingapp.prepstatements;

public class BookingPrepStatement {
    private BookingPrepStatement() {}

    public final static String INSERT = "INSERT INTO bookings "
            + "(id, room_id, user_id, hotel_id, booking_start, booking_end) "
            + "VALUES (DEFAULT, ?, ?, ?, ?, ?) "
            + "ON CONFLICT DO NOTHING";

    public final static String GET_ALL = "SELECT * FROM bookings";

    public final static String GET_BY_ID = GET_ALL + " WHERE id = ?";
    public final static String GET_BY_USER_ID = GET_ALL + " WHERE user_id = ?";

    public final static String UPDATE_BY_ID = "UPDATE bookings SET "
            + "room_id = ?, "
            + "user_id = ?, "
            + "hotel_id = ?, "
            + "booking_start = ?, "
            + "booking_end = ? "
            + "WHERE id = ?";

    public final static String DELETE_BY_ID = "DELETE FROM bookings WHERE id = ?";

    public final static String GET_BY_ROOM = GET_ALL + " WHERE room_id = ?";
}
