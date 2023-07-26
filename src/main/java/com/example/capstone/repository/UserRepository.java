package com.example.capstone.repository;

import com.example.capstone.model.NewEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<NewEmployee, Long> {
    NewEmployee findByUsername(String username);
}
