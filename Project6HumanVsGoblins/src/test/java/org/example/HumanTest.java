package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {
    Human human;
    Goblin goblin;





    @Test
    void setUp() {
        human = new Human();

    }

    @Test
    void attack() {

        assertEquals("Human attacked goblin.", human.attackGoblin(human,  goblin));
    }











}