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

/**
 *
 * @author Laura
 */
public class KingTest {
    
    public KingTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of move method, of class King.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        int x = 0;
        int y = 0;
        King instance = null;
        instance.move(x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of possibleMove method, of class King.
     */
    @Test
    public void testPossibleMove() {
        System.out.println("possibleMove");
        int x = 0;
        int y = 0;
        King instance = null;
        boolean expResult = false;
        boolean result = instance.possibleMove(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getsCaptured method, of class King.
     */
    @Test
    public void testGetsCaptured() {
        System.out.println("getsCaptured");
        King instance = null;
        instance.getsCaptured();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRow method, of class King.
     */
    @Test
    public void testGetRow() {
        System.out.println("getRow");
        King instance = null;
        int expResult = 0;
        int result = instance.getRow();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumn method, of class King.
     */
    @Test
    public void testGetColumn() {
        System.out.println("getColumn");
        King instance = null;
        int expResult = 0;
        int result = instance.getColumn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAlive method, of class King.
     */
    @Test
    public void testIsAlive() {
        System.out.println("isAlive");
        King instance = null;
        boolean expResult = false;
        boolean result = instance.isAlive();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
