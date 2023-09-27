package com.linthias.bookingapp.validators;

import java.time.LocalDate;

public abstract class BaseValidator<E> {
    public abstract boolean isValid(E entity);

    protected boolean isBlankString(String input) {
        return input == null || input.isBlank();
    }

    protected boolean isValidDate(LocalDate date) {
        return date.isBefore(LocalDate.now());
    }
}
