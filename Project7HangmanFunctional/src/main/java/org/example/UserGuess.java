package org.example;

import java.util.List;
import java.util.Scanner;

public class UserGuess {
    public static boolean receiveUserGuess (Scanner userInput, String pickedWord, List< Character > playerGuesses){
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

}
