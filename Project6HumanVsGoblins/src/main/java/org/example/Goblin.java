package org.example;

public class Goblin {
    int health;
    int strength;
    int row;
    int col;
    String name;


    Goblin(int health, int strength, int row, int col, String name, boolean move) {
        this.health = health;
        this.strength = strength;
        this.row = row;
        this.col = col;
        this.name = name;
    }

    Goblin() {

    }

    //Creating an attack method for the goblin.
    public String attackHuman(Goblin goblin, Human human) {
        double x = 1 + Math.random() * goblin.strength;
        int strengthPower = (int) x;
        human.health = human.health - strengthPower;
        return goblin.name + " attacked " + human.name + " for a hit of " + strengthPower + " damage!";
    }

}
