package com.skill25.models;

import com.skill25.models.entities.Board;
import lombok.*;


public interface WinningStartergy {
    boolean createWinningStratergy(Board board ,Moves moves);
}
