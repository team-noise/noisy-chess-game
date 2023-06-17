package com.example.pieces;

import com.example.common.Position;

public class King extends Piece {
    public King(final int row, final int col, final boolean isWhite) {
        super(row, col, isWhite);
    }

    @Override
    public boolean isValidMove(Position position) {
        // Calculate the absolute difference in rows and columns
        int rowDiff = Math.abs(position.getRow() - getPosition().getRow());
        int colDiff = Math.abs(position.getCol() - getPosition().getCol());

        //The target position is within one square in any direction
        if(rowDiff >= 0 && colDiff >= 0 && rowDiff <= 1 && colDiff <= 1 && rowDiff + colDiff > 0){
            return true;
        }

        return false;
    }
}