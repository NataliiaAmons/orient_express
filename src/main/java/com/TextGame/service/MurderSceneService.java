package com.TextGame.service;

import com.TextGame.dao.EvidenceRepository;
import com.TextGame.domain.Evidence;
import com.TextGame.viewmodel.LocationVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
@Service
public class MurderSceneService {
    @Autowired
    private EvidenceRepository evidenceRepository;


    public ArrayList<LocationVM> getLocations(int previous){

        String[][] locationsFromFile = new String[][]{{"1", "0", "Тіло", "текст1"}, {"2", "0", "Стіл", "текст2"}, {"3", "0","Підлога", "текст3"},  {"4", "2","Армстроноu", "текст4"}};
        ArrayList<LocationVM> locations = new ArrayList<>();
        for(String[] i: locationsFromFile){
            if (Integer.valueOf(i[1])==previous) {
                LocationVM l = new LocationVM(Integer.valueOf(i[0]), Integer.valueOf(i[1]), i[2], i[3]);
                locations.add(l);
            }
        }
        return locations;
    }
    public ArrayList<Evidence> getLocationEvidence(int location) throws IOException {
        ArrayList<Evidence> locationEvidence = new ArrayList<>();
        ArrayList<Evidence> allEvidence = evidenceRepository.getAllItems("evidence.csv");
        for(Evidence evidence: allEvidence){
            if(Integer.valueOf(evidence.getLocation())==location){
                locationEvidence.add(evidence);
            }
        }
        return locationEvidence;
    }


}
