package com.linthias.bookingapp.controllers;

import com.linthias.bookingapp.dtos.HotelInputDto;
import com.linthias.bookingapp.services.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService service;

    @GetMapping("/menu")
    public String getMenu() {
        return "hotel-menu";
    }

    @GetMapping("/{hotelId}")
    public String getOne(@PathVariable Long hotelId, Model model) {
        model.addAttribute("hotel", service.getById(hotelId));
        return "hotel";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("hotels", service.getAll());
        return "hotel-list";
    }

    @GetMapping("/search")
    public String getSpecific(LocalDate bookingStart, LocalDate bookingEnd, Model model) {
        model.addAttribute("hotels", service.getAvailable(bookingStart, bookingEnd));
        return "hotel-list";
    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('MANAGER')")
    public String create(HotelInputDto hotel, Model model) {
        model.addAttribute("hotel", service.add(hotel));
        return "hotel";
    }

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('MANAGER')")
    public String update(HotelInputDto hotel, Model model) {
        model.addAttribute("hotel", service.update(hotel));
        return "hotel";
    }
}
