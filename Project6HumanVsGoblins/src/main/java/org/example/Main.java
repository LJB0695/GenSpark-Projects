package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            Land land = new Land();
            land.GameBoardCreation();


            HashMap<Integer, int[]> humanCoordinates = new HashMap<>();
            land.addingElement(1,humanCoordinates," H ");
            Human human = new Human(10, 5, humanCoordinates.get(0)[0], humanCoordinates.get(0)[0], "Human");
            String[] weapon = {"no item"};

            Treasure treasure = new Treasure();
            HashMap<Integer, int[]> treasureLocation = new HashMap<>();
            land.addingElement(1, treasureLocation, "**e");
            for (int i = 0; i < treasureLocation.size(); i++) {
                land.treasureChestArray2.add(new Treasure(treasure.treasureChestArray(), treasureLocation.get(i)[0], treasureLocation.get(i)[1]));

            }

            HashMap<Integer, int[]> goblinLocation = new HashMap<>();
            land.addingElement(10, goblinLocation, " G ");
            for (int i = 0; i < goblinLocation.size(); i++) {
                land.goblinArray.add(new Goblin(land.randomNum(2, 8), land.randomNum(2, 6), goblinLocation.get(i)[0], goblinLocation.get(i)[1], land.goblinNameGenerator(), land.goblinMovementMechanics() ));

            }

            System.out.println("Welcome to the Human vs Goblins game!");
            System.out.println("Kill all of the goblins before you die.");
            System.out.println("Controls: type n to move up, s to move down, e to move to the right, and w to move to the left.");
            System.out.println("Press any key to continue to the game.");
            scanner.next();
            System.out.println(land.toString(land.grid));
            boolean playGame = true;

            while (playGame) {
                boolean alive = true;
                System.out.println("The " + human.name + " 's health is " + human.health + " and their strength is " + human.strength + " .");
                if (!human.inventorySystem.isEmpty()) {
                    System.out.println("Your inventory contains: " + human.printInventoryItem(human.inventorySystem));
                }

                System.out.println("Please make a move.");
                String input = scanner.next();
                System.out.println(human.humanMovement(land.grid, humanCoordinates, input));

                if (land.testElement(treasureLocation, humanCoordinates)) {
                    Treasure treasure2 = land.getTreasureItems(humanCoordinates, land.treasureChestArray2);
                    String s = treasure2.itemsInTreasureChest[land.randomNum(0, 30)];
                    if(!human.checkForHealthSerum(s, treasure2, human, land, scanner)) {
                        playGame = false;
                    }
                    land.elementRemoval(treasureLocation, humanCoordinates);
                }

                if (land.testElement(goblinLocation, humanCoordinates)) {
                    Goblin goblin = land.goblinFightMechanics(humanCoordinates, land.goblinArray);
                    System.out.println("human's health is " + human.health + " " + goblin.name + " has " + goblin.health + " health.");
                    System.out.println();

                    if (!human.inventorySystem.isEmpty()) {
                        System.out.println("Your inventory contains: " + human.printInventoryItem(human.inventorySystem));
                        System.out.println("Would you like to use any of these items? (y/n).");
                        String answer = scanner.next();

                        if(answer.equalsIgnoreCase("y")) {
                            while(weapon[0].equals("no item")) {
                                System.out.println("Which item do you want to use?");
                                System.out.println("Your inventory contains: " + human.printInventoryItem(human.inventorySystem));
                                String item = scanner.next();
                                System.out.println(human.useTheItem(item, human, goblin, weapon));
                            }
                            System.out.println("Press any button to continue.");
                            scanner.next();
                        }
                    }
                    while (alive) {
                        System.out.println(human.attackGoblin(human, goblin));
                        if (goblin.health > 0) {
                            System.out.println("human's health is " + human.health + " . " + goblin.name + " 's health is " + goblin.health + " .");
                            System.out.println("Press any button to continue.");
                            scanner.next();
                        }else {
                            System.out.println("You killed the goblin " + goblin.name + " .");
                            if(land.checkToSeeIfYouWon(goblinLocation)) {
                                System.out.println("You won! All of the goblins have been killed!");
                                playGame = false;
                                break;
                            }
                            if (!weapon[0].equals("no item")) {
                                human.removeInventoryItem(human, weapon);
                            }
                            System.out.println("Human's health is " + human.health + " and their strength is " + human.strength + " .");
                            land.elementRemoval(goblinLocation, humanCoordinates);
                            land.grid.get(human.row)[human.col] = " H ";

                            int t = treasureLocation.size();
                            land.addingElement(1, treasureLocation, "**");
                            land.treasureChestArray2.add(new Treasure(treasure.treasureChestArray(), treasureLocation.get(t)[0], treasureLocation.get(t)[1]));
                            System.out.println("Press any button to continue");
                            scanner.next();
                            System.out.println(land.toString(land.grid));
                            break;
                        }
                        System.out.println(goblin.attackHuman(goblin,human));
                        if (human.health > 0) {
                            System.out.println("Human's health is " + human.health + " and the " + goblin.name + " 's health is " + goblin.health + " .");
                            System.out.println("Press any button to continue.");
                            scanner.next();
                        }else {
                            System.out.println("You have unfortunately lost the game.");
                            alive = false;
                            playGame = false;
                        }
                    }


                }
            }
            System.out.println("Would you like to play the game again?");
            String answer1 = scanner.next();
            if(!answer1.equals("y")) {
                System.out.println("Ok, Thank you for playing human vs Goblins.");
                playAgain = false;
            }



        }

    }
}