package org.example;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void guessingGame() {
        int answer = createNum();
        int guess = 0;
        String name = "";
        int play = 0;

        int counter = 1;

        //final int maxNum = 20;
        Scanner scanner = new Scanner(System.in);
        //Random randNum = new Random();

        boolean correct = false;
        //answer = randNum.nextInt(maxNum) + 1;
        System.out.println("Hello! Welcome to the number guessing game! What is your name?");
        try {
            name = scanner.nextLine();
            for (int i = 0; i <name.length();i++) {
                if (!Character.isLetter(name.charAt(i))){
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            System.out.println("Please enter a name that contains no numbers or characters.");
            e.printStackTrace();
            System.exit(1);
        }


        // name = scanner.nextLine();

        System.out.println("Well, " + name + " I am thinking of a number between 1 and 20. \n" +
                "Take a guess.");

        while (!correct ) {


            try {
                guess = scanner.nextInt();
                if(guess < 1 || guess > 20) {
                    throw new Exception();
                }

            } catch (Exception e){
                System.out.println("Please pick a number in the range 1-20.");
                e.printStackTrace();

            }
            //guess = scanner.nextInt();
            if(guess < 1 || guess > 20) {
                System.out.println("Please pick a number in the range 1 - 20.");
            }

            else if (guess > answer) {
                System.out.println("Your guess is too high. \n" +
                        "Take a guess.");
            } else if (guess < answer) {
                System.out.println("Your guess is too low. \n" +
                        "Take a guess.");
            } else {

                System.out.println("Correct! Good job, " + name + " , You guessed my number in " + counter + " guesses! \n");

                System.out.println("Would you like to play again? \n" +
                        "Type 1 for yes. 2 for no.");
                try {
                    play = scanner.nextInt();
                    if(play != 1 && play != 2){
                        throw new Exception();
                    }

                } catch (Exception e) {
                    System.out.println("Please choose either a 1 or a 2. ");
                    e.printStackTrace();
                }
                // play = scanner.nextInt();
                if (play == 1) {
                    guessingGame();
                } else {

                    System.out.println("Thanks for playing!");

                }
                correct = true;
            }

            counter++;

        }




    }
    public static void main(String[] args) {

        guessingGame();

    }
    public static int createNum() {
        Random randNum = new Random();
        final int maxNum = 20;
        return randNum.nextInt(maxNum) + 1;
    }



}