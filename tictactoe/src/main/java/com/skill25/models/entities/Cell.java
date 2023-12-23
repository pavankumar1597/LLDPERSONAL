package com.skill25.models.entities;

import com.skill25.models.enums.CellState;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Cell {
    private int row ;
    private int column;
    private Player player;
    private CellState cellState;
    private char symbol;

}
