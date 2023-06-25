package com.example;

import java.util.Scanner;

import com.example.board.Board;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();

        System.out.println("====Start==== Above:BLACK Below:WHITE");
        printBoard(board.getChessBoard());

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the row and column of the piece to move (e.g., 2 3): ");
            int fromRow = scanner.nextInt();
            int fromCol = scanner.nextInt();

            System.out.print("Enter the row and column of the destination (e.g., 4 3): ");
            int toRow = scanner.nextInt();
            int toCol = scanner.nextInt();

            board.movePiece(fromRow, fromCol, toRow, toCol);
            if ( board.pawnPromotion(toRow, toCol) ) {
                String simbol = checkPawnPromotion(scanner);
                board.pawnPromoteTo(toRow, toCol, simbol);
            }

            printBoard(board.getChessBoard());
            if (! checkContinue(scanner) ) break;
        }

        scanner.close();
    }

    // prompt the input interactively until the correct input is obtained
    private static boolean checkContinue(Scanner scanner) {
        while (true) {
            System.out.println("Do you want to continue playing? (y/n)");
            String exit = scanner.next();

            if (exit.equalsIgnoreCase("y")) {
                return true;
            } else if (exit.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println("Please input the correct value (y/n)");
            }
        }
    }

    // prompt the input interactively until the correct input is obtained
    private static String checkPawnPromotion(Scanner scanner) {
        while (true) {
            System.out.println("q: Queen");
            System.out.println("k: Knight");
            System.out.println("b: Bishop");
            System.out.println("r: Rook");
            System.out.print("Which the piece which pawn promote to (e.g. k): ");
            String simbol = scanner.next();

            if (simbol.equalsIgnoreCase("q")) {
                return simbol;
            } else if (simbol.equalsIgnoreCase("k")) {
                return simbol;
            } else if (simbol.equalsIgnoreCase("b")) {
                return simbol;
            } else if (simbol.equalsIgnoreCase("r")) {
                return simbol;
            } else {
                System.out.println("Please input the correct piece (y/n)");
            }
        }
    }

    // output current chess board layout to stdout
    private static void printBoard(char[][] board) {
        for ( int row = 0; row < board.length; row++ ) {
            for ( int col = 0; col < board[row].length; col++ ) {
                System.out.print(board[row][col]+" ");
            }
            System.out.println();
        }
    }

}