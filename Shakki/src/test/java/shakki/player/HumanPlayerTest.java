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
    public void ChangeTurnChangesTurn() {
        boolean turn = hp.whiteTurn();
        hp.changeTurn();
        boolean newTurn = hp.whiteTurn();
        assertEquals(turn, !newTurn);
    }
}
