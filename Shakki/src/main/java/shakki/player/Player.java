/**
 * Interface provides methods for keeping track of the players' turns.
 */
package shakki.player;

import shakki.piece.Piece;


public interface Player {
    
    /**
     * Method checks who's turn it is.
     * 
     * @return true if the turn is white's and false if black's
     */
    boolean whiteTurn();
    
    /**
     * Method changes the turn.
     */
    void changeTurn();
    
    /**
     * Method checks if the player is trying to move their own piece.
     * 
     * @param piece Piece that is tried to move
     * @return true if the piece is own and false otherwise
     */
    boolean movingOwnPiece(Piece piece);
}
