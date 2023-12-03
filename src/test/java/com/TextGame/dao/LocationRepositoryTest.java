    package com.TextGame.dao;

import com.TextGame.viewmodel.LocationVM;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.TextGame.dao.LocationRepository;

    public class LocationRepositoryTest {

        @Autowired
        private LocationRepository locationRepository;

        @Test
        public void LocationRepositoryTest_getAllLocations() throws IOException {
            ArrayList<LocationVM> allLocations = locationRepository.getAllLocations();
            assertEquals(allLocations.get(0).getNumber(), 1);
            assertEquals(allLocations.get(0).getPrevious(), 0);
            assertEquals(allLocations.get(0).getName(), is("Тіло"));
            assertEquals(allLocations.get(0).getText(), is("текст1"));
            assertEquals(allLocations.get(0).getNumber(), 4);
            assertEquals(allLocations.get(0).getPrevious(), 2);
            assertEquals(allLocations.get(0).getName(), is("Армстрон"));
            assertEquals(allLocations.get(0).getText(), is("текст4"));
        }
    }
