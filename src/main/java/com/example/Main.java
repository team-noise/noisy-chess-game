package com.example;

import java.util.Scanner;

import com.example.board.Board;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Board board = new Board();

        System.out.println("====Start==== Avobe:WHITE Below:BLACK");
        board.display();

        // playing this game
        Scanner scan = new Scanner(System.in);
        int currentLine = scan.nextInt();
        int currentRow = scan.nextInt();
        int afterLine = scan.nextInt();
        int afterRow = scan.nextInt();
        if ( !validate(currentLine, currentRow, afterLine, afterRow)) {
            System.out.println("input value is not correct.");
            System.exit(1);
        }

        board.replacePieces(currentLine, currentRow, afterLine, afterRow);
        board.display();
    }

    private static Boolean validate(int a, int b, int c, int d) {
        if ( 0 <= a && a < 8 && 
            0 <= b && b < 8 &&
            0 <= c && c < 8 &&
            0 <= d && d < 8 ) return true;
        return false;
    }
}