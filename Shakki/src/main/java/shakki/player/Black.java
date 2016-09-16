/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.player;

import java.util.ArrayList;
import java.util.List;
import shakki.piece.Piece;

/**
 *
 * @author Laura
 */
public class Black implements Player{
    private boolean turnContinues;
    private List<Piece> pieces;
    
    public Black() {
        this.turnContinues = false;
        this.pieces = new ArrayList();
    }
}
