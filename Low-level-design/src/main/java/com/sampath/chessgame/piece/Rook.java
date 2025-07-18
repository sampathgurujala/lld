package com.sampath.chessgame.piece;

import com.sampath.chessgame.Cell;
import com.sampath.chessgame.Color;

public class Rook extends Piece{
    public Rook(Color color)
    {
        super("Rook",color);
    }

    @Override
    public boolean canMove(Cell from, Cell to) {
        int rowDiff = to.getRow() - from.getRow();
        int colDiff = to.getCol()- from.getCol();
        if(this.color == Color.WHITE)
        {
            if((rowDiff==2 && colDiff==0 && from.getRow()==1 ) || (rowDiff==1 && colDiff==1  && to.getPiece()!=null))
                return true;
            else
                return false;
        }
        else
        {
            if((rowDiff==-2 && colDiff==0 && from.getRow()==6 ) || (rowDiff==-1 && colDiff==-1  && to.getPiece()!=null))
                return true;
            else
                return false;
        }

    }
}
