package com.cognizant.guestbook.controllers;

import com.cognizant.guestbook.model.Guest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/guest")
public class GuestController {

    private List<Guest> guestList;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Guest addGuest(@RequestBody Guest guest) {
        if (this.guestList == null) {
            this.guestList = new ArrayList<>();
        }

        guestList.add(guest);
        return guest;
    }

    @GetMapping
    public List<Guest> getAllGuests() {
        return guestList;
    }
}
