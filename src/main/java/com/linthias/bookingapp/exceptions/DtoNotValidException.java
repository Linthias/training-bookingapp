package com.linthias.bookingapp.exceptions;

public class DtoNotValidException extends BaseException {
    public DtoNotValidException(String message) {
        super(message);
        httpCode = 400;
    }
}
