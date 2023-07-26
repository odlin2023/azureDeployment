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

    Optional<NewEmployee> findByDescription(String description);

    List<NewEmployee> findByRolesContains(String role);



    // NewEmployee findByUniqueIdentifier(String uniqueIdentifier);
    // Remove this line or add a field called uniqueIdentifier in the NewEmployee class
}
