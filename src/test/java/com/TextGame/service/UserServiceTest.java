package com.TextGame.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Path;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void UserService_checkIfUsernameIsAvailable_True() throws IOException {
        boolean available = userService.checkIfUsernameIsAvailable("does-not-exist");
        assertThat(available, is(true));

    }
    @Test
    public void UserService_checkIfUsernameIsAvailable_False() throws IOException {

        boolean available = userService.checkIfUsernameIsAvailable("test");
        assertThat(available, is(false));

    }
    @Test
    public void UserService_isValidUsername_False(){
        boolean ifValid = userService.isValidUsername("usern0-_-34??");
        assertThat(ifValid, is(false));
    }
    @Test
    public void UserService_isValidUsername_True(){
        boolean ifValid = userService.isValidUsername("usern0_34");
        assertThat(ifValid, is(true));
    }
    @Test
    public void UserService_isValidUsername_Short(){
        boolean ifValid = userService.isValidUsername("ser");
        assertThat(ifValid, is(false));
    }
}
