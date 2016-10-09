/**
 * Abstract class provides methods for all the pieces.
 */
package shakki.piece;

import shakki.game.ChessBoard;
import shakki.game.Square;

public abstract class Piece {

    private final Color color;

    public Piece(Color color) {
        this.color = color;
    }

    /**
     * Checks if the move tried is possible for the piece.
     *
     * @param from Square where the piece initially is
     * @param to Square to which the piece is tried to move
     * @param board Current chess board
     *
     * @return possibility to move the piece
     */
    public boolean legalMove(Square from, Square to, ChessBoard board) {
        boolean moving = from.equals(to); //Piece has to move
        boolean emptySquare = board.getPiece(from) == null; // Nothing to move in the square
        boolean outOfBoard = (to.getColumn() < 0) || (8 <= to.getColumn()) || (to.getRow() < 0) || (8 <= to.getRow()); //cannot move out of board

        return !(moving || emptySquare || outOfBoard);
    }

    public Color getColor() {
        return this.color;

    }

    /**
     * Method checks if there is a piece on the same row or column between the
     * piece and the square to which the piece is tried to move.
     *
     * @param from Square where the piece initially is
     * @param to Square to which the piece is tried to move
     * @param board Current chess board
     *
     * @return True if there is a piece between and false otherwise
     */

    public boolean pieceBetweenSameColumnOrRow(Square from, Square to, ChessBoard board) {
        if (from.getColumn() == to.getColumn()) {
            if (from.getRow() < to.getRow()) {
                pieceBetweenColumnHelper(from.getRow(), to.getRow(), from.getColumn(), board);
            } else {
                pieceBetweenColumnHelper(to.getRow(), from.getRow(), from.getColumn(), board);
            }
        } else if (from.getRow() == to.getRow()) {
            if (from.getColumn() < to.getColumn()) {
                pieceBetweenRowHelper(from.getColumn(), to.getColumn(), to.getRow(), board);
            } else {
                pieceBetweenRowHelper(to.getColumn(), from.getColumn(), to.getRow(), board);
            }
        }

        return false;
    }
    
    public boolean pieceBetweenColumnHelper(int from, int to, int col, ChessBoard board) {
        for (int i = from; i < to; i++) {
            if (board.getPiece(new Square(i, col)) != null) {
                return true;
            }
        }
        return false;
    }
    
    public boolean pieceBetweenRowHelper(int from, int to, int row, ChessBoard board) {
        for (int i = from; i < to; i++) {
            if (board.getPiece(new Square(row, i)) != null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method checks if there is a piece diagonally between the piece and the
     * square to which the piece is tried to move.
     *
     * @param from Square where the piece initially is
     * @param to Square to which the piece is tried to move
     * @param board Current chess board
     *
     * @return True if there is a piece between and false otherwise
     */
    public boolean pieceBetweenDiagonally(Square from, Square to, ChessBoard board) {
        if (Math.abs(from.getRow() - to.getRow()) == Math.abs(from.getColumn() - to.getColumn())) {

        }
        return false;
    }

}
