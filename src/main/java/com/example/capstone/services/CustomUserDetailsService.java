package com.example.capstone.services;

import com.example.capstone.model.NewEmployee;
import com.example.capstone.repository.NewEmployeeRepository;
import com.example.capstone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService { // Renamed the class

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NewEmployeeRepository newEmployeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        NewEmployee newEmployee = newEmployeeRepository.findByUsername(username);
        if (newEmployee == null) {
            throw new UsernameNotFoundException("User not found");
        }

        String role = newEmployee.getRole();

        return new org.springframework.security.core.userdetails.User(newEmployee.getUsername(), newEmployee.getPassword(),
                AuthorityUtils.createAuthorityList(role));
    }

}
