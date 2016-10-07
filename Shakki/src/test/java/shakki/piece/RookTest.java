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
import shakki.game.ChessBoard;
import static shakki.piece.Color.WHITE;

/**
 *
 * @author Laura
 */
public class RookTest {

    Rook rook;
    ChessBoard board;

    @Before
    public void setUp() {
        rook = new Rook(WHITE);
        board = new ChessBoard();
    }
    
    @Test
    public void testLegalMove() {
        
    }

}
