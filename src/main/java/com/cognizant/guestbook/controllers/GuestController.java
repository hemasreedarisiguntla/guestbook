package com.cognizant.guestbook.controllers;

import com.cognizant.guestbook.model.Guest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GuestController {

    List<Guest> guestList;

    public GuestController() {
        this.guestList = new ArrayList<>();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/guest")
    public Guest addGuest(@RequestBody Guest guest) {
        guestList.add(guest);
        return guest;
    }

    public List<Guest> getAllGuests() {
        return guestList;
    }
}
