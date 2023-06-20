package com.example.pieces;

import org.junit.Assert;
import org.junit.Test;

import com.example.common.Position;


public class KingTest {
    @Test
    public void testCreationInstance() {
        King king = new King(0, 4, false);

        Assert.assertEquals(0, king.getPosition().getRow());
        Assert.assertEquals(4, king.getPosition().getCol());
        Assert.assertFalse(king.isWhite());
        Assert.assertTrue(king.isBlack());
        Assert.assertEquals(0, king.getCount());
    }

    @Test
    public void testIsValidMove() {
        // This test case checks move to straight
        King king = new King(0, 4, false);

        // 1 square movement to horizontally (first time)
        Position position = new Position(0, 5);
        Assert.assertTrue(king.isValidMove(position));

        // 1 square movement to diagonary (first time)
        position = new Position(1, 4);
        Assert.assertTrue(king.isValidMove(position));

        // 2 squares movement to horizontally (first time)
        position = new Position(0, 7);
        Assert.assertFalse(king.isValidMove(position));

        // 3 squares movement to horizontally (first time)
        position = new Position(3, 7);
        Assert.assertFalse(king.isValidMove(position));

        // Test valid moves within one square in any direction
        Position validPosition1 = new Position(0, 5);
        Assert.assertTrue(king.isValidMove(validPosition1));

        Position validPosition2 = new Position(1, 5);
        Assert.assertTrue(king.isValidMove(validPosition2));

        Position validPosition3 = new Position(1, 4);
        Assert.assertTrue(king.isValidMove(validPosition3));

        Position validPosition4 = new Position(1, 3);
        Assert.assertTrue(king.isValidMove(validPosition4));

        Position validPosition5 = new Position(0, 3);
        Assert.assertTrue(king.isValidMove(validPosition5));

        // Test invalid moves outside one square range
        Position invalidPosition1 = new Position(0, 6);
        Assert.assertFalse(king.isValidMove(invalidPosition1));

        Position invalidPosition2 = new Position(2, 5);
        Assert.assertFalse(king.isValidMove(invalidPosition2));

        Position invalidPosition3 = new Position(2, 4);
        Assert.assertFalse(king.isValidMove(invalidPosition3));

        Position invalidPosition4 = new Position(2, 3);
        Assert.assertFalse(king.isValidMove(invalidPosition4));

        Position invalidPosition5 = new Position(0, 2);
        Assert.assertFalse(king.isValidMove(invalidPosition5));
    }
}