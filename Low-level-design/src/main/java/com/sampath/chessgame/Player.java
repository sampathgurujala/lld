package com.sampath.chessgame;

public class Player {
    String name;
    Color color;
    public Player(String name,Color color)
    {
        this.color = color;
        this.name =name;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

}
