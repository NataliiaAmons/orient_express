package com.TextGame.service;

import com.TextGame.dao.LocationRepository;
import com.TextGame.domain.Evidence;
import com.TextGame.domain.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MurderSceneServiceTest {
    private MurderSceneService murderSceneService;
    @BeforeEach
    public void setUp() {
        murderSceneService = new MurderSceneService();
    }

    @Test
    public void MurderSceneServiceTest_getLocations() throws IOException {

        ArrayList<Location> locations = murderSceneService.getLocations(0);
        assertEquals(locations.size(), 3);
        assertEquals(locations.get(0).getNumber(), 1);
        assertEquals(locations.get(0).getPrevious(), 0);
        assertEquals(locations.get(0).getName(), "Тіло");
        assertEquals(locations.get(0).getText(), " ");
        assertEquals(locations.get(2).getNumber(), 3);
        assertEquals(locations.get(2).getPrevious(), 0);
        assertEquals(locations.get(2).getName(), "Підлога");
        assertEquals(locations.get(2).getText(), " ");
    }

    @Test
    public void MurderSceneServiceTest_getLocationEvidence() throws IOException {

        ArrayList<Evidence> evidences1 = murderSceneService.getLocationEvidence(1);
        assertEquals(evidences1.size(), 2);
        assertEquals(evidences1.get(0).getNumber(), 1);
        assertEquals(evidences1.get(0).getNumber(), 4);

        ArrayList<Evidence> evidences2 = murderSceneService.getLocationEvidence(4);
        assertEquals(evidences2.size(), 1);
        assertEquals(evidences2.get(0).getNumber(), 1);


    }
}