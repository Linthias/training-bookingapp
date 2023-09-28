package com.linthias.bookingapp.util;

import com.linthias.bookingapp.dtos.ErrorDto;
import com.linthias.bookingapp.exceptions.DatesAreOccupiedException;
import com.linthias.bookingapp.exceptions.DtoNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(DtoNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleDtoNotValid(DtoNotValidException e, Model model) {
        model.addAttribute("error", new ErrorDto(e.getMessage(), e.getClass().getName(), e.getHttpCode()));
        return "error";
    }

    @ExceptionHandler(DatesAreOccupiedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleDatesOccupied(DatesAreOccupiedException e, Model model) {
        model.addAttribute("error", new ErrorDto(e.getMessage(), e.getClass().getName(), e.getHttpCode()));
        return "error";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleDatesOccupied(Exception e, Model model) {
        model.addAttribute("error", new ErrorDto(e.getMessage(), e.getClass().getName(), 500));
        return "error";
    }
}
