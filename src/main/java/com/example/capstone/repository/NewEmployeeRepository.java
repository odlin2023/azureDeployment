package com.example.capstone.repository;

import com.example.capstone.model.NewEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NewEmployeeRepository extends JpaRepository<NewEmployee, Long> {
    NewEmployee findByUsername(String username);

    NewEmployee findByEmail(String email);

    List<NewEmployee> findByRoleContains(String role);




}
