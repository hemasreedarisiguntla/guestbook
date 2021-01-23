package com.cognizant.guestbook.controllers;

import com.cognizant.guestbook.model.Guest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuestController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/guest")
    public Guest addGuest(@RequestBody Guest guest) {
        return guest;
    }
}
