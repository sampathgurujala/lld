package com.sampath.tictactoe.winningstrategy;

import com.sampath.tictactoe.Board;
import com.sampath.tictactoe.Symbol;

public class ColumnWinningStrategy implements WinningStrategy{



    @Override
    public boolean checkWin(Board board, Symbol symbol) {
        boolean allMatch;
        for(int col=0;col< board.getSize();col++)
        {
            allMatch = true;
            for(int row =0; row < board.getSize(); row++)
            {
                if(board.getSymbol(row, col)!= symbol )
                {
                    allMatch =false;
                    break;
                }
            }
            if(allMatch ==true)
            {
                return  true;
            }
        }
        return  false;
    }

}
