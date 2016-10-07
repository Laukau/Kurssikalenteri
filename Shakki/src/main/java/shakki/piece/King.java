/**
 * Class provides the kings and their moving logic.
 */
package shakki.piece;

import shakki.game.ChessBoard;
import shakki.game.Square;

public class King extends Piece {

    private boolean alive;

    public King(Color color) {
        super(color);
    }

    @Override
    public boolean legalMove(Square from, Square to, ChessBoard board) {
        if (!super.legalMove(from, to, board)) {
            return false;
        }
        return from.getRow() - 1 <= to.getRow() && from.getRow() + 1 >= to.getRow() && from.getColumn() - 1 <= to.getColumn() && from.getColumn() + 1 >= to.getColumn();
        
    }

}
