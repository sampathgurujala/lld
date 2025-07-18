package com.sampath.snakesandladdergame;

import java.util.ArrayList;
import java.util.List;

public class GameDemo {
    public static void main(String[] args)
    {
        List<Snake> snakeList = new ArrayList<>(List.of(new Snake(35,11),new Snake(84,25)));
        List<Ladder> ladderList = new ArrayList<>(List.of(new Ladder(7,22), new Ladder(35,79)));
        Board board =new Board(100,snakeList,ladderList);
        List<String> playerNames = new ArrayList<>(List.of("Sampath","Saketh"));
        Dice dice = new Dice(1,6);
        SnakesAndLadderGame game = new SnakesAndLadderGame.Builder().setBoard(board).setDice(dice).setPlayers(playerNames).build();
        game.play();
    }
}
