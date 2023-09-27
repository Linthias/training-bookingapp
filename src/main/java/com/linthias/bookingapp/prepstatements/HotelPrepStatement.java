package com.linthias.bookingapp.prepstatements;

public class HotelPrepStatement {
    private HotelPrepStatement() {}

    public final static String INSERT = "INSERT INTO hotels "
            + "(id, hotel_name, grade, latitude, longitude) "
            + "VALUES (DEFAULT, ?, ?, ?, ?) "
            + "ON CONFLICT DO NOTHING";

    public final static String GET_ALL = "SELECT * FROM hotels";

    public final static String GET_BY_ID = GET_ALL + " WHERE id = ?";

    public final static String GET_BY_NAME = GET_ALL + " WHERE hotel_name = ?";

    public final static String UPDATE_BY_ID = "UPDATE hotels SET "
            + "hotel_name = ?, "
            + "grade = ?, "
            + "latitude = ?, "
            + "longitude = ? "
            + "WHERE id = ?";

    public final static String DELETE_BY_ID = "DELETE FROM hotels WHERE id = ?";
}
