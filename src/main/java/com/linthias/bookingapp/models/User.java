package com.linthias.bookingapp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {
    private Long id;
    private String userName;
    private String password;
    //private Boolean isManager;
    private Role role;
}
