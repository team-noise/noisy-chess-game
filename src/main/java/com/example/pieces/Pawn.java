package com.example.pieces;

public class Pawn extends Piece {
    // constructor
    public Pawn(final int line, final int row, final boolean isWhite) {
        super(line, row, isWhite);
    }

    public boolean isValidMove(int line, int row) {
        // condition 1: You can only move forward
        Boolean moveUp;
        if ( getLine() > line) moveUp = true;
        else moveUp = false;

        if ( isWhite() && !moveUp ) return false;
        if ( !isWhite() && moveUp) return false;
        
        // condition 2: 移動4パターンに属すかどうか
        int distanceLine = Math.abs(getLine() - line);
        int distanceRow = Math.abs(getRow() - row);
        if ( 0 < distanceLine && distanceLine <= 2){
            if ( distanceRow <= 1) return true;
        }
        
        return false;
    }
}
