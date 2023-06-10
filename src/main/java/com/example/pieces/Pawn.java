package com.example.pieces;

import com.example.common.Potision;

public class Pawn extends Piece {
    // constructor
    public Pawn(final int line, final int row, final boolean isWhite) {
        super(line, row, isWhite);
    }

    public boolean isValidMove(int line, int row) {
        // condition 1: You can only move forward
        Boolean moveUp;
        if ( gePotision().getRow() > line) moveUp = true;
        else moveUp = false;

        if ( isWhite() && Boolean.TRUE.equals(!moveUp) ) return false;
        if ( !isWhite() && Boolean.TRUE.equals(moveUp)) return false;
        
        // condition 2: 移動4パターンに属すかどうか
        int distanceLine = Math.abs( gePotision().getRow() - line);
        int distanceRow = Math.abs( gePotision().getCol() - row);
        if ( 0 < distanceLine && distanceLine <= 2 &&  distanceRow <= 1 ) {return true;
        }
        
        return false;
    }

    @Override
    public boolean isValidMove(Potision potision) {
        // todo: implemented
        return true;
    }
}
