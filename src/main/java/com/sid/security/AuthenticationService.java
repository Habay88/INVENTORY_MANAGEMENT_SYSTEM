package com.sid.security;


import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sid.model.User;
import com.sid.repository.UserRepository;

@Service
public class AuthenticationService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;

    public AuthenticationService(BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
    }

    public boolean authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);

        if (!user.getUsername().equals(username)){
            throw new UsernameNotFoundException("User not found in the database");
        }

        if(user.getPasswordHash().equals(bCryptPasswordEncoder.encode(password))) {
            throw new BadCredentialsException("The password is incorrect");
        }
        return true;
    }

}
