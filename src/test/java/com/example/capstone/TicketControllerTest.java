package com.example.capstone;


import com.example.capstone.model.Ticket;
import com.example.capstone.services.TicketService;
import com.example.capstone.services.NewEmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class TicketControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TicketService ticketService;

    @MockBean
    private NewEmployeeService newEmployeeService;

    @Test
    public void testAddTicketForm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/ticket/add"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("ticket"))
                .andExpect(MockMvcResultMatchers.view().name("add-ticket"));
    }

    @Test
    public void testAddTicket() throws Exception {
        Ticket ticket = new Ticket();
        ticket.setName("Test Ticket");

        mockMvc.perform(MockMvcRequestBuilders.post("/ticket/add")
                        .flashAttr("ticket", ticket))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/tickets"));

        Mockito.verify(ticketService, Mockito.times(1)).addTicket(Mockito.any(Ticket.class));
    }

}
