package com.sampath.tictactoe.winningstrategy;

import com.sampath.tictactoe.Board;
import com.sampath.tictactoe.Symbol;

public interface WinningStrategy {

    boolean checkWin(Board board, Symbol symbol);
}
