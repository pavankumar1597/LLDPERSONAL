package com.skill25.models.entities;

import com.skill25.models.enums.CellState;
public class Cell {
    private int row;
    private int column;
    private Player player;
    private CellState cellState;
    private char symbol;

    // Private constructor to prevent direct instantiation
    private Cell(Builder builder) {
        this.row = builder.row;
        this.column = builder.column;
        this.player = builder.player;
        this.cellState = builder.cellState;
        this.symbol = builder.symbol;
    }

    // Getter methods for Cell properties

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Player getPlayer() {
        return player;
    }

    public CellState getCellState() {
        return cellState;
    }

    public char getSymbol() {
        return symbol;
    }


    // Builder class for Cell
    public static class Builder {
        private int row;
        private int column;
        private Player player;
        private CellState cellState;
        private char symbol;

        // Builder constructor with mandatory fields
        public Builder(int row, int column) {
            this.row = row;
            this.column = column;
        }

        // Setter methods for optional fields
        public Builder player(Player player) {
            this.player = player;
            return this;
        }

        public Builder cellState(CellState cellState) {
            this.cellState = cellState;
            return this;
        }

        public Builder symbol(char symbol) {
            this.symbol = symbol;
            return this;
        }

        // Build method to create an instance of Cell
        public Cell build() {
            return new Cell(this);
        }
    }
}
