package com.cognizant.guestbook.controllers;

import com.cognizant.guestbook.model.Guest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class GuestBookControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    /**
     * Any visitor can post their name and a comment to the Guestbook.
     * POST /guest 201 CREATED --> posts a guest object containing name and comment
     */
    @Test
    public void addGuest() throws Exception {
        Guest guest = new Guest("Ofe","Awesome");
        mockMvc.perform(post("/guest").
                content(objectMapper.writeValueAsString(guest))
                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(guest)))
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.name").value(guest.getName()))
                .andExpect(jsonPath("$.comment").value(guest.getComment()));
    }

}
