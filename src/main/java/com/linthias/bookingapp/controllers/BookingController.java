package com.linthias.bookingapp.controllers;

import com.linthias.bookingapp.dtos.BookingInputDto;
import com.linthias.bookingapp.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService service;

    @GetMapping("/menu")
    public String getMenu() {
        return "booking-menu";
    }

    @GetMapping("/{bookingId}")
    public String getOne(@PathVariable Long bookingId, Model model) {
        model.addAttribute("booking", service.getById(bookingId));
        return "booking";
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('MANAGER')")
    public String getAll(Model model) {
        model.addAttribute("bookings", service.getAll());
        return "booking-list";
    }

    @GetMapping("/mine")
    public String getMyBookings(String user, Model model) {
        model.addAttribute("bookings", service.getMyBookings(user));
        return "booking-list";
    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('MANAGER')")
    public String create(BookingInputDto booking, Model model) {
        model.addAttribute("booking", service.add(booking));
        return "booking";
    }

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('MANAGER')")
    public String update(BookingInputDto booking, Model model) {
        model.addAttribute("booking", service.update(booking));
        return "booking";
    }
}
