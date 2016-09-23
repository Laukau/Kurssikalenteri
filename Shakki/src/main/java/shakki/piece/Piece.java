/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.piece;

import java.util.List;

/**
 *
 * @author Laura
 */
public abstract class Piece {

    private int x;
    private int y;
    private boolean alive;
    private final Color color;

    public Piece(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.alive = true;
        this.color = color;
    }

    //Checks if a move to square (x,y) is possible for the piece
    public boolean possibleMove(int x, int y) {
        return true;
    }

    ;
    
    //Checks if the square is occupied. Returns 1 if it's occupied by an opponent's piece,
    // -1 if it's occupied by that player's piece and 0 if the square is unoccupied.
    public int squareOccupied(int x, int y, List<Piece> pieces) {
        for (Piece piece : pieces) {
            if ((piece.getRow() == x) && (piece.getColumn() == y)) {
                if (piece.getColor() == this.color) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
        return 0;
    }

    //Removes the piece from play
    public void getsCaptured() {
        this.alive = false;
    }

    //Moves the piece to a square (x,y)
    public boolean move(int x, int y) {
        if (this.x == x && this.y == y) {
            System.out.println("Some piece has to move");
            return false;
        } else if ((0 <= x && x < 8 && 0 <= y && y < 8) && possibleMove(x, y)) {
            this.x = x;
            this.y = y;
            return true;
        } else {
            System.out.println("Move not possible");
            return false;
        }

    }

    public int getRow() {
        return this.x;
    }

    public int getColumn() {
        return this.y;
    }

    public Color getColor() {
        return this.color;
    }

    public boolean isAlive() {
        return this.alive;
    }

    @Override
    public String toString() {
        return "(" + getRow() + "," + getColumn() + ") " + getColor();
    }

}
