/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.piece;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import shakki.game.ChessBoard;
import shakki.game.Square;
import static shakki.piece.Color.BLACK;
import static shakki.piece.Color.WHITE;

/**
 *
 * @author Laura
 */
public class KingTest {
    private King wKing;
    private King bKing;
    private ChessBoard board;
    
    @Before
    public void setUp() {
        wKing = new King(WHITE);
        bKing = new King(BLACK);
        board = new ChessBoard();
    }
    
    @Test
    public void canMoveOneSquare() {
        Square sqr = new Square(6,4);
        board.setPiece(wKing, sqr);
        assertTrue(wKing.legalMove(sqr, new Square(6,5), board));
        assertTrue(wKing.legalMove(sqr, new Square(6,3), board));
        assertTrue(wKing.legalMove(sqr, new Square(5,4), board));
        assertTrue(wKing.legalMove(sqr, new Square(7,4), board));
        assertTrue(wKing.legalMove(sqr, new Square(7,5), board));
        assertTrue(wKing.legalMove(sqr, new Square(5,3), board));
    }
    
    @Test
    public void cannotMoveMoreThanOneSquare() {
        Square sqr = new Square(1,3);
        board.setPiece(bKing, sqr);
        assertFalse(bKing.legalMove(sqr, new Square(1,5), board));
        assertFalse(bKing.legalMove(sqr, new Square(3,5), board));
    }
    
}
