package com.skill25.models;

import com.skill25.models.entities.Board;
import com.skill25.models.entities.Cell;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStartergy implements WinningStartergy{
    Map<Integer, Map<Character, Integer>> map = new HashMap<>();

    @Override
    public boolean createWinningStratergy(Board board, Moves moves) {
        int row = moves.getCell().getRow();
        char symbol1 = moves.getCell().getSymbol();

        if(!map.containsKey(row)) map.put(row,new HashMap<>());
        
        Map<Character, Integer> rowMap = map.get(row);
        if(!rowMap.containsKey(symbol1)){
            rowMap.put(symbol1,1);
        }else {
            rowMap.put(symbol1,rowMap.get(symbol1)+1);
        }

        if(board.getBoard().size()==(rowMap.get(symbol1))){
            System.out.println("winning via "+row);
            return true;
        }
        return false;
    }

    @Override
    public void undoMoves(Moves moves1,Board board) {
        char symbol = moves1.getPlayer().getSymbol();
        Integer row = moves1.getCell().getRow();

        Map<Character, Integer> characterIntegerMap = map.get(row);
        characterIntegerMap.put(symbol, characterIntegerMap.get(symbol)-1 );

    }
}
