package com.cognizant.guestbook.controllers;

import com.cognizant.guestbook.model.Guest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
class GuestBookControllerUnitTest {

   private GuestController guestController;

   @BeforeEach
   public void init(){
       guestController = new GuestController();
   }

    @Test
    public void addGuestUnitTest() {

        Guest expectedGuest = new Guest("Ofe", "Awesome");

        Guest actualGuest = guestController.addGuest(expectedGuest);
        assertEquals(expectedGuest,actualGuest);

        Guest expectedGuest2 = new Guest("Hema", "Yay");
        Guest actualGuest2 = guestController.addGuest(expectedGuest2);
        assertEquals(expectedGuest2,actualGuest2);
    }

    @Test
    public  void getAllGuestsUnitTest(){

        List<Guest> actual = guestController.getAllGuests();

        Guest ofe = new Guest("Ofe", "Awesome");
        Guest hema = new Guest("Hema", "Yay");
        guestController.addGuest(ofe);
        guestController.addGuest(hema);

        List<Guest> expected = new ArrayList<>();
        expected.add(ofe);
        expected.add(hema);

        assertEquals(expected, actual);


    }

}