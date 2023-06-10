package com.example.board;

import java.util.ArrayList;

import com.example.common.Potision;
import com.example.pieces.*;


public class Board {
    public static final int BOARD_SIZE = 8;
    private static final char EMPTY_CELL = '-';

    private char[][] chessBoard;
    private ArrayList<Piece> pieces;

    public Board() {
        this.chessBoard = new char[BOARD_SIZE][BOARD_SIZE];
        this.pieces = new ArrayList<>();
        
        init();
    }

    private void init() {
        // fill empty space of board
        for ( int row = 0; row < BOARD_SIZE; row++ ) {
            for ( int col = 0; col < BOARD_SIZE; col++ ) {
                chessBoard[row][col] = EMPTY_CELL;
            }
        }

        // deploy pawn peices
        for ( int col = 0; col < BOARD_SIZE; col++ ) {
            chessBoard[1][col] = 'P';
            pieces.add(new Pawn(1, col, false));
            chessBoard[(BOARD_SIZE-1)-1][col] = 'P';
            pieces.add(new Pawn((BOARD_SIZE-1)-1, col, true));
        }

        // deploy king peices
    }

    public void movePiece(int fromRow, int fromCol, int toRow, int toCol) {
        Piece piece = findPieceObj(fromRow, fromCol);
        if ( piece == null ) {
            System.out.println("[ERROR] not found piece");
            return;
        }

        boolean canMove = piece.isValidMove(new Potision(toRow, toCol));

        if ( Boolean.TRUE.equals(canMove) ) {
            char pieceChar = chessBoard[fromRow][fromCol];
            chessBoard[fromRow][fromCol] = EMPTY_CELL;
            chessBoard[toRow][toCol] = pieceChar;
            piece.setPotision(new Potision(toRow, toCol));
        }
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    private Piece findPieceObj(int row, int col) {
        Potision targetPotision = new Potision(row, col);

        for (Piece piece : pieces) {
            if ( piece.gePotision().equals(targetPotision) ) return piece;
        }

        return null;
    }

    // output current chess board layout to stdout
    public void printBoard() {
        for ( int row = 0; row < BOARD_SIZE; row++ ) {
            for ( int col = 0; col < BOARD_SIZE; col++ ) {
                System.out.print(chessBoard[row][col]+" ");
            }
            System.out.println();
        }
    }
}
