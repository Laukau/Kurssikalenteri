/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.player;

import shakki.piece.Piece;

/**
 *
 * @author Laura
 */
public interface Player {
    
    //Return true if the turn is white's and false if black's
    boolean whiteTurn();
    
    void changeTurn();
    
    boolean movingOwnPiece(Piece piece);
}
