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
    }
}