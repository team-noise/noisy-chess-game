package com.example.pieces;

import com.example.common.Position;

public class Knight extends Piece {
    public Knight(final int row, final int col, final boolean isWhite) {
        super(row, col, isWhite);
    }

    @Override
    public boolean isValidMove(Position position) {
        // validate row and col values of destination position
        if ( ! validatePosition(position) ) return false;

        return moveLshapedPath(position);
    }

    public boolean moveLshapedPath(Position position) {
        int rowDistance = Math.abs( getPosition().getRow() - position.getRow() );
        int colDistance = Math.abs( getPosition().getCol() - position.getCol() );

        if ( Math.abs(rowDistance - colDistance) != 1 ) return false;

        if ( rowDistance == 1 && colDistance == 2 ) return true;
        if ( rowDistance == 2 && colDistance == 1 ) return true;

        return false;
    }
}