package com.example.pieces;

public abstract class Piece {
    private int line;
    private int row;
    private final boolean isWhite;

    public Piece(final int line, final int row, final boolean isWhite) {
        this.line = line;
        this.row = row;
        this.isWhite = isWhite;
    }

    public boolean isWhite() {
        return this.isWhite;
    }

    public int getLine() {
        return this.line;
    }

    public int getRow() {
        return this.row;
    }

    public abstract boolean isValidMove(int line, int row);
}
