package com.sampath.tictactoe;

public class Cell {
    private Symbol symbol;
    public Cell()
    {
        this.symbol= null;
    }
    public boolean isEmpty()
    {
        if(symbol!=Symbol.EMPTY)
            return false;
        return true;
    }

    public Symbol getSymbol() {
        return symbol;
    }
    public void setSymbol(Symbol symbol)
    {
        this.symbol = symbol;
        return;
    }
}
