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

/*
    public Character[] getCharactersFromFile() throws IOException {
        Resource resource = new ClassPathResource("static/characters.csv");
        File file = resource.getFile();
        BufferedReader reader = null;
        String line = "";

        Character character1 = new Character();
        Character character2 = new Character();
        Character character3 = new Character();
        Character character4 = new Character();
        Character character5 = new Character();
        Character character6 = new Character();
        Character character7 = new Character();
        Character character8 = new Character();

        Question[] questions = new Question().getQuestionsFromFile();

        Character[] characters = {character1, character2, character3, character4, character5, character6, character7, character8};
        int i = 0;

        try {
            reader = new BufferedReader(new FileReader(file));

            while ((line = reader.readLine()) != null) {
                String[] row = line.split(";");

                characters[i].setNumber(Integer.valueOf(row[0]));
                characters[i].setName(row[1]);
                characters[i].setPhoto(row[2]);
                characters[i].setInfo(row[3]);
                characters[i].setQuestions(questions);

                i++;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            }
            catch (IOException e) {}
        }
        return characters;
    }
*/
}
