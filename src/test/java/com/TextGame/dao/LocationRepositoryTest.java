    package com.TextGame.dao;

import com.TextGame.viewmodel.LocationVM;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.TextGame.dao.LocationRepository;

    public class LocationRepositoryTest {

        private LocationRepository locationRepository;

        @BeforeEach
        public void setUp() {
            locationRepository = new LocationRepository();
        }

        @Test
        public void LocationRepositoryTest_getAllLocations() throws IOException {
            ArrayList<LocationVM> allLocations = locationRepository.getAllLocations();
            assertEquals(allLocations.get(0).getNumber(), 1);
            assertEquals(allLocations.get(0).getPrevious(), 0);
            assertEquals(allLocations.get(0).getName(), "Тіло");
            assertEquals(allLocations.get(0).getText(), " ");
            assertEquals(allLocations.get(3).getNumber(), 4);
            assertEquals(allLocations.get(3).getPrevious(), 2);
            assertEquals(allLocations.get(3).getName(), "Армстронг");
            assertEquals(allLocations.get(3).getText(), "текст");
        }
    }
