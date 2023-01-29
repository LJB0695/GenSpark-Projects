package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("C:/Users/barre/Project5Hangman/src/main/java/org/example/words.txt"));

        Scanner userInput = new Scanner(System.in);


        while(true) {
            System.out.println("Welcome to Hangman!");
            System.out.println("I have chosen a word, and now you have to guess it. Good Luck!");

            //Creates a path to the file that contains all the words that can be chosen.
           // Scanner scanner = new Scanner(new File("C:/Users/barre/Project5Hangman/src/main/java/org/example/words.txt"));
            //Scanner userInput = new Scanner(System.in);

            List<String> wordsList = new ArrayList<>();

            while (scanner.hasNext()) {
                wordsList.add(scanner.nextLine());
            }

            Random rand = new Random();

            String pickedWord = wordsList.get(rand.nextInt(wordsList.size()));

            //System.out.println(pickedWord);

            List<Character> playerGuesses = new ArrayList<>();

            int wrongGuessCount = 0;


            while (true) {
                printTheHangMan(wrongGuessCount);

                if (wrongGuessCount >= 6) {
                    System.out.println("You have lost!");
                    System.out.println("The word was: " + pickedWord);
                    break;
                }


                wordState(pickedWord, playerGuesses);
                if (!receiveUserGuess(userInput, pickedWord, playerGuesses)) {
                    wrongGuessCount++;
                }


                if (wordState(pickedWord, playerGuesses)) {
                    System.out.println("Congratulations! You guessed the word correctly!");
                    break;
                }
                System.out.println("Please enter a guess for the word. It is fine if you do not know it yet.");
                if (userInput.nextLine().equals(pickedWord)) {
                    System.out.println("Congratulations! You guessed the word correctly!");
                    break;
                } else {
                    System.out.println("That is wrong, try again!");
                }
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
                break;
            }
        }

            //System.out.println("Congratulations! You guessed the word correctly!");
        }

    private static void printTheHangMan(int wrongGuessCount) {
        System.out.println(" +-----+ ");
        System.out.println(" |     | ");
        if (wrongGuessCount >= 1) {
            System.out.println(" O");
        }
        if (wrongGuessCount >= 2) {
            System.out.print("\\ ");
            if (wrongGuessCount >= 3) {
                System.out.println("/");
            } else {
                System.out.println("");
            }
        }
        if (wrongGuessCount >= 4) {
            System.out.println(" |");
        }
        if (wrongGuessCount >= 5) {
            System.out.print("/ ");
            if (wrongGuessCount >= 6) {
                System.out.println("\\");
            } else {
                System.out.println("");
            }
        }
        System.out.println("");
        System.out.println("");
    }


    public static boolean receiveUserGuess (Scanner userInput, String pickedWord, List < Character > playerGuesses){
            //This method takes in the user's guess and replaces a dash with the correct letter guess.

                System.out.println("Please enter a letter: ");
                System.out.println("Letters you have guessed so far: " + playerGuesses);
                String charGuess = userInput.nextLine();
                playerGuesses.add(charGuess.charAt(0));
                try{
                    if(!(charGuess.matches("[a-zA-Z]"))){
                        throw new Exception();
                    }
                }catch (Exception e) {
                    System.out.println("Please enter a letter, and not a number.");
                    e.printStackTrace();
                }
                return pickedWord.contains(charGuess);
        }

        public static boolean wordState (String pickedWord, List < Character > playerGuesses){
            //This for loop checks to see if the guess is a character in the random word that the cpu picked.
            //If yes, then it will print the character, if not then it will just show a dash.
            int counter = 0;
            for (int i = 0; i < pickedWord.length(); i++) {
                if (playerGuesses.contains(pickedWord.charAt(i))) {
                    System.out.print(pickedWord.charAt(i));
                    counter++;
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
            return (pickedWord.length() == counter);
        }
    }
