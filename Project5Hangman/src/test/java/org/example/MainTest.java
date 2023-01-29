package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void testFile() {
        File file = new File("C:/Users/barre/Project5Hangman/src/main/java/org/example/words.txt");
        assertTrue(file.exists());
    }





}