package com.sampath.chessgame;

import com.sampath.chessgame.Board;
import com.sampath.chessgame.Player;
import com.sampath.chessgame.exception.IllegalMoveException;
import com.sampath.chessgame.piece.Piece;

import java.util.Scanner;

public class ChessGame {
    public static ChessGame INSTANCE = null;
    private final Board board;
    private Player whitePlayer,blackPlayer;
    private Player currPlayer;

    public ChessGame(String player1Name, String player2name) {
        this.whitePlayer = new Player(player1Name,Color.WHITE);
        this.blackPlayer = new Player(player2name,Color.BLACK);
        this.board = new Board();
        currPlayer = whitePlayer;
        start();
    }

    public ChessGame getInstance(String player1Name, String player2name)
    {
        if(INSTANCE==null)
            INSTANCE = new ChessGame(player1Name,player2name);
        return INSTANCE;
    }
    public void start()
    {
        boolean isGameOver =false;
        while (!isGameOver)
        {
            try {
                Player curr = currPlayer;
                System.out.println("Current Player to make move: "+ curr.getName()+" Color: "+currPlayer.color);
                Move move = getMove(curr);
                board.movePiece(move);
                isGameOver = checkResult();
                switchTurn();
            }
            catch (IllegalMoveException exception)
            {
                System.out.println(exception.getMessage());
                continue;
            }
        }
    }

    private void switchTurn() {
        this.currPlayer =(currPlayer==whitePlayer)?blackPlayer:whitePlayer;
        return;
    }

    public boolean checkBounds(int row, int col)
    {
        if(row>=0 && row<8 && col>=0 && col<8)
            return  true;
        return false;
    }
    public Move getMove(Player player)
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the Source row: ");
        int srcRow = sc.nextInt();
        System.out.println("Please Enter Source Column");
        int srcCol = sc.nextInt();
        System.out.println("Please Enter Destination Row");
        int destRow = sc.nextInt();
        System.out.println("Please Enter Destination Column");
        int destCol = sc.nextInt();

        if(!checkBounds(srcRow,srcCol) ||  !checkBounds(destRow,destCol) ) {
            throw new IllegalMoveException("illegal input Bounds given!! Please Enter valid Ones.");
        }
        Cell from = board.getCell(srcRow,srcCol);
        Piece pieceToMove = from.getPiece();
        if(pieceToMove==null || pieceToMove.getColor() != player.getColor())
        {
            throw new IllegalMoveException("Player is either trying to Move Opponent's Piece/ No piece in the entered Source Cell");
        }
        Cell to = board.getCell(destRow,destCol);
        return  new Move(from,to);

    }
    public boolean checkResult()
    {
        if(board.isCheckMate(Color.WHITE))
        {
            System.out.println("White wins by checkmate");
            return true;
        }
        else if(board.isCheckMate(Color.BLACK))
        {
            System.out.println("Black wins by Checkmate!!");
            return true;
        }
            else if(board.isStaleMate(Color.WHITE) || board.isStaleMate(Color.BLACK))
        {

            System.out.println("the game ends in Stalemate!!");
            return true;
        }
       return false;
    }


}
