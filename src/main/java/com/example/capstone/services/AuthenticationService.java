package com.example.capstone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.capstone.model.NewEmployee;

@Service
public class AuthenticationService {
    @Autowired
    private final UserService userService;
@Autowired
    public AuthenticationService(UserService userService) {
        this.userService = userService;
    }

    public NewEmployee authenticate(String username, String password) {
        NewEmployee employee = userService.findByUsername(username);
        if (employee != null && employee.getPassword().equals(password)) {
            return employee;
        } else {
            throw new RuntimeException("Invalid username or password");
        }
    }
}

