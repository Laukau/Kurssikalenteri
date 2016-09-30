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
public class Rook extends Piece {

    public Rook(Color color) {
        super(color);
    }


    @Override
    public boolean legalMove(Position from, Position to, ChessBoard board) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
