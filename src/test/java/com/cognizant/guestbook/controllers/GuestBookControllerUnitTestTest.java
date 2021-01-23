package com.cognizant.guestbook.controllers;

import com.cognizant.guestbook.model.Guest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
class GuestBookControllerUnitTestTest {

    @Test
    public void addGuestUnitTest() {

        Guest expectedGuest = new Guest("Ofe", "Awesome");
        GuestController guestController = new GuestController();
        Guest actualGuest = guestController.addGuest(expectedGuest);
        assertEquals(expectedGuest,actualGuest);

        Guest expectedGuest2 = new Guest("Hema", "Yay");
        Guest actualGuest2 = guestController.addGuest(expectedGuest2);
        assertEquals(expectedGuest2,actualGuest2);
    }

}