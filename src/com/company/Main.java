package com.company;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner (System.in);


    public static void main(String[] args) {

        System.out.println("Choose the number of players (1 or 2):");
        int numberOfPlayer = numbOfPlayers();
        System.out.println(numberOfPlayer);

//        Player player1 = new Player(scanner.nextLine(), '&');



    }

    private static int numbOfPlayers() {
        boolean correctInput = false;
        while (!correctInput) {
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Choose the number of players (1 or 2):");
                scanner.nextLine();
            }
            int numberPlayers = scanner.nextInt();
            if ( !(numberPlayers == 1 || numberPlayers == 2)) {
                System.out.println("Number of players must be 1 or 2:");
                correctInput = false;
            } else {
                correctInput = true;
                return numberPlayers;
            }
        }
        return numbOfPlayers();
    }

}
