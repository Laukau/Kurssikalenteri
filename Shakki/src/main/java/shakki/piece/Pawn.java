/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.piece;

/**
 *
 * @author Laura
 */
public class Pawn extends Piece {

    public Pawn(int x, int y, Color color) {
        super(x, y, color);
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    @Override
    public boolean possibleMove(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
