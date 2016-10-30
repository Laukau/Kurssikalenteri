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
public class KnightTest {
    private ChessBoard board;
    private Knight k1;
    private Knight k2;
    private Square s1;
    private Square s2;
    
    @Before
    public void setUp() {
        board = new ChessBoard();
        k1 = new Knight(WHITE);
        k2 = new Knight(BLACK);
        s1 = new Square(6, 0);
        s2 = new Square(5, 3);
    }
    
    @Test
    public void canMoveLikeKnight() {
        assertTrue(k2.legalMove(s2, new Square(4, 1), board));
        assertTrue(k2.legalMove(s2, new Square(6, 1), board));
        assertTrue(k2.legalMove(s2, new Square(4, 5), board));
        assertTrue(k2.legalMove(s2, new Square(6, 5), board));
        assertTrue(k2.legalMove(s2, new Square(3, 2), board));
        assertTrue(k2.legalMove(s2, new Square(7, 4), board));
    }
    
    @Test
    public void cannotMoveUnlikeKnight() {
        assertFalse(k2.legalMove(s2, new Square(5, 2), board));
        assertFalse(k2.legalMove(s2, new Square(6, 4), board));
        assertFalse(k2.legalMove(s2, new Square(3, 3), board));
        assertFalse(k2.legalMove(s2, new Square(3, 5), board));
    }
    
    @Test
    public void canJumpOverPieces() {
        assertTrue(k1.legalMove(s1, new Square(5, 2), board));
        board.setPiece(k2, new Square(6,2));
        assertTrue(k1.legalMove(s1, new Square(7, 2), board));
    }
}
