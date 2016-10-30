/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.piece;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import shakki.game.ChessBoard;
import shakki.game.Square;
import static shakki.piece.Color.BLACK;
import static shakki.piece.Color.WHITE;

/**
 *
 * @author Laura
 */
public class BishopTest {

    private Bishop wBishop;
    private Bishop bBishop;
    private ChessBoard board;
    private Square s1;
    private Square s2;

    @Before
    public void setUp() {
        wBishop = new Bishop(WHITE);
        bBishop = new Bishop(BLACK);
        board = new ChessBoard();

        s1 = new Square(2, 0);
        s2 = new Square(3, 4);
        board.setPiece(wBishop, s1);
        board.setPiece(bBishop, s2);
    }
    
    @Test
    public void canMoveDiagonally() {
        assertTrue(bBishop.legalMove(s2, new Square(4, 5), board));
        assertTrue(bBishop.legalMove(s2, new Square(5, 2), board));
        assertTrue(bBishop.legalMove(s2, new Square(2, 5), board));
        assertTrue(bBishop.legalMove(s2, new Square(1, 2), board));
    }

    @Test
    public void cannotMoveOnTheSameColumnOrRow() {
        assertFalse(bBishop.legalMove(s2, new Square(3, 3), board));
        assertFalse(bBishop.legalMove(s2, new Square(6, 4), board));
    }

    @Test
    public void cannotMoveOverPiece() {
        assertFalse(wBishop.legalMove(s1, new Square(0, 2), board));
        assertFalse(wBishop.legalMove(s1, new Square(7, 5), board));
    }

    @Test
    public void cannotMoveNonDiagonally() {
        assertFalse(bBishop.legalMove(s2, new Square(4, 2), board));
        assertFalse(bBishop.legalMove(s2, new Square(0, 2), board));
    }
}
