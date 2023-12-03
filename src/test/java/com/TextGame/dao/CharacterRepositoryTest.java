package com.TextGame.dao;

import com.TextGame.domain.Character;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class CharacterRepositoryTest {
    @Autowired
    private CharacterRepository characterRepository;

    @Test
    public void CharacterRepository_getCharaterFromFile() throws IOException {
        Character character = characterRepository.getCharacterFromFile(5);
        assertThat(character.getNumber(), is(5));
        assertThat(character.getName(), is("провідник П'єр Мішель"));
        assertThat(character.getInfo(), is("Провідник, який працює на Східному експресі."));
        assertThat(character.getPhoto(), is("character5.png"));
    }

    @Test
    public void QuestionRepository_getAllQusertions() throws IOException {
        ArrayList<Character> characters = characterRepository.getAllCharacters();
        Character character5 = characters.get(4);
        assertThat(character5.getNumber(), is(5));
        assertThat(character5.getName(), is("провідник П'єр Мішель"));
        assertThat(character5.getInfo(), is("Провідник, який працює на Східному експресі."));
        assertThat(character5.getPhoto(), is("character5.png"));

    }
}
