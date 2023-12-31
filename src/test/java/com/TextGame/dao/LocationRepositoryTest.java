    package com.TextGame.dao;

import com.TextGame.domain.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

    public class LocationRepositoryTest {

        private LocationRepository locationRepository;

        @BeforeEach
        public void setUp() {
            locationRepository = new LocationRepository();
        }

        @Test
        public void LocationRepositoryTest_getAllLocations() throws IOException {
            ArrayList<Location> allLocations = locationRepository.getAllLocations();
            assertEquals(allLocations.get(0).getNumber(), 1);
            assertEquals(allLocations.get(0).getPrevious(), 0);
            assertEquals(allLocations.get(0).getName(), "Оглянути тіло");
            assertEquals(allLocations.get(0).getText(), " ");
            assertEquals(allLocations.get(3).getNumber(), 4);
            assertEquals(allLocations.get(3).getPrevious(), 2);
            assertEquals(allLocations.get(3).getName(), "Детільніше про Дейзі Армстронг");
        }
    }
