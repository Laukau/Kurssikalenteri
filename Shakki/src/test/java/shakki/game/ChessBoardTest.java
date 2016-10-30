/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.game;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import static shakki.piece.Color.BLACK;
import static shakki.piece.Color.WHITE;
import shakki.piece.King;
import shakki.piece.Pawn;
import shakki.piece.Piece;
import shakki.piece.Rook;

/**
 *
 * @author Laura
 */
public class ChessBoardTest {
    private ChessBoard board;
    private Piece p1;
    private Piece p2;
    private Piece p3;
    private Piece p4;
    
    @Before
    public void setUp() {
        board = new ChessBoard();
        p1 = board.getPiece(new Square(0,0));
        p2 = board.getPiece(new Square(3,1));
        p3 = board.getPiece(new Square(7,6));
        p4 = board.getPiece(new Square(4,7));
    }
    
    @Test
    public void constructorSetsPiecesCorrectly() {
        assertEquals(p1.getClass(), Rook.class);
        assertEquals(p2.getClass(), Pawn.class);
        assertEquals(p3.getClass(), Pawn.class);
        assertEquals(p4.getClass(), King.class);
    }
    
    @Test
    public void constructorSetsTeamColorsCorrectly() {
        assertEquals(p2.getColor(), WHITE);
        assertEquals(p4.getColor(), BLACK);
    }
}
