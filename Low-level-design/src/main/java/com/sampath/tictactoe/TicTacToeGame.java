package com.sampath.tictactoe;

import com.sampath.tictactoe.winningstrategy.ColumnWinningStrategy;
import com.sampath.tictactoe.winningstrategy.DiagonalWinningStrategy;
import com.sampath.tictactoe.winningstrategy.RowWinningStrategy;
import com.sampath.tictactoe.winningstrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeGame {
    private final Board board;
    private Player[] players;
    private int currPlayerIdx;
    private GameStatus gameStatus;

    public TicTacToeGame( int size, Player player1, Player player2)
    {
        List<WinningStrategy> strategies = new ArrayList<>(List.of(new RowWinningStrategy(),new ColumnWinningStrategy(), new DiagonalWinningStrategy()));
        this.board = new Board(size,strategies);
         players = new Player[2];
         players[0] = player1;
         players[1] = player2;
         this.currPlayerIdx=0;
         this.gameStatus = GameStatus.IN_PROGRESS;
    }

    public void playMove(int row, int col)
    {
        if(getGameStatus()!=GameStatus.IN_PROGRESS)
            throw  new IllegalStateException(" Game already completed");
        if(!board.isValidMove(row,col))
        {
            throw  new IllegalStateException("Not a Valid Move!!");
        }
     Player currPlayer = players[currPlayerIdx];

     board.playMove(row,col, currPlayer.getSymbol());
     System.out.println("Player :"+currPlayer.getName()+" has Placed "+currPlayer.getSymbol()+" at [ "+row+" , "+ col+" ]");
     boolean isPlayerWon = board.checkWin(currPlayer.getSymbol());
     if(isPlayerWon) {
         this.gameStatus = GameStatus.WIN;
         System.out.println("Player :" + currPlayer.getName() + " has Won the game!.");
         return;
     }
    boolean boardFull = board.isBoardFull();
     if(boardFull)
     {
         this.gameStatus = GameStatus.DRAW;
         System.out.println("Game was a Draw!..");
     }
     currPlayerIdx = (currPlayerIdx+1)%2;

    }
    public GameStatus getGameStatus()
    {
        return this.gameStatus;
    }
    public void reset()
    {
        board.reset();
        this.gameStatus =GameStatus.IN_PROGRESS;
    }
    public void print()
    {
        board.printCells();
    }
}
