package com.TextGame.service;

import com.TextGame.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    private final Path workingDir = Path.of("", "src/main/resources/users/");

    public void createUserFiles(String username) throws IOException {
        userRepository.createUserFiles(username);
    }

    public boolean checkIfUsernameIsAvailable(String username) throws IOException {
        Path path = this.workingDir.resolve(username + "evidence.csv");
        boolean exists = Files.exists(path);

        return !exists;
    }

    public boolean isValidUsername(String username) {
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{3,19}$";

        Pattern p = Pattern.compile(regex);
        if (username == null) {
            return false;
        }
        Matcher m = p.matcher(username);

        return m.matches();
    }

    public String usernameAlert(String username) throws IOException {
        String alert = null;
        if (!isValidUsername(username)) {
            return "Ім'я має бути не коротшим з 4 знаків. Може включати: латинські літери; цифри (цифра не може стояти на першому місці); нижнє підкреслення '_' ";
        }
        else {
            try {
                if (!checkIfUsernameIsAvailable(username)) {
                    return "Це ім'я вже використовується. Ви впевнені що це були ви?";}
            }
            catch (IOException e) { throw new IOException(e);}
        }
        return "";
    }
}
