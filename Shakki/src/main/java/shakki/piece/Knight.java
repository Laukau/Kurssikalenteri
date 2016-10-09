/**
 * Class provides the knights and their moving logic.
 */
package shakki.piece;

import shakki.game.ChessBoard;
import shakki.game.Square;


public class Knight extends Piece {

    public Knight(Color color) {
        super(color);
    }

    @Override
    public boolean legalMove(Square from, Square to, ChessBoard board) {
        int rowStep = Math.abs(from.getRow()-to.getRow());
        int columnStep = Math.abs(from.getColumn()-to.getColumn());
        
        boolean knightMove = (rowStep == 2 && columnStep == 1) || (columnStep == 2 && rowStep == 1);
        boolean possibleMove = super.legalMove(from, to, board);
        
        return possibleMove && knightMove;
    }

}
