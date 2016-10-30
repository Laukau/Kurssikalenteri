/*
 * Provides the squares of the board.
 */
package shakki.game;


public class Square {
    private int x;
    private int y;
    
    /**
     * Constructor sets the coordinates of a square.
     * @param x The column
     * @param y The row
     */
    public Square(int x, int y) {
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
        if (!(o instanceof Square)) {
            return false;
        }
        Square pos = (Square) o;
        return pos.x == this.x && pos.y == this.y;
    }
}
