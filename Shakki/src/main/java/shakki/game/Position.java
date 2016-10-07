/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.game;

/**
 *
 * @author Laura
 */
public class Position {
    private int x;
    private int y;
    
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getRow() {
        return this.y;
    }
    
    public int getColumn() {
        return this.x;
    }
    
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Position)) {
            return false;
        }
        Position pos = (Position) o;
        return pos.x == this.x && pos.y == this.y;
    }
}
