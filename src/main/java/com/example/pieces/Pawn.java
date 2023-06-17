package com.example.pieces;

import com.example.common.Position;

public class Pawn extends Piece {
    public Pawn(final int row, final int col, final boolean isWhite) {
        super(row, col, isWhite);
    }

    @Override
    public boolean isValidMove(Position position) {
        // condition 1: forward movement only allowed
        if ( !moveForward(position) ) return false;
        
        // condition 2: 1 square diagonally movement is allowed
        if ( moveDiagonally(position) ) return true;

        // condition 3: the following straight movements are allowed
        //              - 1 square movement (always)
        //              - 2 squares movement on the first time
        if ( !moveStraight(position) ) return false;
        int distanceRow = Math.abs( getPosition().getRow() - position.getRow() );
        if ( distanceRow == 1 ) return true;
        if ( distanceRow == 2 && getCount() == 0 )return true;
        
        return false;
    }

    public boolean moveStraight(Position position) {
        int distanceCol = Math.abs( getPosition().getCol() - position.getCol() );
        return distanceCol == 0;
    }

    public boolean moveDiagonally(Position position) {
        int distanceRow = Math.abs( getPosition().getRow() - position.getRow() );
        int distanceCol = Math.abs( getPosition().getCol() - position.getCol() );
        return distanceRow == 1 && distanceCol == 1;
    }
}
