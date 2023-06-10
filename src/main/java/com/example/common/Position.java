package com.example.common;

public class Position {
    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public boolean equals(Object obj) {
        if ( obj instanceof Position ) {
            Position position = (Position) obj;
            if ( row == position.getRow() && col == position.getCol() ) return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return row*10 + col;
    }
}