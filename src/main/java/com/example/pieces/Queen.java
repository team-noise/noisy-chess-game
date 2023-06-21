package com.example.pieces;

import com.example.common.Position;

public class Queen extends Piece {
    public Queen(final int row, final int col, final boolean isWhite) {
        super(row, col, isWhite);
    }

    @Override
    public boolean isValidMove(Position position) {
        // validate row and col values of destination position
        if ( ! validatePosition(position) ) return false;

        return moveStraight(position) || moveDiagonally(position) || moveDiagonally(position);
    }


    public boolean moveStraight(Position position) {
        return getPosition().getRow() == position.getRow() && getPosition().getCol() != position.getCol();
    }

    public boolean moveHorizontally(Position position) {
        return getPosition().getRow() != position.getRow() && getPosition().getCol() == position.getCol();
    }

    public boolean moveDiagonally(Position position) {
        int rowDistance = Math.abs( getPosition().getRow() - position.getRow() );
        int colDistance = Math.abs( getPosition().getCol() - position.getCol() );

        if ( rowDistance == 0 || colDistance == 0 ) return false;
        return rowDistance == colDistance;
    }
}