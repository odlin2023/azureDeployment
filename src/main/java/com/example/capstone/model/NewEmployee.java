package com.example.capstone.model;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "new_employee")
@Getter
@Setter
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
    private List<String> roles;

    public List<String> getRoles() {
        return roles;
    }

    public NewEmployee(String username, String password, List<String> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public NewEmployee() {
    }


}

