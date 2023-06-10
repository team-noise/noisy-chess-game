package com.example;

import java.util.Scanner;

import com.example.board.Board;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();

        System.out.println("====Start==== Avobe:WHITE Below:BLACK");
        board.printBoard();

        // playing this game
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the row and column of the piece to move (e.g., 2 3): ");
            int fromRow = scanner.nextInt();
            int fromCol = scanner.nextInt();

            System.out.print("Enter the row and column of the destination (e.g., 4 3): ");
            int toRow = scanner.nextInt();
            int toCol = scanner.nextInt();

            board.movePiece(fromRow, fromCol, toRow, toCol);

            board.printBoard();

            System.out.println("Do you want to continue playing? (y/n)");
            String choice = scanner.next();

            if (choice.equalsIgnoreCase("n")) {
                break;
            }
        }

        scanner.close();
    }

    private static Boolean validate(int a, int b, int c, int d) {
        if ( 0 <= a && a < 8 && 
            0 <= b && b < 8 &&
            0 <= c && c < 8 &&
            0 <= d && d < 8 ) return true;
        return false;
    }
}