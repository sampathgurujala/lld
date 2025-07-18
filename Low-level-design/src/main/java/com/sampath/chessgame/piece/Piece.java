package com.sampath.chessgame.piece;

import com.sampath.chessgame.Cell;
import com.sampath.chessgame.Color;

public abstract class Piece {
    protected String name;
    protected Color color;
    public Piece(String name, Color color)
    {
        this.name= name;
        this.color= color;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }
    public abstract boolean canMove(Cell from, Cell to);
}
