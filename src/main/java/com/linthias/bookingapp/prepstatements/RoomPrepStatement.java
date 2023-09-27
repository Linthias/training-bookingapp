package com.linthias.bookingapp.prepstatements;

public class RoomPrepStatement {
    private  RoomPrepStatement() {}

    public final static String INSERT = "INSERT INTO rooms "
            + "(id, hotel_id, capacity, room_name, price_per_night) "
            + "VALUES (DEFAULT, ?, ?, ?, ?) "
            + "ON CONFLICT DO NOTHING";

    public final static String GET_ALL = "SELECT * FROM rooms";

    public final static String GET_BY_ID = GET_ALL + " WHERE id = ?";

    public final static String UPDATE_BY_ID = "UPDATE rooms SET "
            + "hotel_id = ?, "
            + "capacity = ?, "
            + "room_name = ?, "
            + "price_per_night = ? "
            + "WHERE id = ?";

    public final static String DELETE_BY_ID = "DELETE FROM rooms WHERE id = ?";

    public final static String GET_BY_HOTEL = GET_ALL + " WHERE hotel_id = ?";
}
