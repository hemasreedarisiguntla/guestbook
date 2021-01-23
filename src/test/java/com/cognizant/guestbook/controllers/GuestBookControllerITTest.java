package com.cognizant.guestbook.controllers;

import com.cognizant.guestbook.model.Guest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class GuestBookControllerITTest {

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
        Guest guest = new Guest("Ofe", "Awesome");
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

    @Test
    public void getAllGuests() throws Exception {
        Guest ofe = new Guest("Ofe", "Awesome");
        Guest hema = new Guest("Hema", "Yay");
        mockMvc.perform(post("/guest").
                content(objectMapper.writeValueAsString(ofe))
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isCreated())
        ;
        mockMvc.perform(post("/guest").
                content(objectMapper.writeValueAsString(hema))
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isCreated())
        ;

        mockMvc.perform(get("/guest"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").isNotEmpty())
                .andExpect(jsonPath("$[0].name").value(ofe.getName()))
                .andExpect(jsonPath("$[1].comment").value(hema.getComment()))
        ;
    }
}
