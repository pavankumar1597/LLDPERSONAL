package com.skill25.models;

import com.skill25.models.entities.Board;

public class RowWinningStartergy implements WinningStartergy{
    @Override
    public boolean createWinningStratergy(Board board, Moves moves) {
        return false;
    }
}
