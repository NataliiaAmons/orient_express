package com.example.TextGame.dao;

import com.example.TextGame.domain.Character;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


@Repository
public class CharacterRepository {

    public ArrayList<Character> getAllCharacters() throws IOException {
        ArrayList<Character> allCharacters = new ArrayList<>();
        int i = 1;
        while (true) {
            Character character = getCharacterFromFile(i);
            if(character.getNumber() != i){
                break;
            }
            allCharacters.add(character);
            i++;
        }
        return allCharacters;
    }

    public Character getCharacterFromFile(int characterNumber) throws IOException {
        Character character = new Character();

        Resource resource = new ClassPathResource("static/characters.csv");
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
            if (Integer.valueOf(row[0]) == characterNumber) {
                    character.setNumber(Integer.valueOf(row[0]));
                    character.setName(row[1]);
                    character.setPhoto(row[2]);
                    character.setInfo(row[3]);
            }
        }
            try {
                reader.close();
            }
            catch (IOException e) {}
        return character;
    }



}
