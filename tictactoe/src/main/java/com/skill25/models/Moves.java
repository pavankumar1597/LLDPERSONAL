package com.skill25.models;

import com.skill25.models.entities.Cell;
import com.skill25.models.entities.Player;

public class Moves {
    private Player player;
    private Cell cell;

    public Moves(Player player, Cell cell) {
        this.player = player;
        this.cell = cell;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
}
