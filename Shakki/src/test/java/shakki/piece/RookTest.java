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
public class RookTest {
    private Rook wRook;
    private Rook bRook;
    private ChessBoard board;
    private Square s1;
    private Square s2;

    @Before
    public void setUp() {
        wRook = new Rook(WHITE);
        bRook = new Rook(BLACK);
        board = new ChessBoard();
        
        s1 = new Square(0,0);
        s2 = new Square(2,5);
        board.setPiece(wRook, s1);
        board.setPiece(bRook, s2);
    }
    
    @Test
    public void canMoveOnTheSameRow() {
       assertTrue(bRook.legalMove(s2, new Square(7,5), board));
       assertTrue(bRook.legalMove(s2, new Square(0,5), board));
    }
    
    @Test
    public void canMoveOnTheSameColumn() {
        assertTrue(bRook.legalMove(s2, new Square(2,3), board));
    }
    
    @Test
    public void cannotMoveOverPiece() {
        assertFalse(wRook.legalMove(s1, new Square(0,4), board));
        assertFalse(wRook.legalMove(s1, new Square(2,0), board));
    }
    
    @Test
    public void cannotMoveOutOfRowOrColumn() {
        assertFalse(bRook.legalMove(s2, new Square(3,4), board));
        assertFalse(bRook.legalMove(s2, new Square(6,3), board));
    }

}
