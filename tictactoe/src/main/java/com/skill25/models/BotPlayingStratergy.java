package com.skill25.models;

import com.skill25.models.entities.Board;
import com.skill25.models.entities.Cell;

public interface BotPlayingStratergy {
    Cell makeMove(Board board);
}
