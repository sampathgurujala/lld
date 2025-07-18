package com.sampath.tictactoe;

public class GameDemo {
    public static void main(String[] args) {
        Player player1 = new Player("Sampath", Symbol.O);
        Player player2 = new Player("Saketh", Symbol.X);
        int size = 3;
        TicTacToeGame game = new TicTacToeGame(3, player1, player2);

        game.playMove(0, 0);
        game.print();
        game.playMove(0,1);
        game.print();

    }

}
