/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.game;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import shakki.piece.Bishop;
import static shakki.piece.Color.BLACK;
import static shakki.piece.Color.WHITE;
import shakki.piece.Knight;
import shakki.piece.Pawn;
import shakki.piece.Rook;

/**
 *
 * @author Laura
 */
public class ChessTest {
    Chess chess;
    
    @Before
    public void setUp() {
        chess = new Chess();
    }
    
    @Test
    public void whitePlayerStarts() {
        assertTrue(chess.getPlayer().whiteTurn());
    }
    
    @Test
    public void cannotMoveFromEmptySquare() {
        Square to = new Square(2,6);
        chess.move(new Square(2,5), to);
        assertTrue(chess.getPlayer().whiteTurn());
        assertTrue(chess.getBoard().getPiece(to).getClass() == Pawn.class);
    }
    
    @Test
    public void cannotMoveOutOfBoard1() {
        Square from = new Square(0,0);
        Square to = new Square(0,-1);
        chess.move(from, to);
        assertTrue(chess.getPlayer().whiteTurn());
    }
    
    @Test 
    public void cannotMoveOutOfBoard2() {
        Square from = new Square(8,4);
        Square to = new Square(7,4);
        chess.move(from, to);
        assertTrue(chess.getPlayer().whiteTurn());
    }
    
    @Test
    public void pieceHasToMove() {
        Square square = new Square(5,1);
        chess.move(square, square);
        assertTrue(chess.getPlayer().whiteTurn());
    }
    
    @Test
    public void cannotMoveOpponentsPiece() {
        chess.move(new Square(2,6), new Square(2,5));
        assertTrue(chess.getPlayer().whiteTurn());
        chess.getPlayer().changeTurn();
        chess.move(new Square(2,1), new Square(2,2));
        assertTrue(!chess.getPlayer().whiteTurn());
    }
    
    @Test
    public void movingChangesTurn() {
        chess.move(new Square(2,1), new Square(2,2));
        assertFalse(chess.getPlayer().whiteTurn());
        chess.move(new Square(7,6), new Square(7,5));
        assertTrue(chess.getPlayer().whiteTurn());
    }
    
    @Test
    public void pieceMoves1() {
        Square from = new Square(1,0);
        Square to = new Square(0,2);
        chess.move(from, to);
        assertNull(chess.getBoard().getPiece(from));
        assertTrue(chess.getBoard().getPiece(to).getClass() == Knight.class);
    }
    
    @Test
    public void pieceMoves2() {
        Square from = new Square(4,6);
        Square to = new Square(4,4);
        chess.getPlayer().changeTurn();
        chess.move(from, to);
        assertNull(chess.getBoard().getPiece(from));
        assertTrue(chess.getBoard().getPiece(to).getClass() == Pawn.class);
    }
    
    @Test
    public void canConquer() {
        Square from = new Square(7,3);
        Square to = new Square(6,4);
        chess.getBoard().setPiece(new Bishop(WHITE), from);
        chess.getBoard().setPiece(new Rook(BLACK), to);
        chess.move(from, to);
        assertNull(chess.getBoard().getPiece(from));
        assertTrue(chess.getBoard().getPiece(to).getClass() == Bishop.class);
    }
    
    @Test
    public void cannotConquerOwnPiece() {
        Square from = new Square(0,0);
        Square to = new Square(0,1);
        chess.move(from, to);
        assertTrue(chess.getBoard().getPiece(from).getClass() == Rook.class);
        assertTrue(chess.getBoard().getPiece(to).getClass() == Pawn.class);
        assertTrue(chess.getPlayer().whiteTurn());
    }
    
    @Test
    public void checkmateWhenKingIsConquered() {
        Square from = new Square(3,5);
        Square to = new Square(4,7);
        chess.getBoard().setPiece(new Knight(WHITE), from);
        assertFalse(chess.checkmate());
        chess.move(from, to);
        assertTrue(chess.checkmate());
    }
}
