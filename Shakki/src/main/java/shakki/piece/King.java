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
public class King extends Piece {

    private int x;
    private int y;
    private boolean alive;

    public King(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    public boolean possibleMove(int x, int y) {

        return true;
    }

}
