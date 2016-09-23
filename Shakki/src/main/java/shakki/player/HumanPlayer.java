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
public class HumanPlayer implements Player{
    private boolean whitePlayer;
    
    public HumanPlayer() {
        this.whitePlayer = true;
    }
    @Override
    public boolean whiteTurn() {
        return this.whitePlayer;
    }
    @Override
    public void changeTurn() {
        boolean turn = this.whitePlayer;
        this.whitePlayer = !turn;
    }
}
