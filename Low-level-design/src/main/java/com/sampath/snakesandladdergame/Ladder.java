package com.sampath.snakesandladdergame;

public class Ladder {
    private final int start;
    private final int end;
    public Ladder(int start, int end)
    {
        this.start = start;
        this.end = end;
    }
    public int getStart()
    {
        return  this.start;
    }
    public int getEnd()
    {
        return this.end;
    }
}
