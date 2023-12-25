package com.skill25.models.entities;

import com.skill25.exceptions.DUplicateSymbolException;
import com.skill25.exceptions.InValidDimentionAndPlayerCount;
import com.skill25.exceptions.MoreThanOneBotException;
import com.skill25.models.*;
import com.skill25.models.enums.CellState;
import com.skill25.models.enums.GameState;
import com.skill25.models.enums.PlayerType;


import java.util.*;

import static com.skill25.models.enums.GameState.*;

public class Game {
   private List<Player> players;
   private Scanner scan = new Scanner(System.in);


    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Moves> getMoves() {
        return moves;
    }

    public void setMoves(List<Moves> moves) {
        this.moves = moves;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextPayerIndex() {
        return nextPayerIndex;
    }

    public void setNextPayerIndex(int nextPayerIndex) {
        this.nextPayerIndex = nextPayerIndex;
    }

    public int getDimention() {
        return dimention;
    }

    public void setDimention(int dimention) {
        this.dimention = dimention;
    }

    public List<WinningStartergy> getWinningStartergy() {
        return winningStartergy;
    }

    public void setWinningStartergy(List<WinningStartergy> winningStartergy) {
        this.winningStartergy = winningStartergy;
    }

    private List<Moves> moves = new ArrayList<>();
    private Board board;
    private GameState gameState;
    private int nextPayerIndex ;
    private int dimention ;
    private Player winner ;

    private List<WinningStartergy> winningStartergy;

    public void printBoard(){

        List<List<Cell>> board1 = this.board.getBoard();
        for (List<Cell> rows : board1) {
            System.out.print("|");
            rows.forEach(x -> System.out.print(x.getSymbol()+" | "));
            System.out.println();
        }

        System.out.println("askjfbcskjbvskjd");
    }
    public Game(int dimention , List<Player> players) throws MoreThanOneBotException, DUplicateSymbolException, InValidDimentionAndPlayerCount {

        this.players = players;
        this.board = new Board("tictactoe",dimention);
        this.gameState = ON_GOING;
        this.dimention = dimention ;
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
        HashSet<Character> symbols = new HashSet<>();
        for(Player player : players) if (!symbols.add(player.getSymbol()))  throw new DUplicateSymbolException();
    }

    public void makeMove() {
        printBoard();
        Player player = players.get(nextPayerIndex);
        System.out.println("current player is : "+player.getName());

        Cell cell = player.makeMove(board);
        printBoard();

        Moves moves1 = new Moves(player, cell);
        this.moves.add(moves1);

        if(checkWinner(board,moves1)){
            gameState = GameState.SUCCESS;
            winner = player;
            System.out.println("wow wow wow player wone : "+winner.getName());
            setGameState(GAME_OVER);
            return ;
        }

        nextPayerIndex = (++nextPayerIndex)%players.size();

    }

    private boolean checkWinner(Board board , Moves move) {
        for (WinningStartergy startergy : winningStartergy) {
            boolean winningStratergy = startergy.createWinningStratergy(board, move);
            if(winningStratergy){
                return true;
            }
        }
        return false;
    }

     public boolean undo() {

        //remove from the cell
        //remove from the wining Stratergies
        //reduce the player
        try {
        Moves moves1 = moves.get(moves.size() - 1);
        moves.remove(moves1);
        winningStartergy.forEach(x ->{
            x.undoMoves(moves1,board);
        });

            moves1.getCell().setSymbol(Character.MIN_VALUE);
            moves1.getCell().setPlayer(null);
            moves1.getCell().setCellState(CellState.EMPTY);

            nextPayerIndex = (nextPayerIndex-1 < 0 ) ? players.size()-1 : nextPayerIndex-1 ;

            System.out.println("print undo successful ");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
