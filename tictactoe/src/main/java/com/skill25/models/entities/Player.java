package com.skill25.models.entities;

import com.skill25.models.enums.*;
import lombok.*;


@Getter
@Setter
public class Player  {
    private String name;
    private int id;
    private PlayerType PlayerType;
    private String symbol;

    public Player(String name, int id, com.skill25.models.enums.PlayerType playerType, String symbol) {
        this.name = name;
        this.id = id;
        PlayerType = playerType;
        this.symbol = symbol;
    }
}
