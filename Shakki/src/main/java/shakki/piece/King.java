/**
 * Class provides the kings and their moving logic.
 */
package shakki.piece;

import shakki.game.ChessBoard;
import shakki.game.Square;

public class King extends Piece {

    /**
     * Constructor sets the color.
     *
     * @param color The color of the king
     */
    public King(Color color) {
        super(color);
    }

    @Override
    public boolean legalMove(Square from, Square to, ChessBoard board) {
        boolean kingMove = from.getRow() - 1 <= to.getRow() && from.getRow() + 1 >= to.getRow() && from.getColumn() - 1 <= to.getColumn() && from.getColumn() + 1 >= to.getColumn();
        return kingMove;
    }

}
