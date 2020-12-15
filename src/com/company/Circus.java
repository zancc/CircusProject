package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Circus {

    public static Scanner scanner = new Scanner (System.in);
    public static ArrayList<CircusPlayer> circusPlayers = new ArrayList<>();
    public static int numberOfPlayer;

    public static void playCircus() {
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
            circusPlayers.add(new CircusPlayer(name, token));
            System.out.println(circusPlayers.get(i));
        }

        int diceValue;
        boolean endOfGame = false;

        CircusGameBoard.printBoard();

        while(!endOfGame) {

            for (int i = 0; i < numberOfPlayer; i++) {
                CircusPlayer currentCircusPlayer = circusPlayers.get(i); //currentPlayer is player that is currently playing
                System.out.println("Enter the value of the dice (1, 2, 3, 4, 5 or 6) thrown  by player " + currentCircusPlayer.getName() +
                        "("+ CircusGameBoard.pic(CircusGameBoard.CYAN, currentCircusPlayer.getToken())+")");
                diceValue = readDiceValue(); //reads and checks the dice value for player 1
                //System.out.println(diceValue); //prints dice value (for debugging)

                currentCircusPlayer.setFieldPrint(currentCircusPlayer.getPosition(), ' '); //for the board printing

                currentCircusPlayer.addToPosition(diceValue); //adding the value of the dice to the position of player 1
                //System.out.println(currentPlayer.getName() + " Players position immediately after throwing the dice: "
                //        + currentPlayer.getPosition()); //prints out players1 position

                String action = currentCircusPlayer.boardAction(currentCircusPlayer.getPosition()); //prints and does the board action - goes forward/back

                currentCircusPlayer.setFieldPrint(currentCircusPlayer.getPosition(), currentCircusPlayer.getToken()); //for the board printing

                System.out.println(currentCircusPlayer.getName() + " Players position after the action: " + currentCircusPlayer.getPosition());


                // if player crosses the 120 mark - then needs to go back
                if (currentCircusPlayer.getPosition() > 120) {
                    int pos = currentCircusPlayer.getPosition();
                    currentCircusPlayer.setPosition(120 - (pos-120));
                    System.out.println(currentCircusPlayer.getName() + " player crossed the end and returned back, current position: "
                            + currentCircusPlayer.getPosition());

                    currentCircusPlayer.setFieldPrint(currentCircusPlayer.getPosition(), ' '); //for the board printing
                    action = currentCircusPlayer.boardAction(currentCircusPlayer.getPosition());
                    currentCircusPlayer.setFieldPrint(currentCircusPlayer.getPosition(), currentCircusPlayer.getToken()); //for the board printing

                    CircusGameBoard.printBoard();
                    System.out.println("\t"+action);

                } else if (circusPlayers.get(i).getPosition() == 120) {
                    //what are we going to do at the end? just end the game and announce
                    // the winner or ask to repeat the game or not?
                    CircusGameBoard.printBoard();
                    System.out.println("Game over. The winner is " + currentCircusPlayer.getName());
                    endOfGame = true;

                } else {
                    CircusGameBoard.printBoard();
                    System.out.println("\t"+action);
                }

            }
        }
    }

    private static int readDiceValue() {
        int diceValue;
        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Enter the value of the dice thrown (1, 2, 3, 4, 5 or 6):");
                scanner.nextLine();
            }
            diceValue = scanner.nextInt();
            scanner.nextLine();
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
