package com.linthias.bookingapp.services;

import com.linthias.bookingapp.models.User;
import com.linthias.bookingapp.repositories.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final BaseRepository<User> repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userModel = repository.findByName(username);
        return new org.springframework.security.core.userdetails.User(
                userModel.getUserName(),
                userModel.getPassword(),
                Collections.singletonList(userModel.getRole()));
    }
}
