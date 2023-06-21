package com.example.pieces;

import com.example.common.Position;

public class Rook extends Piece {
    public Rook(final int row, final int col, final boolean isWhite) {
        super(row, col, isWhite);
    }

    @Override
    public boolean isValidMove(Position position) {
        // validate row and col values of destination position
        if ( ! validatePosition(position) ) return false;

        // condition: only move straight or horizontally
        return moveStraight(position) || moveHorizontally(position);
    }

    public boolean moveStraight(Position position) {
        return getPosition().getRow() == position.getRow() && getPosition().getCol() != position.getCol();
    }

    public boolean moveHorizontally(Position position) {
        return getPosition().getRow() != position.getRow() && getPosition().getCol() == position.getCol();
    }
}