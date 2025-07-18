package com.sampath.snakesandladdergame;

import java.util.*;

public class SnakesAndLadderGame {
    Board board;
    Queue<Player> players;
    Dice dice;
    public SnakesAndLadderGame(Builder builder)
    {
        this.board =builder.board;
        this.dice = builder.dice;
        this.players = new LinkedList<>(builder.players);
    }
    public boolean isGameOver()
    {
        for(Player player: players)
        {
            if(player.getPosition()==board.getSize())
                return true;
        }
        return false;
    }
    public void play()
    {
        while(!isGameOver())
        {
            Player currPlayer = players.poll();
            int currPosition = currPlayer.getPosition();
            int roll = dice.roll();
            int nextPosition = board.getNextPosition(currPlayer, currPosition,roll);
            currPlayer.setPosition(nextPosition);
            System.out.println("Player :"+ currPlayer.getName() +" has moved from position :"+currPosition+" to Position: "+ nextPosition);
            if(nextPosition== board.getSize())
            {
                System.out.println("Player : "+currPlayer.getName()+" has Won!!");
                break;
            }
            players.offer(currPlayer);
        }
    }
    //Inner Class
    public static class Builder
    {
        private Dice dice;
        private Queue<Player> players;
        private Board board;

        public Builder setBoard(Board board) {
            this.board = board;
            return this;
        }

        public Builder setPlayers(List<String> playersList) {
            this.players = new LinkedList<>();
            for(String playerName: playersList)
            {
                this.players.offer(new Player(playerName));
            }
            return this;
        }
        public Builder setDice(Dice dice) {
            this.dice = dice;
            return this;
        }
        public SnakesAndLadderGame build()
        {
            if(this.dice== null || this.players==null || this.board==null)
            {
                throw new IllegalStateException("Please set all the elements(Board, dice, Players)");
            }
            return new SnakesAndLadderGame(this);
        }
    }

}
