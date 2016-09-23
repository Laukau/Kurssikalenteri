/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.game;

import java.util.ArrayList;
import java.util.List;
import shakki.piece.Bishop;
import static shakki.piece.Color.BLACK;
import static shakki.piece.Color.WHITE;
import shakki.piece.Piece;
import shakki.player.HumanPlayer;
import shakki.player.Player;
import shakki.piece.King;
import shakki.piece.Knight;
import shakki.piece.Pawn;
import shakki.piece.Queen;
import shakki.piece.Rook;

/**
 *
 * @author Laura
 */
public class Chess {
    private boolean continues;
    private List<Piece> pieces;
    private HumanPlayer player;
    
    public Chess () {
        this.continues = true;
        this.pieces = new ArrayList();
        this.player = new HumanPlayer();
        
    }
    
    public void play() {
        
    }
    
    public void addPieces() {
        this.pieces.add(new King(0,4,WHITE));
        this.pieces.add(new King(7,4, BLACK));
        this.pieces.add(new Queen(0,3,WHITE));
        this.pieces.add(new Queen(7,3,BLACK));
        this.pieces.add(new Bishop(0,2,WHITE));
        this.pieces.add(new Bishop(0,5,WHITE));
        this.pieces.add(new Bishop(7,5,BLACK));
        this.pieces.add(new Bishop(7,2,BLACK));
        this.pieces.add(new Knight(0,1,WHITE));
        this.pieces.add(new Knight(0,6,WHITE));
        this.pieces.add(new Knight(7,6,BLACK));
        this.pieces.add(new Knight(7,1,BLACK));
        this.pieces.add(new Rook(0,0,WHITE));
        this.pieces.add(new Rook(0,7,WHITE));
        this.pieces.add(new Rook(7,7,BLACK));
        this.pieces.add(new Rook(7,0,BLACK));
        for(int i=0; i<8; i++) {
            this.pieces.add(new Pawn(1,i,WHITE));
            this.pieces.add(new Pawn(6,i,BLACK));
        }
    }
    
    public boolean checkmate() {
        return !this.continues;
    }
}
