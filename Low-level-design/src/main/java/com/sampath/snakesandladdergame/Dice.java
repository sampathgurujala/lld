package com.sampath.snakesandladdergame;

import java.util.Random;

public class Dice {
    private final int minVal;
    private final int maxVal;
    private final Random random;
    Dice(int minVal, int maxVal)
    {
        this.minVal = minVal;
        this.maxVal = maxVal;
        this.random = new Random();
    }
    public int roll()
    {
        return random.nextInt(maxVal-minVal+1)+minVal;
    }
}
