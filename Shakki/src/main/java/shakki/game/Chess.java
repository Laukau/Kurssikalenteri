/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.game;


import shakki.piece.King;
import shakki.piece.Pawn;
import shakki.piece.Piece;
import shakki.player.HumanPlayer;
import shakki.player.Player;


/**
 *
 * @author Laura
 */
public class Chess {

    private boolean continues;
    private ChessBoard board;
    private HumanPlayer player;

    public Chess() {
        this.continues = true;
        this.board = new ChessBoard();
        this.player = new HumanPlayer();

    }

    public void play() {
        
    }
    
    //Moves piece if possible
    public void move(Position from, Position to) {
        Piece moving = board.getPiece(from);
        Piece captured = board.getPiece(to);
        
        if(moving.legalMove(from, to, board) && (moving.getColor() != captured.getColor()) && player.movingOwnPiece(moving)) {
            if(captured.getClass() == King.class) {
                this.continues = false;
            }
            if(captured.getClass() == Pawn.class) {
                
            }
            board.setPiece(moving, to);
            board.setPiece(null, from);
            player.changeTurn();
        }
    }
    
    //Returns true if the game is over and false if the game continues
    public boolean checkmate() {
        return !this.continues;
    }
}
