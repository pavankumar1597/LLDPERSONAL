package com.skill25;

import com.skill25.exceptions.DUplicateSymbolException;
import com.skill25.exceptions.InValidDimentionAndPlayerCount;
import com.skill25.exceptions.MoreThanOneBotException;
import com.skill25.models.Moves;
import com.skill25.models.WinningStartergy;
import com.skill25.models.entities.Board;
import com.skill25.models.entities.Bot;
import com.skill25.models.entities.Game;
import com.skill25.models.entities.Player;
import com.skill25.models.enums.BotDifficultLevel;
import com.skill25.models.enums.GameState;
import com.skill25.models.enums.PlayerType;

import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);

        int dimention = 3 ;
        ArrayList<Player> playerList = new ArrayList<>();
        playerList.add(new Player("pavan",1, PlayerType.HUMAN,'X'));
        playerList.add(new Bot("bot",2, PlayerType.BOT,'0', BotDifficultLevel.EASY));
        try {
            Game game = gameController.startGame(dimention, playerList);
            while(game.getGameState().equals(GameState.ON_GOING)) {
                game.printBoard();
                System.out.println("next turn ");
                game.makeMove();

                System.out.println("Does anyone want to undo? (y/n)");

                String undo = scanner.next();

                if(undo.equalsIgnoreCase("y")){
                    gameController.undo(game);
                    continue;
                }
                gameController.makeMove(game);

            }


        } catch (InValidDimentionAndPlayerCount | DUplicateSymbolException | MoreThanOneBotException e) {
            System.out.printf("Error occurec while playing gane  ");
            throw new RuntimeException(e);
        }


    }



}