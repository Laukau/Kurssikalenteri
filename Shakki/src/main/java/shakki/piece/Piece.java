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
public interface Piece {
    
    
    
    //Checks if a move to square (x,y) is possible for the piece
    boolean possibleMove(int x, int y);

    
    //Removes the piece from play
    void getsCaptured();
    //Moves the piece to a square (x,y)
    void move(int x, int y);
    int getRow();
    int getColumn();
    boolean isAlive();
}
