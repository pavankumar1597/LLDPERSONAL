package com.skill25.models;

import com.skill25.models.entities.Board;
import com.skill25.models.entities.Cell;

import java.util.HashMap;
import java.util.Map;

public class DiaWinningStartergy implements WinningStartergy{

   Map<Character, Integer> rightDiagonalMap = new HashMap<>();
   Map<Character, Integer> leftMap = new HashMap<>();

    @Override
    public boolean createWinningStratergy(Board board, Moves moves) {

        Cell cell = moves.getCell();
        char symbol1 = cell.getSymbol();
        int column = cell.getColumn();
        int row = cell.getRow();
        if(column == row) {
            if(!leftMap.containsKey(symbol1)){
                leftMap.put(symbol1,1);
            }else leftMap.put(symbol1,leftMap.get(symbol1)+1);

            if(board.getSize() == leftMap.get(symbol1)){
                return  true ;
            }

        }

        // check if the cell is part of the right diagonal
        if((row+column)==(board.getSize()-1)){
            if(!rightDiagonalMap.containsKey(symbol1)){
                rightDiagonalMap.put(symbol1, 0);
            }

            rightDiagonalMap.put(symbol1, rightDiagonalMap.get(symbol1)+1);

            // check if the count of current symbol is same as size of board
            if(board.getSize()==rightDiagonalMap.get(symbol1)){
                System.out.println("winning via right dia ");
                return true;
            }

        }

        return false;
    }

    @Override
    public void undoMoves(Moves moves1,Board board) {
        Cell cell = moves1.getCell();
        char symbol1 = cell.getSymbol();
        int column = cell.getColumn();
        int row = cell.getRow();

        if(leftMap != null && column == row) {
            leftMap.put(symbol1,leftMap.get(symbol1)-1);
        }

        if(rightDiagonalMap != null &&  (row+column)==(board.getSize()-1)) {
            rightDiagonalMap.put(symbol1,rightDiagonalMap.get(symbol1)-1);
        }



        }
}
