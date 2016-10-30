/**
 * Class provides the rooks and their moving logic.
 */
package shakki.piece;

import shakki.game.ChessBoard;
import shakki.game.Square;

public class Rook extends Piece {

    /**
     * Constructor sets the color.
     *
     * @param color Color of the rook
     */
    public Rook(Color color) {
        super(color);
    }

    @Override
    public boolean legalMove(Square from, Square to, ChessBoard board) {
        boolean possibleMove = !super.pieceBetweenSameColumnOrRow(from, to, board);
        boolean rookMove = from.getRow() == to.getRow() || from.getColumn() == to.getColumn();

        return possibleMove && rookMove;
    }

}
