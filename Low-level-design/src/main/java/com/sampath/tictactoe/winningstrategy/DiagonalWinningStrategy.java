package com.sampath.tictactoe.winningstrategy;

import com.sampath.tictactoe.Board;
import com.sampath.tictactoe.Symbol;

public class DiagonalWinningStrategy implements WinningStrategy{

    @Override
    public boolean checkWin(Board board, Symbol symbol) {
        boolean allMatch = true;
        //Dialgonal checking
        for(int i=0;i< board.getSize();i++)
        {
                if(board.getSymbol(i, i)!= symbol )
                {
                    allMatch =false;
                    break;
                }

        }
        if(allMatch== true)
            return true;
        //Anto- diagonal checking
        for(int i=0;i< board.getSize();i++)
        {
            if(board.getSymbol(i,board.getSize()-1-i)!= symbol )
            {
                allMatch =false;
                break;
            }

        }
        return allMatch;
    }
}
