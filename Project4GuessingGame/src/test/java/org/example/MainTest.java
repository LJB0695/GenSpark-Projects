package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {



    @Test
    void createNum() {
        int guess = Main.createNum();
        assertTrue(1 <= guess && guess <= 20);
    }


    @Test
    void guessingGame() {
        String name = "name";
        for (int i = 0; i < name.length(); i++) {
            assertTrue(Character.isLetter(name.charAt(i)));
        }
        int play = 1;
        assertTrue(play == 1 || play == 2);

    }




}