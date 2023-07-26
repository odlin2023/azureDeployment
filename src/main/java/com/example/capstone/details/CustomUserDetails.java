package com.example.capstone.details;


import com.example.capstone.model.NewEmployee;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private boolean accountNonExpired;

    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, boolean accountNonExpired) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.accountNonExpired = accountNonExpired;
    }

    public CustomUserDetails(NewEmployee newEmployee) {
        this.username = newEmployee.getUsername();
        this.password = newEmployee.getPassword();
        // Set authorities based on newEmployee roles/permissions if needed
    }

    public CustomUserDetails(User newEmployee) {
    }




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    // Implement other UserDetails methods

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
