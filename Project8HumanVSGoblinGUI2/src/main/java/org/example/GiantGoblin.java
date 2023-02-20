package org.example;

import java.util.Random;

public class GiantGoblin extends Goblin {
    public GiantGoblin() {
        Random random = new Random();
        name = "Giant Goblin";
        health = 20;
        attack = 8;
    }

}
