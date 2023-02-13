package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void testFile() {
        File file = new File("C:/Users/barre/Project7HangmanFunctional/src/main/java/org/example/words1.txt");
        assertTrue(file.exists());
    }
    @Test
    public void testNewFile () {
        File file = new File("C:/Users/barre/Project7HangmanFunctional/src/main/java/org/example/scores1.txt");
        assertTrue(file.exists());
    }

}