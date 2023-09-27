package com.linthias.bookingapp.controllers;

import com.linthias.bookingapp.dtos.RoomDto;
import com.linthias.bookingapp.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService service;

    @GetMapping("/{roomId}")
    public String getOne(@PathVariable Long roomId, Model model) {
        model.addAttribute("room", service.getById(roomId));
        return "room";
    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('MANAGER')")
    public String create(RoomDto room, Model model) {
        model.addAttribute("room", service.add(room));
        return "room";
    }

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('MANAGER')")
    public String update(RoomDto room, Model model) {
        model.addAttribute("room", service.update(room));
        return "room";
    }
}
