package com.skill25.models.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static com.skill25.models.enums.CellState.EMPTY;

@Getter
@Setter
public class Board {
    private String name ;
    private int size;
    private List<List<Cell>> board;

    public Board(String name, int size) {
        this.name = name;
        this.size = size;
        // instanciate cell
        this.board = new ArrayList<>();
        for(int i = 0 ; i < size ;i++){
            ArrayList<Cell> rows = new ArrayList<>();
            for(int j = 0 ;j <size ; j++){
                rows.add(Cell.builder().row(i).column(j).cellState(EMPTY).build());
            }
            this.board.add(rows);
        }
    }
}
