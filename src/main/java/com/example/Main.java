package com.example;

import java.util.Scanner;

import com.example.board.Board;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();

        System.out.println("====Start==== Above:BLACK Below:WHITE");
        board.printBoard();

        // play this game
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
            String exit = scanner.next();

            if (exit.equalsIgnoreCase("n")) {
                break;
            }
        }

        scanner.close();
    }
}