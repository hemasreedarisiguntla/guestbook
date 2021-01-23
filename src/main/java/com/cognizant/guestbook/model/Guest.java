package com.cognizant.guestbook.model;

import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Guest {

    private String name;
    private String comment;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return Objects.equals(name, guest.name) && Objects.equals(comment, guest.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, comment);
    }
}
