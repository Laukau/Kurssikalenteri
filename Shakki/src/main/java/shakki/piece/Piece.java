/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.piece;

import shakki.game.ChessBoard;
import shakki.game.Position;

/**
 *
 * @author Laura
 */
public abstract class Piece {

    private final Color color;

    public Piece(Color color) {
        this.color = color;
    }

    
    //Returns true if the move is legal for the piece, otherwise false
    public boolean legalMove(Position from, Position to, ChessBoard board) {
        boolean moving = from.equals(to); //Piece has to move
        boolean emptySquare = board.getPiece(from) == null; // Nothing to move in the square
        boolean outOfBoard = (to.getColumn() < 0) || (8 <= to.getColumn()) || (to.getRow() < 0) || (8 <= to.getRow()); //cannot move out of board
        
        return !(moving || emptySquare || outOfBoard);
    }

    public Color getColor() {
        return this.color;
        
    }
    //Checks if there is a piece on the same row or column between the initial position and the square to which the piece is tried to move
    //Returns true if there is a piece, otherwise false
    public boolean pieceBetweenSameColumnOrRow(Position from, Position to, ChessBoard board) {
        if(from.getColumn() == to.getColumn()) {
            if(from.getRow() < to.getRow()) {
                for(int i = from.getRow(); i < to.getRow(); i++) {
                    if(board.getPiece(new Position(i, from.getColumn())) != null) {
                        return true;
                    }
                }
            } else {
                for(int i = to.getRow(); i < from.getRow(); i++) {
                    if(board.getPiece(new Position(i, from.getColumn())) != null) {
                        return true;
                    }
                }
            }
        } else if (from.getRow() == to.getRow()) {
            if(from.getColumn() < to.getColumn()) {
                for(int i = from.getColumn(); i < to.getColumn(); i++) {
                    if(board.getPiece(new Position(from.getRow(), i)) != null) {
                        return true;
                    }
                }
            } else {
                for(int i = to.getColumn(); i < from.getColumn(); i++) {
                    if(board.getPiece(new Position(from.getRow(), i)) != null) {
                        return true;
                    }
                }
            }
        } 
        
        return false;
    }
    
    public boolean pieceBetweenDiagonally(Position from, Position to, ChessBoard board) {
        if (Math.abs(from.getRow()-to.getRow()) == Math.abs(from.getColumn()-to.getColumn())){
            
        }
        return false;
    }


}
