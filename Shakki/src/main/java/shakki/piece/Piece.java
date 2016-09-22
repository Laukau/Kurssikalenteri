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
public abstract class Piece {
    private int x;
    private int y;
    private boolean alive;
    
    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
        this.alive = true;
    }

    //Checks if a move to square (x,y) is possible for the piece
    abstract boolean possibleMove(int x, int y);

    //Removes the piece from play
    public void getsCaptured() {
        this.alive = false;
    }

    //Moves the piece to a square (x,y)
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getRow() {
        return this.x;
    }

    public int getColumn() {
        return this.y;
    }

    public boolean isAlive() {
        return this.alive;
    }
    
}
