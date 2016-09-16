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
public class King implements Piece {
    private int x;
    private int y;
    private boolean alive;
    
    public King(int x, int y) {
        this.x = x;
        this.y = y;
        this.alive = true;
    }
    
    
    @Override
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public boolean possibleMove(int x, int y) {
        
        return true;
    }
    
    @Override
    public void getsCaptured() {
        this.alive = false;
    }
    
    @Override
    public int getRow() {
        return this.x;
    }
    
    @Override
    public int getColumn() {
        return this.y;
    }
    
    @Override
    public boolean isAlive() {
        return this.isAlive();
    }
}
