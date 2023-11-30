package com.example.TextGame.dao;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserRepositoryTest {

        private Path workingDir = Path.of("", "src/main/resources/static");



        @Test
        public void read() throws IOException {

            Path file = this.workingDir.resolve("test.file");
            String content = Files.readString(file);
            assertThat(content, is("duke"));
        }

}
