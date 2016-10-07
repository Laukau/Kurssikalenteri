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
import shakki.game.Position;
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
        assertTrue(pawn1.legalMove(new Position(7,1), new Position(7,2), board));
        assertTrue(pawn2.legalMove(new Position(0,6), new Position(0,5), board));
    }
    
    @Test
    public void cannotMoveBackwards() {
        Position pos1 = new Position(2,3);
        Position pos2 = new Position(5,3);
        board.setPiece(pawn1, pos1);
        board.setPiece(pawn2, pos2);
        
        assertFalse(pawn1.legalMove(pos1, new Position(2,2), board));
        assertFalse(pawn2.legalMove(pos2, new Position(5,4), board));
    }
    
    @Test
    public void canMoveTwoSquaresWithFirstMove() {
        assertTrue(pawn1.legalMove(new Position(1,1), new Position(1,3), board));
        assertTrue(pawn2.legalMove(new Position(5,6), new Position(5,4), board));
    }
    
    @Test
    public void cannotMoveTwoSquaresAfterFirstMove() {
        Position to = new Position(7,2);
        pawn1.legalMove(new Position(7,1), to, board);
        board.setPiece(pawn1, to);
        assertTrue(pawn1.legalMove(to, new Position(7,4), board));
    }
}
