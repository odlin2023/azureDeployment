package com.example.capstone.services;


import com.example.capstone.exceptions.DuplicateDescriptionException;
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




    private boolean descriptionExists(String description) {
        return newEmployeeRepository.findByDescription(description).isPresent();
    }



    public NewEmployee registerNewEmployee(NewEmployee newEmployee) {
        // Optional: If description is null or empty, set it to an empty string
        if (newEmployee.getDescription() == null) {
            newEmployee.setDescription("");
        }

        // Save the employee record
        return newEmployeeRepository.save(newEmployee);
    }


    public List<NewEmployee> findByRole(String role) {
        return newEmployeeRepository.findByRolesContains(role);
    }

    public NewEmployee findByUsername(String username) {
        String sql = "SELECT username, password, role FROM new_employee WHERE username = ?";
        List<NewEmployee> employees = jdbcTemplate.query(sql, new Object[]{username}, (rs, rowNum) ->
                new NewEmployee(
                        rs.getString("username"),
                        rs.getString("password"),
                        Collections.singletonList(rs.getString("role"))
                ));
        return employees.isEmpty() ? null : employees.get(0);
    }



    // Other methods...
}
