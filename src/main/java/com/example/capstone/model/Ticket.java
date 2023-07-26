package com.example.capstone.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    @Column(name = "name")
    private String name;
    private String department;
    private String phoneNumber;
    private String email;
    private String assignedTickets;
    private String content;
    private String sender;
    private String receiver;
    private LocalDateTime time;
    private String priority;
    @Column(nullable = false, unique = true)
    private String description;

    public Ticket() {
    }

    public Ticket(String status, String name, String department, String phoneNumber, String email,
                  String assignedTickets, String content, String sender, String receiver, LocalDateTime time, String priority) {
        this.status = status;
        this.name = name;
        this.department = department;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.assignedTickets = assignedTickets;
        this.content = content;
        this.sender = sender;
        this.receiver = receiver;
        this.time = time;
        this.priority = priority;
    }
}
