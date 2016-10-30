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
public class QueenTest {

    private ChessBoard board;
    private Queen q1;
    private Queen q2;
    private Square s1;
    private Square s2;

    @Before
    public void setUp() {
        board = new ChessBoard();
        q1 = new Queen(BLACK);
        q2 = new Queen(WHITE);
        s1 = new Square(3, 7);
        s2 = new Square(2, 4);
        board.setPiece(q2, s2);
    }

    @Test
    public void canMoveOnTheSameRowOrColumn() {
        assertTrue(q2.legalMove(s2, new Square(6, 4), board));
        assertTrue(q2.legalMove(s2, new Square(2, 2), board));
    }

    @Test
    public void canMoveDiagonally() {
        assertTrue(q2.legalMove(s2, new Square(0, 6), board));
        assertTrue(q2.legalMove(s2, new Square(4, 2), board));
    }

    @Test
    public void cannotMoveOutOfRowOrColumnOrNonDiagonally() {
        assertFalse(q2.legalMove(s2, new Square(3, 6), board));
        assertFalse(q2.legalMove(s2, new Square(0, 3), board));
    }

    @Test
    public void cannotMoveOverPiece() {
        assertFalse(q1.legalMove(s1, new Square(3, 5), board));
        assertFalse(q1.legalMove(s1, new Square(5, 5), board));
        assertFalse(q1.legalMove(new Square(1,4), new Square(3,4), board));
    }
}
