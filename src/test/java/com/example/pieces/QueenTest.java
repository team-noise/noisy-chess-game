package com.example.pieces;

import org.junit.Assert;
import org.junit.Test;

import com.example.common.Position;

public class QueenTest {
    @Test
    public void testCreationInstance() {
        Queen queen = new Queen(0, 3, true);

        Assert.assertEquals(0, queen.getPosition().getRow());
        Assert.assertEquals(3, queen.getPosition().getCol());
        Assert.assertTrue(queen.isWhite());
        Assert.assertFalse(queen.isBlack());
    }

    @Test
    public void testIsValidMove() {
        Queen queen = new Queen(3, 3, true);

        // Test valid moves in straight lines (multiple squares)
        Position validPosition1 = new Position(3, 0);
        Assert.assertTrue(queen.isValidMove(validPosition1));

        Position validPosition2 = new Position(3, 7);
        Assert.assertTrue(queen.isValidMove(validPosition2));

        Position validPosition3 = new Position(0, 3);
        Assert.assertTrue(queen.isValidMove(validPosition3));

        Position validPosition4 = new Position(7, 3);
        Assert.assertTrue(queen.isValidMove(validPosition4));

        // Test valid moves in diagonal lines (multiple squares)
        Position validPosition5 = new Position(0, 0);
        Assert.assertTrue(queen.isValidMove(validPosition5));

        Position validPosition6 = new Position(7, 7);
        Assert.assertTrue(queen.isValidMove(validPosition6));

        Position validPosition7 = new Position(2, 4);
        Assert.assertTrue(queen.isValidMove(validPosition7));

        Position validPosition8 = new Position(6, 0);
        Assert.assertTrue(queen.isValidMove(validPosition8));

        // Test invalid moves
        Position invalidPosition1 = new Position(1, 6);
        Assert.assertFalse(queen.isValidMove(invalidPosition1));

        Position invalidPosition2 = new Position(6, 1);
        Assert.assertFalse(queen.isValidMove(invalidPosition2));

        Position invalidPosition3 = new Position(2, 7);
        Assert.assertFalse(queen.isValidMove(invalidPosition3));

        Position invalidPosition4 = new Position(0, 2);
        Assert.assertFalse(queen.isValidMove(invalidPosition4));

        // Test valid moves in horizontal, vertical, and diagonal lines (single square)
        Position validPosition9 = new Position(3, 4);
        Assert.assertTrue(queen.isValidMove(validPosition9));

        Position validPosition10 = new Position(4, 3);
        Assert.assertTrue(queen.isValidMove(validPosition10));

        Position validPosition11 = new Position(4, 4);
        Assert.assertTrue(queen.isValidMove(validPosition11));

        Position validPosition12 = new Position(2, 2);
        Assert.assertTrue(queen.isValidMove(validPosition12));

        // Test invalid moves outside the board
        Position invalidPosition5 = new Position(-1, 3);
        Assert.assertFalse(queen.isValidMove(invalidPosition5));

        Position invalidPosition6 = new Position(3, -1);
        Assert.assertFalse(queen.isValidMove(invalidPosition6));

        Position invalidPosition7 = new Position(8, 3);
        Assert.assertFalse(queen.isValidMove(invalidPosition7));

        Position invalidPosition8 = new Position(3, 8);
        Assert.assertFalse(queen.isValidMove(invalidPosition8));
        
        // Test valid moves in diagonal lines (multiple squares)
         Position validPosition13 = new Position(5, 1);
        Assert.assertTrue(queen.isValidMove(validPosition13));
       

        
    }
}
