package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("You are in a land full of dragons. In front of you, \n" +
                "you see two caves. In one cave, the dragon is friendly \n" +
                "and will share his treasure with you. The other dragon \n" +
                "is greedy and hungry and will eat you on sight. \n" +
                "Which cave will you go into? (1 or 2)\n");

        //int choice = scanner.nextInt();
        int choice = 0;

        try {
            choice = scanner.nextInt();

            if (choice != 1 && choice != 2) {
                throw new Exception();
            }

        } catch (Exception e) {
            System.out.println("INVALID INPUT: Please enter a 1 or a 2.");
            e.printStackTrace();
        }






        if (choice == 1) {
            System.out.println("You approach the cave... \n " +
                    "It is dark and spooky... \n" +
                    "A large dragon jumps out in front of you! He opens his jaws and... \n" +
                    "Gobbles you down in one bite! You picked the wrong cave! \n");
        } else if (choice == 2) {
            System.out.println("You approach the cave... \n " +
                    "It is dark and spooky... \n" +
                    "A large dragon jumps out in front of you! He opens his jaws and... \n" +
                    "Offers to share their gold with you! You picked the right cave! \n");
        } /*else {

        }*/


    }
}

