package com.example.capstone.services;


import com.example.capstone.model.NewEmployee;
import com.example.capstone.model.Ticket;
import com.example.capstone.repository.NewEmployeeRepository;
import com.example.capstone.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TicketService {
@Autowired
    private final TicketRepository ticketRepository;
@Autowired
    private final NewEmployeeRepository newEmployeeRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository, NewEmployeeRepository newEmployeeRepository) {
        this.ticketRepository = ticketRepository;
        this.newEmployeeRepository = newEmployeeRepository;
    }
    public TicketService(NewEmployeeRepository newEmployeeRepository, TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
        this.newEmployeeRepository = newEmployeeRepository;
    }

    public Optional<Ticket> getTicket(Long id) {
        return ticketRepository.findById(id);
    }

    public Iterable<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public void addTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }


    public void updateTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }



    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }


    public Long countTicketsByStatus(String status) {
        return ticketRepository.countByStatus(status);
    }

    public List<Ticket> searchByName(String name) {
        return ticketRepository.findByNameContaining(name);
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ticket not found"));
    }

    public List<Ticket> searchTickets(String searchTerm) {
        return ticketRepository.search(searchTerm);
    }

    public void deleteTicketsInBulk(List<Long> ids) {
        ticketRepository.deleteByIdIn(ids);
    }

    public void deleteTickets(List<Long> ids) {
        ticketRepository.deleteByIdIn(ids);
    }
    
    public List<NewEmployee> getEmployeesByRole(String role) {
        return newEmployeeRepository.findByRoleContains(role);
    }




}
