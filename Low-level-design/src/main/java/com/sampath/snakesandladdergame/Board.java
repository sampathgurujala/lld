package com.sampath.snakesandladdergame;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private final int size;
    private final Map<Integer,Integer> snakes;
    private final Map<Integer,Integer> ladders;

    public Board(int size, List<Snake> snakeList, List<Ladder> ladderList)
    {
        this.size =size;
        snakes = new HashMap<>();
        for(Snake snake: snakeList)
        {
            addSnake(snake);
        }
        ladders = new HashMap<>();
        for(Ladder ladder: ladderList)
        {
            addLadder(ladder);
        }
    }
    public void addSnake(Snake snake)
    {
        if(!snakes.containsKey(snake.getHead()))
        {
            snakes.put(snake.getHead(), snake.getTail());
        }

    }
    public void addLadder(Ladder ladder)
    {
        if(!ladders.containsKey(ladder.getStart()))
        {
            ladders.put(ladder.getStart(),ladder.getEnd());
        }

    }
    public int getSize()
    {
        return size;
    }

    public int getNextPosition(Player player, int currentPosition, int roll)
    {
        if(currentPosition + roll > size)
        {
            return currentPosition;
        }

        int curr = currentPosition+roll;
        if(snakes.containsKey(currentPosition))
        {
            System.out.println("Player: "+player.getName()+" was caught by Snake!!");
         curr= snakes.get(currentPosition);
        }
        if(ladders.containsKey(currentPosition))
        {
            System.out.println("Player: "+player.getName()+"  has reached a ladder!!");
            curr =ladders.get(currentPosition);
        }
        return curr;
    }


}
