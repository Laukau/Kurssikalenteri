/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.piece;

import org.junit.Before;
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
public class PawnTest {
    private ChessBoard board;
    private Pawn pawn1;
    private Pawn pawn2;
    
    @Before
    public void setUp() {
        board = new ChessBoard();
        pawn1 = new Pawn(WHITE);
        pawn2 = new Pawn(BLACK);
        
    }
    
    @Test
    public void canMoveOneSquareForward() {
        assertTrue(pawn1.legalMove(new Square(7,1), new Square(7,2), board));
        assertTrue(pawn2.legalMove(new Square(0,6), new Square(0,5), board));
    }
    
    @Test
    public void cannotMoveBackwards() {
        Square pos1 = new Square(2,4);
        Square pos2 = new Square(5,3);
        board.setPiece(pawn1, pos1);
        board.setPiece(pawn2, pos2);
        
        assertFalse(pawn1.legalMove(pos1, new Square(2,3), board));
        assertFalse(pawn2.legalMove(pos2, new Square(5,4), board));
    }
    
    @Test
    public void canMoveTwoSquaresWithFirstMove() {
        assertTrue(pawn1.legalMove(new Square(1,1), new Square(1,3), board));
        assertTrue(pawn2.legalMove(new Square(5,6), new Square(5,4), board));
    }
    
    @Test
    public void cannotMoveTwoSquaresAfterFirstMove() {
        Square to = new Square(7,2);
        pawn1.legalMove(new Square(7,1), to, board);
        board.setPiece(pawn1, to);
        assertFalse(pawn1.legalMove(to, new Square(7,4), board));
    }
    
    @Test
    public void canCapture() {
        Square sqr1 = new Square(4,5);
        Square sqr2 = new Square(3,3);
        
        board.setPiece(new Pawn(WHITE), sqr1);
        board.setPiece(new Pawn(BLACK), sqr2);
        
        pawn2.legalNormalMove(new Square(4,6), new Square(5,5), board);
        pawn1.legalNormalMove(new Square(3,2), new Square(2,3), board);
        assertNull(board.getPiece(sqr1));
        assertNull(board.getPiece(sqr2));
    }
}
