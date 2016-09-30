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

    //Checks if the move is legal
    public boolean legalMove(Position from, Position to, ChessBoard board) {
        boolean moving = from.equals(to); //Piece has to move
        boolean emptySquare = board.getPiece(from) == null; // Nothing to move in the square
        boolean outOfBoard = (to.getColumn() < 0) || (8 <= to.getColumn()) || (to.getRow() < 0) || (8 <= to.getRow()); //cannot move out of board
        
        return moving || emptySquare || outOfBoard;
    }

    public Color getColor() {
        return this.color;
    }


}
