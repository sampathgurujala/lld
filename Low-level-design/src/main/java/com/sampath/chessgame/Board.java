package com.sampath.chessgame;

import com.sampath.chessgame.exception.IllegalMoveException;
import com.sampath.chessgame.piece.Piece;

public class Board {
    private Cell[][] cells;
    public Board()
    {
        this.cells = new Cell[8][8];
        setupPieces();
    }
    public void  setupPieces()
    {
    }
    public Cell getCell(int row, int col)
    {
        return this.cells[row][col];
    }


    public void movePiece(Move move) {
        Cell from = move.getFrom();
        Cell to =move.getTo();
        Piece piece = from.getPiece();
        if(!piece.canMove(from,to))
        {
            throw  new IllegalMoveException("Invalid Piece Move!!Please Try again");
        }
        to.setPiece(piece);
        from.setPiece(null);
    }

    public boolean isCheckMate(Color color) {
        return false;
    }

    public boolean isStaleMate(Color color) {
        return false;
    }
}
