package com.example.pieces;

import com.example.common.Potision;

public abstract class Piece {
    private Potision potision;
    private final boolean isWhite;

    public Piece(final int row, final int col, final boolean isWhite) {
        this.potision = new Potision(row, col);
        this.isWhite = isWhite;
    }

    public boolean isWhite() {
        return this.isWhite;
    }

    public Potision gePotision() {
        return potision;
    }

    public void setPotision(Potision potision) {
        this.potision = potision;
    }

    public abstract boolean isValidMove(Potision potision);
}
