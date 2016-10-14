/*
 * Provides the chessboeard.
 */
package shakki.game;

import shakki.piece.Piece;
import shakki.piece.Rook;
import shakki.piece.Knight;
import shakki.piece.Bishop;
import static shakki.piece.Color.BLACK;
import static shakki.piece.Color.WHITE;
import shakki.piece.King;
import shakki.piece.Pawn;
import shakki.piece.Queen;


public class ChessBoard {
    private Piece[][] board;
    
    /**
     * Constructor initializes the board.
     */
    public ChessBoard() {
        this.board = new Piece[][]{{new Rook(WHITE), new Knight(WHITE), new Bishop(WHITE), new Queen(WHITE), 
                                    new King(WHITE), new Bishop(WHITE), new Knight(WHITE), new Rook(WHITE)},
                                   {new Pawn(WHITE), new Pawn(WHITE), new Pawn(WHITE), new Pawn(WHITE), 
                                       new Pawn(WHITE), new Pawn(WHITE), new Pawn(WHITE), new Pawn(WHITE)},
                                   {null, null, null, null, null, null, null, null},
                                   {null, null, null, null, null, null, null, null},
                                   {null, null, null, null, null, null, null, null},
                                   {null, null, null, null, null, null, null, null},
                                   {new Pawn(BLACK), new Pawn(BLACK), new Pawn(BLACK), new Pawn(BLACK), 
                                       new Pawn(BLACK), new Pawn(BLACK), new Pawn(BLACK), new Pawn(BLACK)},
                                   {new Rook(BLACK), new Knight(BLACK), new Bishop(BLACK), new Queen(BLACK), 
                                       new King(BLACK), new Bishop(BLACK), new Knight(BLACK), new Rook(BLACK)}};
    }
    
    /**
     * Gets a piece from a square.
     * @param square The square that is checked
     * @return piece if there is one, otherwise null
     */
    public Piece getPiece(Square square) {
        return board[square.getRow()][square.getColumn()];
    }
    
    /**
     * Sets the piece in the square.
     * @param piece The piece moved
     * @param square The square to which the piece is moved
     */
    public void setPiece(Piece piece, Square square) {
        board[square.getRow()][square.getColumn()] = piece;
    }
}
