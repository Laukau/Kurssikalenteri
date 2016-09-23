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
import static shakki.piece.Color.WHITE;

/**
 *
 * @author Laura
 */
public class RookTest {
    Rook rook;
    
    public RookTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        rook = new Rook(0,2,WHITE);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of possibleMove method, of class Rook.
     */
    
    @Test
    public void testPossibleMove() {
        
    }
    
}
