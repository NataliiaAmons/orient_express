package com.example.TextGame.dao;

import com.example.TextGame.domain.Character;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;


@Repository
public class CharacterRepository extends FileRepository{


    public ArrayList<Character> getAllCharacters() throws IOException {
        ArrayList<Character> allCharacters = new ArrayList<>();
        int i = 1;
        while (true) {
            Character character = getCharacterFromFile(i);
            if(character == null){
                break;
            }
            allCharacters.add(character);
            i++;
        }
        return allCharacters;
    }

    public Character getCharacterFromFile(int characterNumber) throws IOException {
        Character character = new Character();
        BufferedReader reader = super.getDataFromFile("static/characters.csv");
        String line = "";
        if ((line = reader.readLine()) != null){
            String[] row = line.split(";");
            if (Integer.valueOf(row[0]) == characterNumber) {
                    character.setNumber(Integer.valueOf(row[0]));
                    character.setName(row[1]);
                    character.setPhoto(row[2]);
                    character.setInfo(row[3]);
            }
        }
        else{ return null;}
        return character;
    }

}
