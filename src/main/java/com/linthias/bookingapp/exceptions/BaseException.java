package com.linthias.bookingapp.exceptions;

import lombok.Getter;

@Getter
public class BaseException extends Exception {
    protected Integer httpCode;

    public BaseException(String message) {
        super(message);
        httpCode = 500;
    }
}
