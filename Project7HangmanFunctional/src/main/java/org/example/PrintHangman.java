package org.example;

public class PrintHangman {
    public static void printTheHangMan(int wrongGuessCount) {
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
}
