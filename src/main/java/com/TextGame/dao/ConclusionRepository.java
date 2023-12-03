package com.TextGame.dao;

import com.TextGame.domain.Conclusion;
import org.springframework.stereotype.Repository;

@Repository
public class ConclusionRepository extends ClueRepository<Conclusion> {

    @Override
    protected Conclusion createInstance(String[] data) {
        Conclusion conclusion = new Conclusion();
        if (data.length >= 3) {
            conclusion.setNumber(Integer.valueOf(data[0]));
            conclusion.setName(data[1]);
            conclusion.setDescription(data[2]);
        }
        return conclusion;
    }

    @Override
    protected int getNumFromItem(Conclusion item) {
        return item.getNumber();
    }
}