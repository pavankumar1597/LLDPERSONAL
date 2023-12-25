package com.skill25.models;

import com.skill25.models.entities.Board;
import com.skill25.models.entities.Cell;
import com.skill25.models.enums.CellState;

import java.util.List;

public class EasyBotPlayingStratergy implements BotPlayingStratergy{
    @Override
    public Cell makeMove(Board board) {
        List<List<Cell>> board1 = board.getBoard();
        for (List<Cell> rows : board1) {
            for (Cell col : rows) {
                if (col.getCellState().equals(CellState.EMPTY)){
                    return col;
                }
            }
        }
        return null;
    }
}
