package com.skill25.models.entities;

import com.skill25.models.enums.*;

import java.util.Scanner;

public class Player  {
    private String name;
    private int id;
    private PlayerType PlayerType;
    char symbol;
    private Scanner scan = new Scanner(System.in);


    public Player(String name, int id, com.skill25.models.enums.PlayerType playerType, char symbol) {
        this.name = name;
        this.id = id;
        PlayerType = playerType;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public com.skill25.models.enums.PlayerType getPlayerType() {
        return PlayerType;
    }

    public void setPlayerType(com.skill25.models.enums.PlayerType playerType) {
        PlayerType = playerType;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }


    public Cell makeMove(Board board){
        System.out.println("enter the row ");
        int row = scan.nextInt();
        System.out.println("enter the col ");
        int col = scan.nextInt();
        while(!validateMove(board,row,col)){
            System.out.println("incvalid move please re-enter the row and col ");
            row = scan.nextInt();
            col = scan.nextInt();
        }
        Cell cell = board.getBoard().get(row).get(col);

        cell.setCellState(CellState.FILLED);
        cell.setPlayer(this);
        cell.setSymbol(this.symbol);
        return cell;

    }

    private boolean validateMove(Board board, int row, int col) {

        if(row>=board.getSize() || row<0){
            return false;
        }
        if(col>=board.getSize() || col<0){
            return false;
        }

        Cell cell = board.getBoard().get(row).get(col);
        System.out.println(cell.getCellState().equals(CellState.EMPTY));
        return cell.getCellState().equals(CellState.EMPTY);
    }
}
