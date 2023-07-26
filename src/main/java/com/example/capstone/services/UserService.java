package com.example.capstone.services;

import org.springframework.stereotype.Service;
import com.example.capstone.model.NewEmployee;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class UserService {

    private Map<String, NewEmployee> employees = new HashMap<>();



    public NewEmployee findByUsername(String username) {
        return this.employees.get(username);
    }

    public void saveUser(NewEmployee employee) {
        employees.put(employee.getUsername(), employee);
    }
}

