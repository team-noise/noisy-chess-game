package com.example.pieces;

import com.example.common.Position;

public abstract class Piece {
    private Position position;      // position info on chess board
    private final boolean isWhite;
    private boolean isAlive;
    private int count;              // the number of moving on chess board

    protected Piece(final int row, final int col, final boolean isWhite) {
        this.position = new Position(row, col);
        this.isWhite = isWhite;
        this.isAlive = true;
        this.count = 0;
    }

    public boolean isWhite() {
        return this.isWhite;
    }

    public boolean isBlack() {
        return !this.isWhite;
    }

    public boolean isAlive() {
        return this.isAlive;
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

    public void isDead() {
        this.position = null;
        this.isAlive = false;
    }

    protected void addCount() {
        this.count++;
    }

    public abstract boolean isValidMove(Position position);
    public void move(Position position) {
        setPosition(position);
        addCount();
    }

    public boolean killPiece(Piece piece) {
        if ( isAllyPiece(piece) ) return false;

        System.out.printf("[INFO] Piece(%d, %d) kills a Piece(%d, %d)", getPosition().getRow(), getPosition().getCol(), piece.getPosition().getRow(), piece.getPosition().getCol());
        move(piece.getPosition());
        piece.isDead();

        return true;
    }

    public boolean isAllyPiece(Piece piece) {
        if ( piece == null ) return false;
        if ( isWhite() && piece.isWhite() ) {
            System.out.println("[DEBUG] both pieces are white");
            return true;
        }
        if ( isBlack() && piece.isBlack() ) {
            System.out.println("[DEBUG] both pieces are black");
            return true;
        }
        return false;
    }

    protected boolean moveForward(Position position) {
        boolean moveUp;
        if ( getPosition().getRow() > position.getRow() ) moveUp = true;
        else moveUp = false;

        return (isWhite() ^ !moveUp);
    }
}
