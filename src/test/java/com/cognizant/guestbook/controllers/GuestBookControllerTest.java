package com.cognizant.guestbook.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class GuestBookControllerTest {

    @Autowired
    MockMvc mockMvc;

    /**
     * Any visitor can post their name and a comment to the Guestbook.
     * POST /guest 201 CREATED --> posts a guest object containing name and comment
     */
    @Test
    public void addGuest() throws Exception {
        mockMvc.perform(post("/guest"))
                .andExpect(status().isCreated());
    }

}
