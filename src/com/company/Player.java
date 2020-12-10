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

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", token=" + token +
                '}';
    }
}
