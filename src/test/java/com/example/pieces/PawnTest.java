package com.example.pieces;

import org.junit.Assert;
import org.junit.Test;

import com.example.common.Position;


public class PawnTest {
    @Test
    public void testCreationInstance() {
        /* BLACK PIECE */
        Pawn pawn = new Pawn(1, 0, false);

        Assert.assertEquals(1, pawn.getPosition().getRow());
        Assert.assertEquals(0, pawn.getPosition().getCol());
        Assert.assertFalse(pawn.isWhite());
        Assert.assertTrue(pawn.isBlack());
        Assert.assertEquals(0, pawn.getCount());

        /* WHITE PIECE */
        pawn = new Pawn(6, 0, true);

        Assert.assertEquals(6, pawn.getPosition().getRow());
        Assert.assertEquals(0, pawn.getPosition().getCol());
        Assert.assertTrue(pawn.isWhite());
        Assert.assertFalse(pawn.isBlack());
        Assert.assertEquals(0, pawn.getCount());
    }

    @Test
    public void testIsValidMoveVertical() {
        testIsValidMoveVertical4Black();
        testIsValidMoveVertical4White();
    }

    private void testIsValidMoveVertical4Black() {
        /* This test case checks move to vertical */
        /* BLACK PIECE */
        Pawn pawnBlack = new Pawn(1, 4, false);

        /* 1 square movement at the first time */
        // front
        Position position = new Position(2, 4);
        Assert.assertTrue(pawnBlack.isValidMove(position));

        // behind
        position.setRow(0);
        Assert.assertFalse(pawnBlack.isValidMove(position));

        /* 2 squares movement at the first time */
        pawnBlack.setPosition(new Position(2, 4));
        // front
        position.setRow(4);
        Assert.assertTrue(pawnBlack.isValidMove(position));

        // behind
        position.setRow(0);
        Assert.assertFalse(pawnBlack.isValidMove(position));

        /* 3 squares movement at the first time */
        pawnBlack.setPosition(new Position(3, 4));
        // front
        position.setRow(6);
        Assert.assertFalse(pawnBlack.isValidMove(position));
        // behind
        position.setRow(0);
        Assert.assertFalse(pawnBlack.isValidMove(position));

        /* 1 square movement after the second times */
        pawnBlack.addCount();
        pawnBlack.setPosition(new Position(1, 4));
        // front
        position = new Position(2, 4);
        Assert.assertTrue(pawnBlack.isValidMove(position));

        // behind
        position.setRow(0);
        Assert.assertFalse(pawnBlack.isValidMove(position));

        /* 2 squares movement after the second time */
        pawnBlack.setPosition(new Position(2, 4));
        // front
        position.setRow(4);
        Assert.assertFalse(pawnBlack.isValidMove(position));

        // behind
        position.setRow(0);
        Assert.assertFalse(pawnBlack.isValidMove(position));

        /* 3 squares movement after the second time */
        pawnBlack.setPosition(new Position(3, 4));
        // front
        position.setRow(6);
        Assert.assertFalse(pawnBlack.isValidMove(position));
        // behind
        position.setRow(0);
        Assert.assertFalse(pawnBlack.isValidMove(position));
    }
    private void testIsValidMoveVertical4White() {
        /* This test case checks move to vertical */
        /* BLACK PIECE */
        Pawn pawnWhite = new Pawn(6, 4, true);

        /* 1 square movement at the first time */
        // front
        Position position = new Position(5, 4);
        Assert.assertTrue(pawnWhite.isValidMove(position));

        // behind
        position.setRow(7);
        Assert.assertFalse(pawnWhite.isValidMove(position));

        /* 2 squares movement at the first time */
        pawnWhite.setPosition(new Position(5, 4));
        // front
        position.setRow(3);
        Assert.assertTrue(pawnWhite.isValidMove(position));

        // behind
        position.setRow(7);
        Assert.assertFalse(pawnWhite.isValidMove(position));

        /* 3 squares movement at the first time */
        pawnWhite.setPosition(new Position(4, 4));
        // front
        position.setRow(1);
        Assert.assertFalse(pawnWhite.isValidMove(position));
        // behind
        position.setRow(7);
        Assert.assertFalse(pawnWhite.isValidMove(position));

        /* 1 square movement after the second times */
        pawnWhite.addCount();
        pawnWhite.setPosition(new Position(6, 4));
        // front
        position = new Position(5, 4);
        Assert.assertTrue(pawnWhite.isValidMove(position));

        // behind
        position.setRow(7);
        Assert.assertFalse(pawnWhite.isValidMove(position));

        /* 2 squares movement after the second time */
        pawnWhite.setPosition(new Position(5, 4));
        // front
        position.setRow(3);
        Assert.assertFalse(pawnWhite.isValidMove(position));

        // behind
        position.setRow(7);
        Assert.assertFalse(pawnWhite.isValidMove(position));

        /* 3 squares movement after the second time */
        pawnWhite.setPosition(new Position(4, 4));
        // front
        position.setRow(1);
        Assert.assertFalse(pawnWhite.isValidMove(position));
        // behind
        position.setRow(7);
        Assert.assertFalse(pawnWhite.isValidMove(position));
    }

    @Test
    public void testIsValidMoveHorizontally() {
        /* This test case checks move to horizontally */
        // Both pieces of Black and White has same condition (rules)
        //  - cannot accept horizontally movement
        Pawn pawn = new Pawn(1, 3, false);

        /* 1 square movement */
        // at left side
        Position position = new Position(1, 2);
        Assert.assertFalse(pawn.isValidMove(position));

        // at right side
        position.setCol(4);
        Assert.assertFalse(pawn.isValidMove(position));

        /* 2 squares movement */
        // at left side
        position.setCol(1);
        Assert.assertFalse(pawn.isValidMove(position));

        // at right side
        position.setCol(5);
        Assert.assertFalse(pawn.isValidMove(position));
    }

    @Test
    public void testIsValidMoveDiagonally() {
        /* This test case checks move to horizontally */

        /* BLACK PIECE */
        Pawn pawnBlack = new Pawn(1, 4, false);

        /* 1 square movement */
        // front at left side
        Position position = new Position(2, 3);
        Assert.assertTrue(pawnBlack.isValidMove(position));

        // front at right side
        position.setCol(5);
        Assert.assertTrue(pawnBlack.isValidMove(position));

        // behaind at left side
        position.setRow(0);
        position.setCol(3);
        Assert.assertFalse(pawnBlack.isValidMove(position));

        // behaind at right side
        position.setCol(5);
        Assert.assertFalse(pawnBlack.isValidMove(position));

        /* 2 squares movement */
        pawnBlack.setPosition(new Position(3, 4));
        // front at left side
        position = new Position(5, 2);
        Assert.assertFalse(pawnBlack.isValidMove(position));

        // front at right side
        position.setCol(6);
        Assert.assertFalse(pawnBlack.isValidMove(position));

        // behaind at left side
        position.setRow(1);
        position.setCol(2);
        Assert.assertFalse(pawnBlack.isValidMove(position));

        // behaind at right side
        position.setCol(6);
        Assert.assertFalse(pawnBlack.isValidMove(position));


        /* WHITE PIECE */
        Pawn pawnWhite = new Pawn(6, 4, true);

        /* 1 square movement */
        // front at left side
        position = new Position(5, 3);
        Assert.assertTrue(pawnWhite.isValidMove(position));

        // front at right side
        position.setCol(5);
        Assert.assertTrue(pawnWhite.isValidMove(position));

        // behaind at left side
        position.setRow(7);
        position.setCol(3);
        Assert.assertFalse(pawnWhite.isValidMove(position));

        // behaind at right side
        position.setCol(5);
        Assert.assertFalse(pawnWhite.isValidMove(position));

        /* 2 squares movement */
        pawnWhite.setPosition(new Position(4, 4));
        // front at left side
        position = new Position(3, 2);
        Assert.assertFalse(pawnWhite.isValidMove(position));

        // front at right side
        position.setCol(6);
        Assert.assertFalse(pawnWhite.isValidMove(position));

        // behaind at left side
        position.setRow(6);
        position.setCol(2);
        Assert.assertFalse(pawnWhite.isValidMove(position));

        // behaind at right side
        position.setCol(6);
        Assert.assertFalse(pawnWhite.isValidMove(position));
    }
}