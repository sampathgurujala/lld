package com.sampath.tictactoe;

import com.sampath.tictactoe.winningstrategy.WinningStrategy;

import java.util.List;

public class Board {
    private Cell[][] cells;
    private List<WinningStrategy> strategies;
    private int size;
    private int currMovesCnt;
      public Board(int size, List<WinningStrategy> strategies)
      {
          this.strategies = strategies;
          this.size =size;
          cells = new Cell[size][size];
          initializeBoard();
          currMovesCnt =0;
      }

    public int getSize() {
        return size;
    }
    public Symbol getSymbol(int row, int col)
    {
        return cells[row][col].getSymbol();
    }
    public void initializeBoard()
      {
          for(int row=0; row< size; row++)
          {
              for(int col =0;col< size;col++)
              {
                  cells[row][col] = new Cell();
              }
          }
      }

    public boolean isValidMove(int row, int col) {

        boolean isValid = true;
        if(!(row>=0 && row<getSize() && col>=0 && col<getSize()))
            isValid = false;
        Symbol symbol = getSymbol(row,col);
        if(symbol!=Symbol.EMPTY)
            isValid = false;
        return  true;
    }
    public void playMove(int row, int col, Symbol symbol) {
        Cell toPlace = cells[row][col];
        toPlace.setSymbol(symbol);
        this.currMovesCnt++;
        return;
    }

    public boolean checkWin(Symbol symbol) {
          for(WinningStrategy strategy: strategies)
          {
              boolean isWin = strategy.checkWin(this,symbol);
              if(isWin)
                  return true;
          }
          return false;
    }

    public void reset() {
          for(int row=0;row<getSize();row++)
          {
              for(int col=0;col<getSize();col++)
              {
                  cells[row][col].setSymbol(Symbol.EMPTY);
              }
          }

    }

    public void printCells() {
        for(int row=0;row<getSize();row++)
        {

            for(int col=0;col<getSize();col++)
            {
                System.out.print(" | "+cells[row][col].getSymbol());
            }
        }
    }
    public  boolean isBoardFull()
    {
        if(currMovesCnt == size*size)
            return true;
        return false;
    }


}
