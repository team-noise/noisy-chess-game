package com.example.board;

import java.util.ArrayList;
import java.util.List;

import com.example.common.*;
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

        // deploy Pawn peices
        for ( int col = 0; col < BOARD_SIZE; col++ ) {
            chessBoard[1][col] = 'P';
            pieces.add(new Pawn(1, col, false));
            chessBoard[(BOARD_SIZE-1)-1][col] = 'P';
            pieces.add(new Pawn((BOARD_SIZE-1)-1, col, true));
        }

        // deploy King peices
    }

    public void movePiece(int fromRow, int fromCol, int toRow, int toCol) {
        final Position curerntPosition = new Position(fromRow, fromCol);
        final Position destinaionPosition = new Position(toRow, toCol);

        // 移動する駒のオブジェクトを所得
        Piece piece = findPiece(curerntPosition);
        if ( piece == null ) {
            System.out.println("[ERROR] not found piece");
            return;
        }

        // 駒の性質上、許容された動作かをチェック
        boolean isValidMove = piece.isValidMove(destinaionPosition);
        if ( Boolean.FALSE.equals(isValidMove) ) {
            System.out.println("[ERROR] the piece("+chessBoard[fromRow][fromCol]+") is incapable of making that move");
            return;
        }

        // 駒が移動先に移動可能かをチェック
        // 例）進路上に味方の駒がないかや
        // 例）敵の駒を倒せるか
        boolean canMove = canMove(piece, destinaionPosition);
        if ( Boolean.TRUE.equals(canMove) ) {
            char pieceChar = chessBoard[fromRow][fromCol];
            chessBoard[fromRow][fromCol] = EMPTY_CELL;
            chessBoard[toRow][toCol] = pieceChar;
            piece.setPosition(destinaionPosition);
            piece.addCount();
        }
    }

    private boolean canMove(Piece piece, Position destination) {
        if ( piece instanceof Pawn pawn) {
            Piece enemyPiece = findPiece(destination);
            if ( enemyPiece == null ) {
                return !hasAllyPieceInDirection(pawn.getPosition(), destination);
            } else if ( piece.isWhite() ^ enemyPiece.isWhite() ) {
                return pawn.killPiece(destination);
            } else {
                return false;
            }
        }

        return false;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    private Piece findPiece(Position position) {
        for (Piece piece : pieces) {
            if ( piece.getPosition().equals(position) ) return piece;
        }
        return null;
    }
    private Piece findPiece(int row, int col) {
        Position position = new Position(row, col);
        return findPiece(position);
    }

    private boolean hasAllyPieceInDirection(Position current, Position destination) {
        final int maxRow = (current.getRow() < destination.getRow()) ? destination.getRow() : current.getRow();
        final int minRow = (current.getRow() < destination.getRow()) ? current.getRow() : destination.getRow();
        final int maxCol = (current.getCol() < destination.getCol()) ? destination.getCol() : current.getCol();
        final int minCol = (current.getCol() < destination.getCol()) ? current.getCol() : destination.getCol();

        final Piece piece = findPiece(current);
        if ( piece == null ) {
            System.out.println("[ERROR] unexpected result: connot find piece to move");
            System.exit(1);
        }

        // straight
        for ( int row = minRow; row <= maxRow; row++ ) {
            if ( current.getRow() == row ) continue;

            Piece target = findPiece(row, current.getCol());
            if ( target == null ) continue;
            if ( piece.isWhite() && target.isWhite() ) return true;
        }
        System.out.println("[INFO] PASS: checking ally pieces on straight direction");
        
        // horizontally
        for ( int col = minCol; col <= maxCol; col++ ) {
            if ( current.getCol() == col ) continue;

            Piece target = findPiece(current.getRow(), col);
            if ( target == null ) continue;
            if ( piece.isWhite() && target.isWhite() ) return true;
        }
        System.out.println("[INFO] PASS: checking ally pieces on horizontally direction");

        // diagonally
        final boolean countupCol = current.getRow() < destination.getRow() && current.getCol() < destination.getCol();
        
        for ( int row = minRow, col = countupCol ? minCol : maxCol;
                row <= maxRow;
                row++, col = countupCol ? col+1 : col-1) {
            if ( current.getCol() == col ) continue;

            Piece target = findPiece(current.getRow(), col);
            if ( target == null ) continue;
            if ( piece.isWhite() && target.isWhite() ) return true;
        }
        System.out.println("[INFO] PASS: checking ally pieces on diagonally direction");

        return false;
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
