package org.example;

import java.util.List;

public class Word {
    public static boolean wordState (String pickedWord, List< Character > playerGuesses){
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
