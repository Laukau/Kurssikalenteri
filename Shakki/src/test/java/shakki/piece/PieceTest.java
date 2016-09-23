/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.piece;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static shakki.piece.Color.BLACK;
import static shakki.piece.Color.WHITE;

/**
 *
 * @author Laura
 */
public class PieceTest {

    Piece piece;
    Piece p;
    Piece p1;
    Piece p2;
    List<Piece> pieces;

    @Before
    public void setUp() {
        piece = new Piece(6, 2, WHITE) {
        };
        p = new Piece(0, 7, BLACK) {
        };
        p1 = new Piece(1, 2, BLACK) {
        };
        p2 = new Piece(7, 0, WHITE) {
        };
        pieces = new ArrayList();
        pieces.add(p);
        pieces.add(p1);
        pieces.add(p2);
    }

    @Test
    public void constructorSetsPieceRight() {
        assertEquals("(6,2) WHITE", piece.toString());
    }

    @Test
    public void pieceIsAlive() {
        assertEquals(true, piece.isAlive());
    }

    @Test
    public void getsCapturedRemovesPiece() {
        piece.getsCaptured();
        assertEquals(false, piece.isAlive());
    }

    @Test
    public void pieceMovesRight() {
        piece.move(2, 4);
        assertEquals("2, 4", piece.getRow() + ", " + piece.getColumn());
    }

    @Test
    public void cannotMoveOutOfBoard() {
        piece.move(8, 5);
        assertEquals(6, piece.getRow());
        assertEquals(2, piece.getColumn());
    }

    @Test
    public void pieceRecognizesUnoccupiedSquare() {
        int value = piece.squareOccupied(1, 4, pieces);
        assertEquals(0, value);
    }

    @Test
    public void pieceRecognizesOccupiedSquareByOpponent() {
        int value = piece.squareOccupied(0, 7, pieces);
        assertEquals(1, value);
    }

    @Test
    public void pieceRecognizesOccupiedSquareByPlayer() {
        int val = piece.squareOccupied(7, 0, pieces);
        assertEquals(-1, val);
    }
}
