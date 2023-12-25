package com.skill25;

import com.skill25.exceptions.DUplicateSymbolException;
import com.skill25.exceptions.InValidDimentionAndPlayerCount;
import com.skill25.exceptions.MoreThanOneBotException;
import com.skill25.models.WinningStartergy;
import com.skill25.models.entities.Game;
import com.skill25.models.entities.Player;

import java.util.List;

public class GameController {

    Game startGame(int dimention, List<Player> playerList ) throws InValidDimentionAndPlayerCount, DUplicateSymbolException, MoreThanOneBotException {
        return new Game(dimention,playerList);
    }

    void quitGame(Player player){

    }

    void pauseGame(Player player){

    }


    public void undo(Game game) {
        game.undo();
    }

    public void makeMove(Game game) {
        game.makeMove();
    }
}
