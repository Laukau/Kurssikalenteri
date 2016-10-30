/**
 * Class provides the pawns and their moving logic.
 */
package shakki.piece;

import shakki.game.ChessBoard;
import shakki.game.Square;
import static shakki.piece.Color.BLACK;

public class Pawn extends Piece {

    private boolean firstMove;
    private final int direction;
    private Color color;

    /**
     * Constructor sets the color and direction of the Pawn.
     *
     * @param color Color of the pawn
     */
    public Pawn(Color color) {
        super(color);
        this.color = color;
        this.firstMove = true;

        if (color == BLACK) {
            this.direction = -1;
        } else {
            this.direction = 1;
        }
    }

    @Override
    public boolean legalMove(Square from, Square to, ChessBoard board) {
        if (board.getPiece(to) != null) { //Pawn can move to empty square only
            return false;
        }

        if (from.getRow() + direction == to.getRow() && legalNormalMove(from, to, board)) {
            firstMove = false;
            return true;
        } else if (firstMove && (from.getRow() + (2 * direction) == to.getRow() && from.getColumn() == to.getColumn())) { //Can move two squares forward with first move
            if (board.getPiece(new Square(from.getColumn(), from.getRow() + direction)) == null) { //The next square has to be empty
                firstMove = false;
                return true;
            }
        }
        return false;
    }

    private boolean legalNormalMove(Square from, Square to, ChessBoard board) {
        Square oppositeSquare = new Square(from.getColumn(), from.getRow() + direction);
        Piece oppositePiece = board.getPiece(oppositeSquare);

        if (oppositePiece != null && (from.getColumn() - 1 == to.getColumn() || from.getColumn() + 1 == to.getColumn()) && (oppositePiece.getColor() != this.color)) {
            board.setPiece(null, oppositeSquare);
            return true;
        } else {
            return from.getColumn() == to.getColumn();
        }
    }
}
