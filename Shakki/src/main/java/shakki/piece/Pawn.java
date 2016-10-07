/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.piece;

import shakki.game.ChessBoard;
import shakki.game.Position;
import static shakki.piece.Color.BLACK;

/**
 *
 * @author Laura
 */
public class Pawn extends Piece {
    private boolean firstMove;
    private int direction;
    
    public Pawn(Color color) {
        super(color);
        this.firstMove = true;
        
        if(color == BLACK){
            this.direction = -1;
        } else {
            this.direction = 1;
        }
    }

    @Override
    public boolean legalMove(Position from, Position to, ChessBoard board) {
        if(!super.legalMove(from, to, board) || board.getPiece(to) != null) { //Pawn can move to empty square only
            return false;
        }
        
        if(from.getRow() + direction == to.getRow() && legalNormalMove(from, to, board)) {
            firstMove = false;
            return true;
        } else if(firstMove && (from.getRow()+ 2*direction == to.getRow() && from.getColumn() == to.getColumn())) { //Can move two squares forward with first move
            firstMove = false;
            return true;
        } else {
            return false;
        }
        
    }
    
    public boolean legalNormalMove(Position from, Position to, ChessBoard board) {
        Position oppositePos = new Position(from.getColumn(), from.getRow() + direction);
        Piece oppositePiece = board.getPiece(oppositePos);
        
        if(oppositePiece != null && (from.getColumn() - 1 == to.getColumn() || from.getColumn() + 1 == to.getColumn())) {
            board.setPiece(null, oppositePos);
            return true;
        } else {
            return from.getColumn() == to.getColumn();
        }
    }
}
