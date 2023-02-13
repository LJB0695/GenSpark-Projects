package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static org.example.PrintHangman.printTheHangMan;
import static org.example.UserGuess.receiveUserGuess;
import static org.example.Word.wordState;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("C:/Users/barre/Project7HangmanFunctional/src/main/java/org/example/words1.txt"));

        Scanner userInput = new Scanner(System.in);
        Scanner scanner2 = new Scanner(new File("C:/Users/barre/Project7HangmanFunctional/src/main/java/org/example/scores1.txt"));
        int largest = scanner2.nextInt();

        if (true) {
            System.out.println("Welcome to Hangman!");
            System.out.println("I have chosen a word, and now you have to guess it. Good Luck!");
            if (scanner2.hasNextInt()) {
                int number = scanner2.nextInt();
                if (number > largest) {
                    largest = number;
                    System.out.println("The high score is: " + largest );
                }

            }
            scanner2.close();
            //System.out.println("The high score is: " + );
            String name = "";
            System.out.println("Please enter your name: ");
            name = userInput.nextLine();
            FileWriter myWriter = new FileWriter("C:/Users/barre/Project7HangmanFunctional/src/main/java/org/example/namesandscores1.txt", true);
            myWriter.write(name + "\n");
            myWriter.close();
            FileWriter myWriter1 = new FileWriter("C:/Users/barre/Project7HangmanFunctional/src/main/java/org/example/scores1.txt",true);
            List<String> wordsList = new ArrayList<>();


            while (scanner.hasNext()) {
                wordsList.add(scanner.nextLine());
            }


           Random rand = new Random();

            String pickedWord = wordsList.get(rand.nextInt(wordsList.size()));



            List<Character> playerGuesses = new ArrayList<>();

            int wrongGuessCount = 0;
            int score = 10;


            while (true) {
                printTheHangMan(wrongGuessCount);

                if (wrongGuessCount >= 6) {
                    System.out.println("You have lost!");
                    System.out.println("The word was: " + pickedWord);
                    System.out.println(name + " your score was : " + score);
                    myWriter1.append(String.valueOf(score) + "\n");
                    myWriter1.close();
                    break;
                }


                wordState(pickedWord, playerGuesses);
                if (!receiveUserGuess(userInput, pickedWord, playerGuesses)) {
                    wrongGuessCount++;
                    score = score - 1;
                }


                if (wordState(pickedWord, playerGuesses)) {
                    System.out.println("Congratulations! You guessed the word correctly!");
                    System.out.println(name + " Your score was: " + score);
                    myWriter1.append(String.valueOf(score) + "\n");
                    myWriter1.close();
                    break;
                }
                System.out.println("Please enter a guess for the word. It is fine if you do not know it yet.");
                if (userInput.nextLine().equals(pickedWord)) {
                    System.out.println("Congratulations! You guessed the word correctly!");
                    System.out.println(name + " Your score was: " + score);
                    myWriter1.append(String.valueOf(score) + "\n");
                    myWriter1.close();
                    break;
                } else {
                    System.out.println("That is wrong, try again!");
                }





            }
            if(score > largest) {
                System.out.println("You have the new high score!");
            }
            System.out.println("Would you like to pay again? (y/n)");
           try {
                userInput.nextLine();
                if(!userInput.equals("y") && !userInput.equals("n")) {
                    throw new Exception();
                }
            }catch (Exception e) {
                System.out.println("Please enter y or n");
                e.printStackTrace();

            }
            if(!userInput.equals("y")) {
                return;
            }
        }

    }
}