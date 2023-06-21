package com.example.pieces;

import com.example.common.Position;

public class Bishop extends Piece {
    public Bishop(final int row, final int col, final boolean isWhite) {
        super(row, col, isWhite);
    }

    @Override
    public boolean isValidMove(Position position) {
        // validate row and col values of destination position
        if ( ! validatePosition(position) ) return false;

        return moveDiagonally(position);
    }

    public boolean moveDiagonally(Position position) {
        int rowDistance = Math.abs( getPosition().getRow() - position.getRow() );
        int colDistance = Math.abs( getPosition().getCol() - position.getCol() );

        if ( rowDistance == 0 || colDistance == 0 ) return false;
        return rowDistance == colDistance;
    }
}