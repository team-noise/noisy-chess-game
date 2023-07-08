package com.example.pieces;

import com.example.common.Position;
import org.junit.Assert;
import org.junit.Test;

public class BishopTest {
    @Test
    public void testCreationInstance() {
        Bishop bishop = new Bishop(2, 5, true);

        Assert.assertEquals(2, bishop.getPosition().getRow());
        Assert.assertEquals(5, bishop.getPosition().getCol());
        Assert.assertTrue(bishop.isWhite());
        Assert.assertFalse(bishop.isBlack());
        Assert.assertEquals(0, bishop.getCount());
    }

    @Test
    public void testIsValidMove() {
        // Test valid diagonal moves
        Bishop bishop = new Bishop(3, 3, true);

        // Move diagonally to top-right
        Position validPosition1 = new Position(6, 6);
        Assert.assertTrue(bishop.isValidMove(validPosition1));

        // Move diagonally to bottom-left
        Position validPosition2 = new Position(0, 0);
        Assert.assertTrue(bishop.isValidMove(validPosition2));

        // Move diagonally to top-left
        Position validPosition3 = new Position(6, 0);
        Assert.assertTrue(bishop.isValidMove(validPosition3));

        // Move diagonally to bottom-right
        Position validPosition4 = new Position(0, 6);
        Assert.assertTrue(bishop.isValidMove(validPosition4));

        // Test invalid moves
        Position invalidPosition1 = new Position(4, 3); // Not diagonal
        Assert.assertFalse(bishop.isValidMove(invalidPosition1));

        Position invalidPosition2 = new Position(6, 3); // Not diagonal
        Assert.assertFalse(bishop.isValidMove(invalidPosition2));

        Position invalidPosition3 = new Position(3, 6); // Not diagonal
        Assert.assertFalse(bishop.isValidMove(invalidPosition3));

        Position invalidPosition4 = new Position(1, 2); // Not diagonal
        Assert.assertFalse(bishop.isValidMove(invalidPosition4));
    }
}
