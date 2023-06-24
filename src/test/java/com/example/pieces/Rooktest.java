package com.example.pieces;

import org.junit.Assert;
import org.junit.Test;
import com.example.common.Position;

public class RookTest {
    @Test
    public void testCreationInstance() {
        Rook rook = new Rook(0, 0, true);

        Assert.assertEquals(0, rook.getPosition().getRow());
        Assert.assertEquals(0, rook.getPosition().getCol());
        Assert.assertTrue(rook.isWhite());
        Assert.assertFalse(rook.isBlack());
    }

    @Test
    public void testIsValidMove() {
        // Test valid moves in horizontal direction
        Rook rook = new Rook(3, 3, true);

        Position validPosition1 = new Position(3, 7);
        Assert.assertTrue(rook.isValidMove(validPosition1));

        Position validPosition2 = new Position(3, 0);
        Assert.assertTrue(rook.isValidMove(validPosition2));

        Position validPosition3 = new Position(3, 5);
        Assert.assertTrue(rook.isValidMove(validPosition3));

        // Test valid moves in vertical direction
        Position validPosition4 = new Position(7, 3);
        Assert.assertTrue(rook.isValidMove(validPosition4));

        Position validPosition5 = new Position(0, 3);
        Assert.assertTrue(rook.isValidMove(validPosition5));

        Position validPosition6 = new Position(5, 3);
        Assert.assertTrue(rook.isValidMove(validPosition6));

        // Test invalid moves (diagonal)
        Position invalidPosition1 = new Position(2, 2);
        Assert.assertFalse(rook.isValidMove(invalidPosition1));

        Position invalidPosition2 = new Position(4, 4);
        Assert.assertFalse(rook.isValidMove(invalidPosition2));

        // Test invalid moves (non-linear)
        Position invalidPosition3 = new Position(5, 5);
        Assert.assertFalse(rook.isValidMove(invalidPosition3));

        Position invalidPosition4 = new Position(2, 4);
        Assert.assertFalse(rook.isValidMove(invalidPosition4));

        // Test valid moves in different directions and distances
        Position validPosition7 = new Position(3, 6);
        Assert.assertTrue(rook.isValidMove(validPosition7));

        Position validPosition8 = new Position(3, 1);
        Assert.assertTrue(rook.isValidMove(validPosition8));

        Position validPosition9 = new Position(6, 3);
        Assert.assertTrue(rook.isValidMove(validPosition9));

        Position validPosition10 = new Position(1, 3);
        Assert.assertTrue(rook.isValidMove(validPosition10));

        // Test invalid moves (out of board range)
        Position invalidPosition5 = new Position(8, 3);
        Assert.assertFalse(rook.isValidMove(invalidPosition5));

        Position invalidPosition6 = new Position(-1, 3);
        Assert.assertFalse(rook.isValidMove(invalidPosition6));

        Position invalidPosition7 = new Position(3, 8);
        Assert.assertFalse(rook.isValidMove(invalidPosition7));

        Position invalidPosition8 = new Position(3, -1);
        Assert.assertFalse(rook.isValidMove(invalidPosition8));

        // Test invalid moves (same position)
        Position invalidPosition9 = new Position(3, 3);
        Assert.assertFalse(rook.isValidMove(invalidPosition9));

        // Test valid moves within one square range
        Position validPosition11 = new Position(3, 4);
        Assert.assertTrue(rook.isValidMove(validPosition11));

        Position validPosition12 = new Position(4, 3);
        Assert.assertTrue(rook.isValidMove(validPosition12));

        Position validPosition13 = new Position(3, 2);
        Assert.assertTrue(rook.isValidMove(validPosition13));

        Position validPosition14 = new Position(2, 3);
        Assert.assertTrue(rook.isValidMove(validPosition14));
    }
}
