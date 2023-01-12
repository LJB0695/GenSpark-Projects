package org.example;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void guessingGame() {
        int answer;
        int guess;
        int counter = 1;

        final int maxNum = 20;
        Scanner scanner = new Scanner(System.in);
        Random randNum = new Random();

        boolean correct = false;
        answer = randNum.nextInt(maxNum) + 1;
        System.out.println("Hello! Welcome to the number guessing game! What is your name?");
        String name = scanner.nextLine();

        System.out.println("Well, " + name + " I am thinking of a number between 1 and 20. \n" +
                "Take a guess.");

        while (!correct) {


            guess = scanner.nextInt();
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
                int play = scanner.nextInt();
                if (play == 1) {
                    guessingGame();
                }else {

                    System.out.println("Thanks for playing!");
                }
               correct = true;



            }
            counter++;

        }




    }


    public static void main(String[] args) {
        guessingGame();



        /*
        int answer;
        int guess;
        int counter = 1;

        final int maxNum = 20;
        Scanner scanner = new Scanner(System.in);
        Random randNum = new Random();

        boolean correct = false;
        answer = randNum.nextInt(maxNum) + 1;
        System.out.println("Hello! What is your name?");
        String name = scanner.nextLine();

        System.out.println("Well, " + name + " I am thinking of a number between 1 and 20. \n" +
                "Take a guess.");

        while (!correct) {


            guess = scanner.nextInt();

            if (guess > answer) {
                System.out.println("Your guess is too high. \n" +
                        "Take a guess.");
            } else if (guess < answer) {
                System.out.println("Your guess is too low. \n" +
                        "Take a guess.");
            } else {

                System.out.println("Correct! Good job, " + name + " , You guessed my number in " + counter + " guesses! \n");

                correct = true;

            }
            counter++;

        }

         */


    }
    }
