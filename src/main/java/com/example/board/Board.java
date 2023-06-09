package com.example.board;

import java.util.ArrayList;

import com.example.pieces.*;


public class Board {
    public final int MAX=8;
    private String[][] square;
    private ArrayList<Piece> pieces;

    public Board() {
        this.square = new String[8][8];
        this.pieces = new ArrayList<Piece>();
        
        init();
    }

    private void init() {
        // fill empty space of board
        for ( int i=0; i<MAX; i++ ) {
            for ( int j=0; j<MAX; j++ ) {
                square[i][j] = "-";
            }
        }

        // place to pawn
        for ( int i=0; i<MAX; i++ ) {
            square[1][i] = "P";
            pieces.add(new Pawn(1, i, false));
            square[(MAX-1)-1][i] = "P";
            pieces.add(new Pawn((MAX-1)-1, i, true));
        }
    }

    public void replacePieces(int currentLine, int currentRow, int afterLine, int afterRow) {
        System.out.println("[DEBUG] "+square[currentLine][currentRow]);
        square[afterLine][afterRow] = square[currentLine][currentRow];
        square[currentLine][currentRow] = "-";
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public String getSqaure(int i, int j) {
        return square[i][j];
    }

    public void display() {
        System.out.println("---------------------------------");
        for ( int i=0; i<MAX; i++ ) {
            for ( int j=0; j<MAX; j++ ) {
                System.out.print("| "+getSqaure(i, j)+" ");
            }
            System.out.println("|");
            System.out.println("---------------------------------");
        }
    }
}
