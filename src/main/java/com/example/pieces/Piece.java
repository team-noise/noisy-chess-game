package com.example.pieces;

import com.example.common.Position;

public abstract class Piece {
    private Position position;      // position info on chess board
    private final boolean isWhite;
    private int count;              // the number of moving on chess board

    protected Piece(final int row, final int col, final boolean isWhite) {
        this.position = new Position(row, col);
        this.isWhite = isWhite;
        this.count = 0;
    }

    public boolean isWhite() {
        return this.isWhite;
    }

    public boolean isBlack() {
        return !this.isWhite;
    }

    public Position getPosition() {
        return position;
    }

    public int getCount() {
        return count;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void addCount() {
        this.count++;
    }

    public abstract boolean isValidMove(Position position);
}
