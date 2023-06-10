package com.example;

import java.util.Scanner;

public class ChessGame {
    // variable
    private static final int BOARD_SIZE = 8;
    private static final char EMPTY_CELL = '-';
    private char[][] board;

    // constructor
    public ChessGame() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        initializeBoard();
    }

    // method
    public static void main(String[] args) {
        ChessGame game = new ChessGame();
        game.play();
    }

    private void initializeBoard() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                board[row][col] = EMPTY_CELL;
            }
        }
    }

    private void printBoard() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the row and column of the piece to move (e.g., 2 3):");
            int fromRow = scanner.nextInt();
            int fromCol = scanner.nextInt();

            System.out.println("Enter the row and column of the destination (e.g., 4 3):");
            int toRow = scanner.nextInt();
            int toCol = scanner.nextInt();

            movePiece(fromRow, fromCol, toRow, toCol);

            printBoard();

            System.out.println("Do you want to continue playing? (y/n)");
            String choice = scanner.next();

            if (choice.equalsIgnoreCase("n")) {
                break;
            }
        }

        scanner.close();
    }

    private void movePiece(int fromRow, int fromCol, int toRow, int toCol) {
        char piece = board[fromRow][fromCol];

        switch (piece) {
            case 'P':
                break;
            default: 
                String msg = "not found piece";
        }

        board[fromRow][fromCol] = EMPTY_CELL;
        board[toRow][toCol] = piece;
    }
}
