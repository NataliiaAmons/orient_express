package com.TextGame.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocationTest {
    @Test
    public void LocationCoustructor(){
        Location location = new Location(1, 2, "name", "text");

        assertEquals(1, location.getNumber());
        assertEquals(2, location.getPrevious());
        assertEquals("name", location.getName());
        assertEquals("text", location.getText());

    }
}
