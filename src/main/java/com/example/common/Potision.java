package com.example.common;

public class Potision {
    private int row;
    private int col;

    public Potision(int row, int col) {
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

    public boolean equals(Object obj) {
        if ( obj instanceof Potision ) {
            Potision potision = (Potision) obj;
            if ( row == potision.getRow() && col == potision.getCol() ) return true;
        }
        return false;
    }
}