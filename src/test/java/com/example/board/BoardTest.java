package com.example.board;

import org.junit.Assert;
import org.junit.Test;
import com.example.pieces.Bishop;
import com.example.pieces.King;
import com.example.pieces.Knight;
import com.example.pieces.Pawn;
import com.example.pieces.Piece;
import com.example.pieces.Queen;
import com.example.pieces.Rook;

public class BoardTest {
    @Test
    public void testCreationInstance() {
        Board board = new Board();

        Assert.assertEquals(8, Board.BOARD_SIZE);
        Assert.assertEquals(8, board.getChessBoard().length);

        // check the number of pieces
        int pawnNum = 0, rookNum = 0, knightNum = 0, bishopNum = 0, queenNum = 0, kingNum = 0;
        for (Piece piece : board.getPieces()) {
            if (piece instanceof Pawn)
                pawnNum++;
            else if (piece instanceof Rook)
                rookNum++;
            else if (piece instanceof Knight)
                knightNum++;
            else if (piece instanceof Bishop)
                bishopNum++;
            else if (piece instanceof Queen)
                queenNum++;
            else if (piece instanceof King)
                kingNum++;
        }
        Assert.assertEquals(8 * 4, board.getPieces().size());
        Assert.assertEquals(8 * 2, pawnNum);
        Assert.assertEquals(2 * 2, rookNum);
        Assert.assertEquals(2 * 2, knightNum);
        Assert.assertEquals(2 * 2, bishopNum);
        Assert.assertEquals(1 * 2, queenNum);
        Assert.assertEquals(1 * 2, kingNum);
    }

    @Test
    public void testMovePiece() {}

    @Test
    public void testPawnPromotion() {
        /* Pawn */
        Board board = new Board();
        // Black
        Assert.assertFalse(board.pawnPromotion(1, 1));
        board.movePiece(1, 1, 3, 1);
        board.movePiece(3, 1, 4, 1);
        board.movePiece(4, 1, 5, 1);
        board.movePiece(5, 1, 6, 2);
        board.movePiece(6, 2, 7, 1);
        Assert.assertTrue(board.pawnPromotion(7, 1));
        // White
        Assert.assertFalse(board.pawnPromotion(6, 6));
        board.movePiece(6, 6, 4, 6);
        board.movePiece(4, 6, 3, 6);
        board.movePiece(3, 6, 2, 6);
        board.movePiece(2, 6, 1, 5);
        board.movePiece(1, 5, 0, 6);
        Assert.assertTrue(board.pawnPromotion(0, 6));

        /* Other pieces */
        board = new Board();
        // Black
        Assert.assertFalse(board.pawnPromotion(0, 0)); // rook
        Assert.assertFalse(board.pawnPromotion(0, 1)); // knight
        Assert.assertFalse(board.pawnPromotion(0, 2)); // bishop
        Assert.assertFalse(board.pawnPromotion(0,3)); // queen
        Assert.assertFalse(board.pawnPromotion(0, 4)); // king
        // White
        Assert.assertFalse(board.pawnPromotion(7, 0)); // rook
        Assert.assertFalse(board.pawnPromotion(7, 1)); // knight
        Assert.assertFalse(board.pawnPromotion(7, 2)); // bishop
        Assert.assertFalse(board.pawnPromotion(7,3)); // queen
        Assert.assertFalse(board.pawnPromotion(7, 4)); // king
    }

    @Test
    public void testPawnPromoteTo() {}
}
