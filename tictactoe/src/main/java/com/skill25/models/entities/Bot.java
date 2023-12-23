package com.skill25.models.entities;

import com.skill25.models.enums.BotDifficultLevel;
import com.skill25.models.enums.PlayerType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bot extends Player{
    private BotDifficultLevel botDifficultLevel;

    public Bot(String name, int id, com.skill25.models.enums.PlayerType playerType, String symbol,BotDifficultLevel botDifficultLevel) {
        super(name, id, playerType, symbol);
        this.botDifficultLevel = botDifficultLevel ;
}
}
