package com.skill25.models.entities;

import com.skill25.exceptions.DUplicateSymbolException;
import com.skill25.exceptions.InValidDimentionAndPlayerCount;
import com.skill25.exceptions.MoreThanOneBotException;
import com.skill25.models.*;
import com.skill25.models.enums.GameState;
import com.skill25.models.enums.PlayerType;
import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static com.skill25.models.enums.GameState.NOT_STARTED;

@Getter
@Setter
public class Game {
   private List<Player> players;
   private List<Moves> moves;
    private Board board;
    private GameState gameState;
    private int nextPayerIndex ;
    private int dimention ;
    private List<WinningStartergy> winningStartergy;

    public Game(int dimention , List<Player> players) throws MoreThanOneBotException, DUplicateSymbolException, InValidDimentionAndPlayerCount {

        this.players = players;
        this.board = new Board("tictactoe",dimention);
        this.gameState = NOT_STARTED;
        this.winningStartergy =new ArrayList<WinningStartergy>(){{
            add(new RowWinningStartergy());
            add(new ColumnWinningStartergy());
            add(new DiaWinningStartergy());
        }};

        validateBotCount();
        validateUniqueSymbolsforPlayers();
        validDimentionAndPlayerCount();


    }

    private void validDimentionAndPlayerCount() throws InValidDimentionAndPlayerCount {
        if(players.size() != dimention-1){
            throw new InValidDimentionAndPlayerCount();
        }
    }

    private void validateBotCount() throws MoreThanOneBotException {
        long botCount = players.stream().filter(player -> player.getPlayerType().equals(PlayerType.BOT)).count();
        if(botCount < 1 ){
            throw new MoreThanOneBotException();
        }
    }

    private void validateUniqueSymbolsforPlayers() throws DUplicateSymbolException {
        HashSet<String> symbols = new HashSet<>();
        for(Player player : players) if (!symbols.add(player.getSymbol()))  throw new DUplicateSymbolException();
    }

}
