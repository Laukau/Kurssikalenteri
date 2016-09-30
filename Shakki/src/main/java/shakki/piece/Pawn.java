/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.piece;

import shakki.game.ChessBoard;
import shakki.game.Position;

/**
 *
 * @author Laura
 */
public class Pawn extends Piece {

    public Pawn(Color color) {
        super(color);
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    @Override
    public boolean legalMove(Position from, Position to, ChessBoard board) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
