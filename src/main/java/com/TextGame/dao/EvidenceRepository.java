package com.TextGame.dao;

import com.TextGame.domain.Evidence;
import org.springframework.stereotype.Repository;

@Repository
public class EvidenceRepository extends ClueRepository<Evidence> {

    @Override
    protected Evidence createInstance(String[] data) {
        Evidence evidence = new Evidence();
        if (data.length >= 5) {
            evidence.setNumber(Integer.valueOf(data[0]));
            evidence.setName(data[1]);
            if ("null".equals(data[2])) {
                evidence.setPhoto(null);
            } else {
                evidence.setPhoto(data[2]);
            }
            evidence.setDescription(data[3]);
            evidence.setLocation(data[4]);
        }
        return evidence;
    }

    @Override
    protected int getNumFromItem(Evidence item) {
        return item.getNumber();
    }
}