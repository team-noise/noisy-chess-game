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
        Position positionFrom = new Position(1, 4);

        /* 1 square movement at the first time */
        // front (1, 4) -> (2, 4)
        Position positionTo = new Position(positionFrom.getRow()+1, positionFrom.getCol());
        Assert.assertTrue(pawnBlack.isValidMove(positionTo));
        // behind (1, 4) -> (0, 4)
        positionTo = new Position(positionFrom.getRow()-1, positionFrom.getCol());
        Assert.assertFalse(pawnBlack.isValidMove(positionTo));

        /* 2 squares movement at the first time */
        pawnBlack.setPosition(new Position(2, 4));
        positionFrom.setRow(2);
        positionFrom.setCol(4);
        // front (2, 4) -> (4, 4)
        positionTo = new Position(positionFrom.getRow()+2, positionFrom.getCol());
        Assert.assertTrue(pawnBlack.isValidMove(positionTo));
        // behind (2, 4) -> (0, 4)
        positionTo = new Position(positionFrom.getRow()-2, positionFrom.getCol());
        Assert.assertFalse(pawnBlack.isValidMove(positionTo));

        /* 3 squares movement at the first time */
        pawnBlack.setPosition(new Position(3, 4));
        positionFrom.setRow(3);
        positionFrom.setCol(4);
        // front (3, 4) -> (6, 4)
        positionTo = new Position(positionFrom.getRow()+3, positionFrom.getCol());
        Assert.assertFalse(pawnBlack.isValidMove(positionTo));
        // behind (3, 4) -> (0, 4)
        positionTo = new Position(positionFrom.getRow()-3, positionFrom.getCol());
        Assert.assertFalse(pawnBlack.isValidMove(positionTo));

        /* 1 square movement after the second times */
        pawnBlack.addCount();
        pawnBlack.setPosition(new Position(1, 4));
        positionFrom.setRow(1);
        positionFrom.setCol(4);
        // front (1, 4) -> (2, 4)
        positionTo = new Position(positionFrom.getRow()+1, positionFrom.getCol());
        Assert.assertTrue(pawnBlack.isValidMove(positionTo));
        // behind (1, 4) -> (0, 4)
        positionTo = new Position(positionFrom.getRow()-1, positionFrom.getCol());
        Assert.assertFalse(pawnBlack.isValidMove(positionTo));

        /* 2 squares movement after the second time */
        pawnBlack.setPosition(new Position(2, 4));
        positionFrom.setRow(2);
        positionFrom.setCol(4);
        // front (2, 4) -> (4, 4)
        positionTo = new Position(positionFrom.getRow()+2, positionFrom.getCol());
        Assert.assertFalse(pawnBlack.isValidMove(positionTo));
        // behind (2, 4) -> (0, 4)
        positionTo = new Position(positionFrom.getRow()-2, positionFrom.getCol());
        Assert.assertFalse(pawnBlack.isValidMove(positionTo));

        /* 3 squares movement after the second time */
        pawnBlack.setPosition(new Position(3, 4));
        positionFrom.setRow(3);
        positionFrom.setCol(4);
        // front (3, 4) -> (6, 4)
        positionTo = new Position(positionFrom.getRow()+3, positionFrom.getCol());
        Assert.assertFalse(pawnBlack.isValidMove(positionTo));
        // behind (3, 4) -> (0, 4)
        positionTo = new Position(positionFrom.getRow()-3, positionFrom.getCol());
        Assert.assertFalse(pawnBlack.isValidMove(positionTo));
    }
    private void testIsValidMoveVertical4White() {
        /* This test case checks move to vertical */
        /* BLACK PIECE */
        Pawn pawnWhite = new Pawn(6, 4, true);
        Position positionFrom = new Position(6, 4);

        /* 1 square movement at the first time */
        // front (6, 4) -> (5, 4)
        Position positionTo = new Position(positionFrom.getRow()-1, positionFrom.getCol());
        Assert.assertTrue(pawnWhite.isValidMove(positionTo));
        // behind (6, 4) -> (7, 4)
        positionTo = new Position(positionFrom.getRow()+1, positionFrom.getCol());
        Assert.assertFalse(pawnWhite.isValidMove(positionTo));

        /* 2 squares movement at the first time */
        pawnWhite.setPosition(new Position(5, 4));
        positionFrom.setRow(5);
        positionFrom.setCol(4);
        // front (5, 4) -> (3, 4)
        positionTo = new Position(positionFrom.getRow()-2, positionFrom.getCol());
        Assert.assertTrue(pawnWhite.isValidMove(positionTo));
        // behind (5, 4) -> (7, 4)
        positionTo = new Position(positionFrom.getRow()-7, positionFrom.getCol());
        Assert.assertFalse(pawnWhite.isValidMove(positionTo));

        /* 3 squares movement at the first time */
        pawnWhite.setPosition(new Position(4, 4));
        positionFrom.setRow(4);
        positionFrom.setCol(4);
        // front (4, 4) -> (1, 4)
        positionTo = new Position(positionFrom.getRow()-3, positionFrom.getCol());
        Assert.assertFalse(pawnWhite.isValidMove(positionTo));
        // behind (4, 4) -> (7, 4)
        positionTo = new Position(positionFrom.getRow()+3, positionFrom.getCol());
        Assert.assertFalse(pawnWhite.isValidMove(positionTo));

        /* 1 square movement after the second times */
        pawnWhite.addCount();
        pawnWhite.setPosition(new Position(6, 4));
        positionFrom.setRow(6);
        positionFrom.setCol(4);
        // front (6, 4) -> (5, 4)
        positionTo = new Position(positionFrom.getRow()-1, positionFrom.getCol());
        Assert.assertTrue(pawnWhite.isValidMove(positionTo));
        // behind (6, 4) -> (7, 4)
        positionTo = new Position(positionFrom.getRow()+1, positionFrom.getCol());
        Assert.assertFalse(pawnWhite.isValidMove(positionTo));

        /* 2 squares movement after the second time */
        pawnWhite.setPosition(new Position(5, 4));
        positionFrom.setRow(5);
        positionFrom.setCol(4);
        // front (5, 4) -> (3, 4)
        positionTo = new Position(positionFrom.getRow()-2, positionFrom.getCol());
        Assert.assertFalse(pawnWhite.isValidMove(positionTo));
        // behind (5, 4) -> (7, 4)
        positionTo = new Position(positionFrom.getRow()-7, positionFrom.getCol());
        Assert.assertFalse(pawnWhite.isValidMove(positionTo));

        /* 3 squares movement after the second time */
        pawnWhite.setPosition(new Position(4, 4));
        positionFrom.setRow(4);
        positionFrom.setCol(4);
        // front (4, 4) -> (1, 4)
        positionTo = new Position(positionFrom.getRow()-3, positionFrom.getCol());
        Assert.assertFalse(pawnWhite.isValidMove(positionTo));
        // behind (4, 4) -> (7, 4)
        positionTo = new Position(positionFrom.getRow()+3, positionFrom.getCol());
        Assert.assertFalse(pawnWhite.isValidMove(positionTo));
    }

    @Test
    public void testIsValidMoveHorizontally() {
        /* This test case checks move to horizontally */
        // Both pieces of Black and White has same condition (rules)
        //  - cannot accept horizontally movement
        Pawn pawn = new Pawn(1, 4, false);
        Position positionFrom = new Position(1, 4);
        Position positionTo;

        /* 1 square movement */
        // left (1, 4) -> (1, 3)
        positionTo = new Position(positionFrom.getRow(), positionFrom.getCol()-1);
        Assert.assertFalse(pawn.isValidMove(positionTo));
        // right (1, 4) -> (1, 5)
        positionTo = new Position(positionFrom.getRow(), positionFrom.getCol()+1);
        Assert.assertFalse(pawn.isValidMove(positionTo));

        /* 2 squares movement */
        // left (1, 4) -> (1, 2)
        positionTo = new Position(positionFrom.getRow(), positionFrom.getCol()-2);
        Assert.assertFalse(pawn.isValidMove(positionTo));
        // right (1, 4) -> (1, 6)
        positionTo = new Position(positionFrom.getRow(), positionFrom.getCol()+2);
        Assert.assertFalse(pawn.isValidMove(positionTo));
    }

    @Test
    public void testIsValidMoveDiagonally() {
        /* This test case checks move to horizontally */

        /* BLACK PIECE */
        Pawn pawnBlack = new Pawn(1, 4, false);
        Position positionFrom = new Position(1, 4);
        Position positionTo;

        /* 1 square movement */
        // front at left side (1, 4) -> (2, 3)
        positionTo = new Position(positionFrom.getRow()+1, positionFrom.getCol()-1);
        Assert.assertTrue(pawnBlack.isValidMove(positionTo));
        // front at right side (1, 4) -> (2, 5)
        positionTo = new Position(positionFrom.getRow()+1, positionFrom.getCol()+1);
        Assert.assertTrue(pawnBlack.isValidMove(positionTo));
        // behind at left side (1, 4) -> (0, 3)
        positionTo = new Position(positionFrom.getRow()-1, positionFrom.getCol()-1);
        Assert.assertFalse(pawnBlack.isValidMove(positionTo));
        // behind at right side (1, 4) -> (0, 5)
        positionTo = new Position(positionFrom.getRow()-1, positionFrom.getCol()+1);
        Assert.assertFalse(pawnBlack.isValidMove(positionTo));

        /* 2 squares movement */
        pawnBlack.setPosition(new Position(2, 4));
        positionFrom.setRow(2);
        positionFrom.setCol(4);
        // front at left side (2, 4) -> (4, 2)
        positionTo = new Position(positionFrom.getRow()+2, positionFrom.getCol()-2);
        Assert.assertFalse(pawnBlack.isValidMove(positionTo));
        // front at right side (2, 4) -> (4, 6)
        positionTo = new Position(positionFrom.getRow()+2, positionFrom.getCol()+2);
        Assert.assertFalse(pawnBlack.isValidMove(positionTo));
        // behind at left side (2, 4) -> (0, 2)
        positionTo = new Position(positionFrom.getRow()-2, positionFrom.getCol()-2);
        Assert.assertFalse(pawnBlack.isValidMove(positionTo));
        // behind at right side (2, 4) -> (0, 6)
        positionTo = new Position(positionFrom.getRow()-2, positionFrom.getCol()+2);
        Assert.assertFalse(pawnBlack.isValidMove(positionTo));


        /* WHITE PIECE */
        Pawn pawnWhite = new Pawn(6, 4, true);
        positionFrom = new Position(6, 4);

        /* 1 square movement */
        // front at left side (6, 4) -> (5, 3)
        positionTo = new Position(positionFrom.getRow()-1, positionFrom.getCol()-1);
        Assert.assertTrue(pawnWhite.isValidMove(positionTo));
        // front at right side (6, 4) -> (5, 5)
        positionTo = new Position(positionFrom.getRow()-1, positionFrom.getCol()+1);
        Assert.assertTrue(pawnWhite.isValidMove(positionTo));
        // behind at left side (6, 4) -> (7, 3)
        positionTo = new Position(positionFrom.getRow()+1, positionFrom.getCol()-1);
        Assert.assertFalse(pawnWhite.isValidMove(positionTo));
        // behind at right side (6, 4) -> (7, 5)
        positionTo = new Position(positionFrom.getRow()+1, positionFrom.getCol()+1);
        Assert.assertFalse(pawnWhite.isValidMove(positionTo));

        /* 2 squares movement */
        pawnWhite.setPosition(new Position(4, 4));
        positionFrom.setRow(5);
        positionFrom.setCol(4);
        // front at left side (5, 4) -> (3, 2)
        positionTo = new Position(positionFrom.getRow()-2, positionFrom.getCol()-2);
        Assert.assertFalse(pawnWhite.isValidMove(positionTo));
        // front at right side (5, 4) -> (3, 6)
        positionTo = new Position(positionFrom.getRow()-2, positionFrom.getCol()+2);
        Assert.assertFalse(pawnWhite.isValidMove(positionTo));
        // behind at left side (5, 4) -> (7, 2)
        positionTo = new Position(positionFrom.getRow()+2, positionFrom.getCol()-2);
        Assert.assertFalse(pawnWhite.isValidMove(positionTo));
        // behind at right side (5, 4) -> (7, 6)
        positionTo = new Position(positionFrom.getRow()+2, positionFrom.getCol()+2);
        Assert.assertFalse(pawnWhite.isValidMove(positionTo));
    }
}