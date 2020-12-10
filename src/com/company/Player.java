package com.company;

public class Player {
    private String name;
    private char token;
    private int position;

    public Player(String name, char token) {
        this.name = name;
        this.token = token;
        this.position = 1;
    }

    public String getName() {
        return name;
    }

    public char getToken() {
        return token;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void addToPosition(int position) {
        this.position += position;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", token=" + token +
                '}';
    }

    public String boardAction(int fieldNumber) {
        String action = "";

        switch (fieldNumber) {
            case 3:
                action = "Kangaroo with a phone - go forward to the field No.19";
                this.setPosition(19);
                break;
            case 9:
                action = "Seal with a ball - go forward to the field No.11";
                this.setPosition(11);
                break;
            case 14:
                action = "Bear - tightrope walker - go forward to the field No.30";
                this.setPosition(30);
                break;
            case 16:
                action = "Girl - tightrope dancer - go back to the first field";
                this.setPosition(1);
                break;

            default:
                action = "This is regular field without special action";
                break;
        }
        System.out.println(action);
        return action;
    }

}
