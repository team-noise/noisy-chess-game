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

        // deploy Pawns
        for ( int col = 0; col < BOARD_SIZE; col++ ) {
            chessBoard[1][col] = 'P';
            pieces.add(new Pawn(1, col, false));
            chessBoard[(BOARD_SIZE-1)-1][col] = 'P';
            pieces.add(new Pawn((BOARD_SIZE-1)-1, col, true));
        }

        // deploy Rooks
        chessBoard[0][0] = 'R';
        chessBoard[0][7] = 'R';
        pieces.add(new Rook(0, 0, false));
        pieces.add(new Rook(0, 7, false));
        chessBoard[7][0] = 'R';
        chessBoard[7][7] = 'R';
        pieces.add(new Rook(7, 0, true));
        pieces.add(new Rook(7, 7, true));

        // deploy Knights
        chessBoard[0][1] = 'K';
        chessBoard[0][6] = 'K';
        pieces.add(new Knight(0, 1, false));
        pieces.add(new Knight(0, 6, false));
        chessBoard[7][1] = 'K';
        chessBoard[7][6] = 'K';
        pieces.add(new Knight(7, 1, true));
        pieces.add(new Knight(7, 6, true));

        // deploy Bishops
        chessBoard[0][2] = 'B';
        chessBoard[0][5] = 'B';
        pieces.add(new Bishop(0, 2, false));
        pieces.add(new Bishop(0, 5, false));
        chessBoard[7][2] = 'B';
        chessBoard[7][5] = 'B';
        pieces.add(new Bishop(7, 2, true));
        pieces.add(new Bishop(7, 5, true));

        // deploy Kings
        chessBoard[0][3] = '$';
        pieces.add(new King(0, 3, false));
        chessBoard[7][3] = '$';
        pieces.add(new King(7, 3, true));

        // deploy Queens
        chessBoard[0][4] = 'Q';
        pieces.add(new Queen(0, 4, false));
        chessBoard[7][4] = 'Q';
        pieces.add(new Queen(7, 4, true));
    }

    public void movePiece(int fromRow, int fromCol, int toRow, int toCol) {
        final Position current = new Position(fromRow, fromCol);
        final Position destination = new Position(toRow, toCol);

        // 移動する駒のオブジェクトを所得
        Piece piece = findPiece(current);
        if ( piece == null ) {
            System.out.println("[ERROR] not found piece to move");
            return;
        }

        // 駒の性質上、許容された動作かをチェック
        boolean isValidMove = piece.isValidMove(destination);
        if ( Boolean.FALSE.equals(isValidMove) ) {
            System.out.println("[ERROR] the piece("+chessBoard[fromRow][fromCol]+") is incapable of making that move");
            return;
        }

        // 駒が移動先に移動可能かをチェック
        // 例）進路上に味方の駒がないかや
        // 例）敵の駒を倒せるか
        boolean canMove = canMove(piece, destination);
        if ( Boolean.FALSE.equals(canMove) ) {
            System.out.println("[ERROR] the piece("+chessBoard[fromRow][fromCol]+") cannot move because one of the following reason");
            System.out.println("[ERROR]   1. ally piece(s) exists on the way");
            System.out.println("[ERROR]   2. no ememies to 1 square diagonally (only Pawn)");
            return;
        }

        // 駒の移動
        Piece target = findPiece(destination);
        if ( target == null ) {
            piece.move(destination);
        } else {
            if ( !piece.killPiece(target) ) {
                System.out.println("[ERROR] cannot kill destination piece");
                return;        
            }
        }

        // チェスボードの更新
        char pieceChar = chessBoard[fromRow][fromCol];
        chessBoard[fromRow][fromCol] = EMPTY_CELL;
        chessBoard[toRow][toCol] = pieceChar;
    }

    private boolean canMove(Piece piece, Position destination) {
        if ( piece instanceof Pawn pawn) {
            Piece target = findPiece(destination);
            if ( target == null ) {
                return pawn.moveStraight(destination) && !hasAllyPieceInDirection(pawn.getPosition(), destination);
            }
            return pawn.moveDiagonally(destination) && !pawn.isAllyPiece(target);
        }

        return false;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    private Piece findPiece(Position position) {
        for (Piece piece : pieces) {
            if ( !piece.isAlive() ) continue;
            if ( piece.getPosition().equals(position) ) return piece;
        }
        return null;
    }
    private Piece findPiece(int row, int col) {
        Position position = new Position(row, col);
        return findPiece(position);
    }

    private boolean hasAllyPieceInDirection(Position current, Position destination) {
        final boolean countupRow = current.getRow() <= destination.getRow();
        final boolean countupCol = current.getCol() <= destination.getCol();

        final Piece piece = findPiece(current);
        if ( piece == null ) {
            System.out.println("[ERROR] unexpected result: connot find piece to move");
            System.exit(1);
        }

        // straight
        for ( int row = current.getRow(), col = current.getCol(); ;
                row = countupRow ? row+1 : row-1 ) {
            if ( countupRow && row > destination.getRow() ) break;
            if ( !countupRow && row < destination.getRow() ) break;

            // skip current position
            if ( row == current.getRow() ) continue;

            // check ally piece(s) on the way
            Piece target = findPiece(row, col);
            if ( piece.isAllyPiece(target) ) return true;
        }
        System.out.println("[INFO] PASS: checking ally pieces on straight direction");
        
        // horizontally
        for ( int row = current.getRow(), col = current.getCol(); ;
                col = countupCol ? col+1 : col-1 ) {
            if ( countupCol && col > destination.getCol() ) break;
            if ( !countupCol && col < destination.getCol() ) break;

            // skip current position
            if ( col == current.getCol() ) continue;

            // check ally piece(s) on the way
            Piece target = findPiece(row, col);
            if ( piece.isAllyPiece(target) ) return true;
        }
        System.out.println("[INFO] PASS: checking ally pieces on horizontally direction");

        // diagonally
        for ( int row = current.getRow(), col = current.getCol(); ;
                row = countupRow ? row+1 : row-1,
                col = countupCol ? col+1 : col-1 ) {
            // exit condition
            if ( countupRow && row > destination.getRow() ) break;
            if ( !countupRow && row < destination.getRow() ) break;

            // skip current position
            if ( row == current.getRow() ) continue;

            // check ally piece(s) on the way
            Piece target = findPiece(row, col);
            if ( piece.isAllyPiece(target) ) return true;
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
