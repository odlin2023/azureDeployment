package com.example.capstone.model;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "new_employee")
@Getter
@Setter
@NoArgsConstructor
public class NewEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;  // Changed type from int to Long

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String confirmed_password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String email;

    private String description;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles = new HashSet<>();

    public Set<String> getRoles() {
        return roles;
    }


}

