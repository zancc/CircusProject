package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner (System.in);
    public static ArrayList<Player> players = new ArrayList<>();
    public static int numberOfPlayer;

    public static void main(String[] args) {
        String name;
        char token;

        System.out.println("Choose the number of players (1 to 4):");
        numberOfPlayer = inputNumbOfPlayers();
        System.out.println("Number of players = " + numberOfPlayer);


        for (int i = 0; i < numberOfPlayer; i++) {
            System.out.println("Enter the name of the player number "+ (i + 1) +  ": ");
            name = scanner.nextLine();
            System.out.println("Enter " + name + "'s chosen token in form of one symbol");
            token = inputToken();
            players.add(new Player(name, token));
            System.out.println(players.get(i));
        }

        int diceValue;
        boolean endOfGame = false;

        GameBoard.printBoard();


        while(!endOfGame) {

            for (int i = 0; i < numberOfPlayer; i++) {
                Player currentPlayer = players.get(i); //currentPlayer is player that is currently playing
                System.out.println("Enter the value of the dice thrown (1, 2, 3, 4, 5 or 6) by player " + currentPlayer.getName() +
                        "("+GameBoard.pic(GameBoard.CYAN, currentPlayer.getToken())+")");
                diceValue = readDiceValue(); //reads and checks the dice value for player 1
                //System.out.println(diceValue); //prints dice value (for debugging)

                currentPlayer.setFieldPrint(currentPlayer.getPosition(), ' '); //for the board printing

                currentPlayer.addToPosition(diceValue); //adding the value of the dice to the position of player 1
                //System.out.println(currentPlayer.getName() + " Players position immediately after throwing the dice: "
                //        + currentPlayer.getPosition()); //prints out players1 position

                String action = currentPlayer.boardAction(currentPlayer.getPosition()); //prints and does the board action - goes forward/back

                currentPlayer.setFieldPrint(currentPlayer.getPosition(), currentPlayer.getToken()); //for the board printing

                System.out.println(currentPlayer.getName() + " Players position after the action: " + currentPlayer.getPosition());


                // if player crosses the 120 mark - then needs to go back
                if (currentPlayer.getPosition() > 120) {
                    int pos = currentPlayer.getPosition();
                    currentPlayer.setPosition(120 - (pos-120));
                    System.out.println(currentPlayer.getName() + " player crossed the end and returned back, current position: "
                            + currentPlayer.getPosition());
                    currentPlayer.setFieldPrint(currentPlayer.getPosition(), currentPlayer.getToken()); //for the board printing
                }



                if (players.get(i).getPosition() == 120) {
                    //what are we going to do at the end? just end the game and announce
                    // the winner or ask to repeat the game or not?

                    System.out.println("Game over. The winner is " + currentPlayer.getName());
                    endOfGame = true;
                }

                GameBoard.printBoard();
                System.out.println("\t"+action);
            }
        }
    }

    private static int readDiceValue() {
        int diceValue;
        while (true) {
            scanner.nextLine();
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Enter the value of the dice thrown (1, 2, 3, 4, 5 or 6):");
                scanner.nextLine();
            }
            diceValue = scanner.nextInt();
            if ( !(diceValue >= 1 && diceValue <= 6)) {
                System.out.println("Dice value must be 1, 2, 3, 4, 5 or 6:");
            } else {
                return diceValue;
            }
        }
    }

    private static char inputToken() {
        char playerToken;
        while (true) {
            String playerInput = scanner.nextLine();
            if (playerInput.length() == 1) {
                playerToken = playerInput.charAt(0);
                return playerToken;
            } else {
                System.out.println("Invalid input. Token must be one symbol:");
            }
        }
    }


    private static int inputNumbOfPlayers() {
        int numberOfPlayers ;
        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Choose the number of players (1 to 4):");
                scanner.nextLine();
            }
            numberOfPlayers = scanner.nextInt();
            scanner.nextLine();
            if ( !(numberOfPlayers == 1 || numberOfPlayers == 2 || numberOfPlayers == 3 || numberOfPlayers == 4)) {
                System.out.println("Number of players must be 1, 2, 3 or 4:");
            } else {
                return numberOfPlayers;
            }
        }
    }

}
