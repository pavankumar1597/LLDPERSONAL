package com.skill25.models;

import com.skill25.models.entities.Board;
import com.skill25.models.entities.Cell;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStartergy implements WinningStartergy{


    Map<Integer, Map<Character, Integer>> map = new HashMap<>();

    @Override
    public boolean createWinningStratergy(Board board, Moves moves) {
        int column = moves.getCell().getColumn();
        char symbol1 = moves.getCell().getSymbol();

        if(!map.containsKey(column)) map.put(column,new HashMap<>());
        Map<Character, Integer> colMap = map.get(column);
        if(!colMap.containsKey(symbol1)){
            colMap.put(symbol1,1);
        }else {
            colMap.put(symbol1,colMap.get(symbol1)+1);
        }

        if(board.getBoard().size()==(colMap.get(symbol1))){
            System.out.println("winning via "+column);
            return true;
        }
        return false;
    }


    @Override
    public void undoMoves(Moves moves1,Board board) {
        int row = moves1.getCell().getRow();
        char symbol = moves1.getPlayer().getSymbol();
        Integer column = moves1.getCell().getColumn();
        Map<Character, Integer> characterIntegerMap = map.get(column);
        characterIntegerMap.put(symbol, characterIntegerMap.get(symbol)-1);
    }
}
