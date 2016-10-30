/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.player;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static shakki.piece.Color.BLACK;
import static shakki.piece.Color.WHITE;
import shakki.piece.King;
import shakki.piece.Pawn;

/**
 *
 * @author Laura
 */
public class HumanPlayerTest {

    private HumanPlayer hp;

    @Before
    public void setUp() {
        hp = new HumanPlayer();
    }

    @Test
    public void constructorSetsWhiteTurn() {
        assertEquals(true, hp.whiteTurn());
    }

    @Test
    public void changeTurnChangesTurn() {
        boolean turn = hp.whiteTurn();
        hp.changeTurn();
        boolean newTurn = hp.whiteTurn();
        assertEquals(turn, !newTurn);
    }
    
    @Test
    public void movingOwnPieceReturnsTrue() {
        assertTrue(hp.movingOwnPiece(new King(WHITE)));
        hp.changeTurn();
        assertTrue(hp.movingOwnPiece(new King(BLACK)));
    }
    
    @Test
    public void movingOpponentsPieceReturnsFalse() {
        assertFalse(hp.movingOwnPiece(new Pawn(BLACK)));
        hp.changeTurn();
        assertFalse(hp.movingOwnPiece(new Pawn(WHITE)));
    }
}
