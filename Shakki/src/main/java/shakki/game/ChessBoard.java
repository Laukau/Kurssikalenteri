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


public class ChessBoard {
    private Piece[][] board;
    
    
    public ChessBoard() {
        this.board = {{new Rook(WHITE), new Knight(WHITE), new Bishop(WHITE), new Queen(WHITE), 
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
    
    public Piece getPiece(Square pos) {
        return board[pos.getRow()][pos.getColumn()];
    }
    
    public void setPiece(Piece piece, Square pos) {
        board[pos.getRow()][pos.getColumn()] = piece;
    }
}
