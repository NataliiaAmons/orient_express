package com.TextGame.dao;

import com.TextGame.domain.Location;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@Repository
public class LocationRepository {
    public ArrayList<Location> getAllLocations() throws IOException {
        ArrayList<Location> allLocations = new ArrayList<>();

        Resource resource = new ClassPathResource("static/locations.csv");
        File file = resource.getFile();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        String line = "";

        while ((line = reader.readLine()) != null){
            String[] row = line.split(";");
            Location location = new Location(Integer.valueOf(row[0]), Integer.valueOf(row[1]), row[2], row[3]);
             allLocations.add(location);
        }
        try {
            reader.close();
        }
        catch (IOException e) {}
        return allLocations;
    }
}
