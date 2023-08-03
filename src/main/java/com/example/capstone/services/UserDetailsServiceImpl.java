package com.example.capstone.services;

import com.example.capstone.model.NewEmployee;
import com.example.capstone.repository.NewEmployeeRepository;
import com.example.capstone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    // Inject your user repository here
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NewEmployeeRepository newEmployeeRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Load user details from your data source (e.g., database)
        NewEmployee newEmployee = newEmployeeRepository.findByUsername(username);
        if (newEmployee == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return User.builder()
                .username(newEmployee.getUsername())
                .password(newEmployee.getPassword())
                .roles(newEmployee.getRole()) // Use the role directly
                .build();
    }

}
