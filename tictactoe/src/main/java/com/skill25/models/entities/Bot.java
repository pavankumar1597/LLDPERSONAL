package com.skill25.models.entities;

import com.skill25.models.BotPlayingStratergy;
import com.skill25.models.EasyBotPlayingStratergy;
import com.skill25.models.enums.BotDifficultLevel;
import com.skill25.models.enums.CellState;
import com.skill25.models.enums.PlayerType;

public class Bot extends Player{
    private BotDifficultLevel botDifficultLevel;
    private BotPlayingStratergy botPlayingStratergy;

    public Bot(String name, int id, com.skill25.models.enums.PlayerType playerType, char symbol,BotDifficultLevel botDifficultLevel) {
        super(name, id, playerType, symbol);
        this.botDifficultLevel = botDifficultLevel ;
        this.botPlayingStratergy = new EasyBotPlayingStratergy();
    }

    @Override
    public Cell makeMove(Board board) {
        Cell cell = botPlayingStratergy.makeMove(board);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(this);
        cell.setSymbol(this.symbol);
        return cell;
    }
}
