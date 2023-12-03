package com.TextGame.service;

import com.TextGame.dao.EvidenceRepository;
import com.TextGame.dao.LocationRepository;
import com.TextGame.dao.UserRepository;
import com.TextGame.domain.Evidence;
import com.TextGame.domain.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.io.IOException;
import java.util.ArrayList;
@Service
public class MurderSceneService {
    @Autowired
    private EvidenceRepository evidenceRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private UserRepository userRepository;


    public ArrayList<Location> getLocations(int previous) throws IOException {

        ArrayList<Location> locationsFromFile = locationRepository.getAllLocations();
        ArrayList<Location> locations = new ArrayList<>();
        for(Location i: locationsFromFile){
            if (i.getPrevious()==previous) {
                locations.add(i);
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

    public void getAnswerModel(int locationNumber, String text, Model model) throws IOException {

        ArrayList<Evidence> evidences = getLocationEvidence(locationNumber);
        String username = CurrentSessionService.username();
        for (Evidence evidence: evidences) {
            userRepository.addEvidenceToFound(username, evidence.getNumber());
        }

        ArrayList<Location> locations = getLocations(Integer.valueOf(locationNumber));
        model.addAttribute("evidences", evidences);
        model.addAttribute("locations", locations);
        model.addAttribute("text", text);

    }

}
