package com.linthias.bookingapp.exceptions;

public class DatesAreOccupiedException extends BaseException {
    public DatesAreOccupiedException(String message) {
        super(message);
        httpCode = 400;
    }
}
