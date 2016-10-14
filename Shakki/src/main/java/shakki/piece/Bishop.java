/**
 * Class provides the bishops and their moving logic.
 */
package shakki.piece;

import shakki.game.ChessBoard;
import shakki.game.Square;

public class Bishop extends Piece {
    
    /**
     * Constructor sets the color.
     * @param color The color of the bishop
     */
    public Bishop(Color color) {
        super(color);
    }

    @Override
    public boolean legalMove(Square from, Square to, ChessBoard board) {
        boolean possibleMove = super.legalMove(from, to, board) && !super.pieceBetweenDiagonally(from, to, board);
        boolean bishopMove = Math.abs(from.getRow() - to.getRow()) == Math.abs(from.getColumn() - to.getColumn());

        return possibleMove && bishopMove;
    }
}
