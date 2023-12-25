package com.skill25.models;

import com.skill25.models.entities.Board;


public interface WinningStartergy {
    boolean createWinningStratergy(Board board ,Moves moves);
    void undoMoves(Moves moves1,Board board);
}
