/**
 * Class provides the queens and their moving logic.
 */
package shakki.piece;

import shakki.game.ChessBoard;
import shakki.game.Square;

public class Queen extends Piece {
    
    /**
     * Constructor sets the color.
     * @param color Color of the queen
     */
    public Queen(Color color) {
        super(color);
    }

    @Override
    public boolean legalMove(Square from, Square to, ChessBoard board) {
        boolean possibleMove = super.legalMove(from, to, board) && !super.pieceBetweenSameColumnOrRow(from, to, board) && !super.pieceBetweenDiagonally(from, to, board);
        boolean queenMove = from.getRow() == to.getRow() || from.getColumn() == to.getColumn() || Math.abs(from.getRow() - to.getRow()) == Math.abs(from.getColumn() - to.getColumn());

        return possibleMove && queenMove;
    }

}
