package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

   @Test
    void getChoice() {
       assertEquals(1, Main.getChoice(1));
       assertEquals(2, Main.getChoice(2));


   }
}