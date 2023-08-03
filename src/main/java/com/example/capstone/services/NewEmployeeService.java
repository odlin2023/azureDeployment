package com.example.capstone.services;


import com.example.capstone.model.NewEmployee;
import com.example.capstone.repository.NewEmployeeRepository;
import com.example.capstone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class NewEmployeeService {

    @Autowired
    private NewEmployeeRepository newEmployeeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        NewEmployee newEmployee = userRepository.findByUsername(username);
        if (newEmployee == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(newEmployee.getUsername(), newEmployee.getPassword(),
                new ArrayList<>());
    }




    public NewEmployee findByEmail(String email) {
        return newEmployeeRepository.findByEmail(email);
    }

    public void save(NewEmployee newEmployee) {
        newEmployeeRepository.save(newEmployee);
    }






    public List<NewEmployee> findByRole(String role) {
        return newEmployeeRepository.findByRoleContains(role);
    }

    public NewEmployee findByUsername(String username) {
        String sql = "SELECT username, password, role FROM new_employee WHERE username = ?";
        List<NewEmployee> employees = jdbcTemplate.query(sql, new Object[]{username}, (rs, rowNum) ->
                new NewEmployee(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role") // Retrieve the role as String
                ));
        return employees.isEmpty() ? null : employees.get(0);
    }
    
    public void saveNewEmployee(NewEmployee newEmployee) {
        // Set a default role if required
        if (newEmployee.getRole() == null) {
            newEmployee.setRole("USER");
        }

        newEmployeeRepository.save(newEmployee);
    }


    public NewEmployee registerNewEmployee(NewEmployee newEmployee) {
        return newEmployeeRepository.save(newEmployee);
    }






    // Other methods...
}
