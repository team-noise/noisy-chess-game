package com.example.pieces;

import org.junit.Assert;
import org.junit.Test;

import com.example.common.Position;


public class PieceTest {
    @Test
    public void testAddCount() {
        Piece piece = new Piece(0, 0, false) {
            @Override
            public boolean isValidMove(Position position) {
                return true;
            }
        };

        Assert.assertEquals(0, piece.getCount());

        piece.addCount();
        Assert.assertEquals(1, piece.getCount());

        piece.addCount();
        Assert.assertEquals(2, piece.getCount());
    }

    @Test
    public void testIsAlive() {
        Piece piece = new Piece(0, 0, false) {
            @Override
            public boolean isValidMove(Position position) {
                return true;
            }
        };

        Assert.assertTrue(piece.isAlive());
    }

    @Test
    public void testIsDead() {
        Piece piece = new Piece(0, 0, false) {
            @Override
            public boolean isValidMove(Position position) {
                return true;
            }
        };

        piece.isDead();
        Assert.assertFalse(piece.isAlive());
    }
}