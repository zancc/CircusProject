package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner (System.in);
    public static ArrayList<Player> players = new ArrayList<>();

    public static void main(String[] args) {
        String name;
        char token;

        System.out.println("Choose the number of players (1 or 2):");
        int numberOfPlayer = inputNumbOfPlayers();
        System.out.println("Number of players = " + numberOfPlayer);


        for (int i = 0; i < numberOfPlayer; i++) {
            System.out.println("Enter the name of the player number "+ (i + 1) +  ": ");
            name = scanner.nextLine();
            System.out.println("Enter " + name + "'s chosen token in form of one symbol");
            token = inputToken();
            players.add(new Player(name, token));
            System.out.println(players.get(i));
        }

        int diceValue = 0;
        boolean endOfGame = false;

        while(!endOfGame) {

            for (int i = 0; i < numberOfPlayer; i++) {
                Player currentPlayer = players.get(i);
                System.out.println("Enter the value of the dice thrown (1, 2, 3, 4, 5 or 6) by player " + currentPlayer.getName());
                diceValue = readDiceValue(); //reads and checks the dice value for player 1
                System.out.println(diceValue);

                currentPlayer.setFieldPrint(currentPlayer.getPosition(), ' '); //for the board printing

                currentPlayer.addToPosition(diceValue); //adding the value of the dice to the position of player 1
                System.out.println(currentPlayer.getName() + "Players position immediately after throwing the dice: "
                        + currentPlayer.getPosition()); //prints out players1 position

                currentPlayer.boardAction(currentPlayer.getPosition());

                currentPlayer.setFieldPrint(currentPlayer.getPosition(), currentPlayer.getToken()); //for the board printing

                System.out.println(currentPlayer.getName() + "Players position after the action: " + currentPlayer.getPosition());




                // if player crosses the 120 mark - then needs to go back
                if (currentPlayer.getPosition() > 120) {
                    int pos = currentPlayer.getPosition();
                    currentPlayer.setPosition(120 - (pos-120));
                    System.out.println(currentPlayer.getName() + " player crossed the end and returned back, current position: "
                            + currentPlayer.getPosition());

                }



                if (players.get(i).getPosition() == 120) {
                    //what are we going to do at the end? just end the game and announce
                    // the winner or ask to repeat the game or not?

                    System.out.println("Game over. The winner is " + currentPlayer.getName());
                    endOfGame = true;
                }
            }
        }
    }

    private static int readDiceValue() { // should clean up like inputToken() method
        boolean correctInput = false;
        int diceValue = 0;
        while (!correctInput) {
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Enter the value of the dice thrown (1, 2, 3, 4, 5 or 6):");
                scanner.nextLine();
            }
            diceValue = scanner.nextInt();
            if ( !(diceValue >= 1 && diceValue <= 6)) {
                System.out.println("Dice value must be 1, 2, 3, 4, 5 or 6:");
                correctInput = false;
            } else {
                correctInput = true;
                return diceValue;
            }
        }
        return diceValue;
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


    private static int inputNumbOfPlayers() { // should clean up like inputToken() method
        boolean correctInput = false;
        int numberOfPlayers = 1;
        while (!correctInput) {
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Choose the number of players (1 or 2):");
                scanner.nextLine();
            }
            numberOfPlayers = scanner.nextInt();
            scanner.nextLine();
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
