package com.skill25.models.entities;


import java.util.ArrayList;
import java.util.List;

import static com.skill25.models.enums.CellState.EMPTY;


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
                rows.add(new Cell.Builder(i,j).cellState(EMPTY).build());
            }
            this.board.add(rows);
        }
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }
}
