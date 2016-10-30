/**
 * Abstract class provides methods for all the pieces.
 */
package shakki.piece;

import shakki.game.ChessBoard;
import shakki.game.Square;

public abstract class Piece {

    private final Color color;

    /**
     * Constructor sets the color.
     *
     * @param color The color of the piece
     */
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
        return true;
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
     * @return true if there is a piece between and false otherwise
     */
    public boolean pieceBetweenSameColumnOrRow(Square from, Square to, ChessBoard board) {
        if (from.getColumn() == to.getColumn()) {
            if (from.getRow() < to.getRow()) {
                return pieceBetweenColumnHelper(from.getRow(), to.getRow(), from.getColumn(), board);
            } else {
                return pieceBetweenColumnHelper(to.getRow(), from.getRow(), from.getColumn(), board);
            }
        } else if (from.getRow() == to.getRow()) {
            if (from.getColumn() < to.getColumn()) {
                return pieceBetweenRowHelper(from.getColumn(), to.getColumn(), to.getRow(), board);
            } else {
                return pieceBetweenRowHelper(to.getColumn(), from.getColumn(), to.getRow(), board);
            }
        }

        return false;
    }

    private boolean pieceBetweenColumnHelper(int from, int to, int col, ChessBoard board) {
        for (int i = from + 1; i < to; i++) {
            if (board.getPiece(new Square(col, i)) != null) {
                return true;
            }
        }
        return false;
    }

    private boolean pieceBetweenRowHelper(int from, int to, int row, ChessBoard board) {
        for (int i = from + 1; i < to; i++) {
            if (board.getPiece(new Square(i, row)) != null) {
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
     * @return true if there is a piece between and false otherwise
     */
    public boolean pieceBetweenDiagonally(Square from, Square to, ChessBoard board) {
        if (Math.abs(from.getRow() - to.getRow()) == Math.abs(from.getColumn() - to.getColumn())) {
            return pieceBetweenDiagonallyHelper(from.getColumn(), to.getColumn(), from.getRow(), to.getRow(), board);
        }
        return false;
    }

    private boolean pieceBetweenDiagonallyHelper(int fromX, int toX, int fromY, int toY, ChessBoard board) {
        int x = 1;
        int y = 1;
        if (fromX > toX) {
            x = -1;
        }
        if (fromY > toY) {
            y = -1;
        }
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        int i = Math.abs(toX - fromX);
        for (int j = 1; j < i; j++) {
            System.out.println("xcoord: " + (fromX + (x * j)));
            System.out.println("ycoord: " + (fromY + (y * j)));
            if (board.getPiece(new Square((fromX + (x * j)), (fromY + (y * j)))) != null) {
                return true;
            }
        }
        return false;
    }
}
