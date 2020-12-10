package com.company;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner (System.in);


    public static void main(String[] args) {
        String name;
        char token;

        System.out.println("Choose the number of players (1 or 2):");
        int numberOfPlayer = inputNumbOfPlayers();
        System.out.println("Number of players = " + numberOfPlayer);
        scanner.nextLine();

        System.out.println("Enter the name of the first player: ");
        name = scanner.nextLine();
        System.out.println("Enter first players token in form of one symbol");
        token = inputToken();
        Player player1 = new Player(name, token);

        Player player2 = null;
        if (numberOfPlayer == 2) {
            System.out.println("Enter the name of the second player: ");
            name = scanner.nextLine();
            System.out.println("Enter second players token in form of one symbol");
            token = inputToken();
            player2 = new Player(name, token);
        }

        System.out.println(player1);
        System.out.println(player2);

    }

    private static char inputToken() {
        char playerToken = ' ';
        while (true) {
            String playerInput = scanner.nextLine();
            if (playerInput.length() == 1) {
                playerToken = playerInput.charAt(0);
//                System.out.println("This players chosen token is: " + playerToken);
                return playerToken;
            } else {
                System.out.println("Invalid input. Enter token that is one symbol:");
            }
        }
    }


    private static int inputNumbOfPlayers() {
        boolean correctInput = false;
        int numberOfPlayers = 1;
        while (!correctInput) {
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Choose the number of players (1 or 2):");
                scanner.nextLine();
            }
            numberOfPlayers = scanner.nextInt();
            if ( !(numberOfPlayers == 1 || numberOfPlayers == 2)) {
                System.out.println("Number of players must be 1 or 2:");
                correctInput = false;
            } else {
                correctInput = true;
                return numberOfPlayers;
            }
        }
        return numberOfPlayers;
    }

}
