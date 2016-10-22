/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import shakki.game.Chess;

/**
 *
 * @author Laura
 */
public class ButtonListener implements ActionListener{
    private Chess chess;
    private GuiPiece piece;
    
    public ButtonListener(GuiPiece piece, Chess chess) {
        this.piece = piece;
        this.chess = chess;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(chess.checkmate()) {
            return;
        }
        if(chess.firstSquareClicked()) {
            chess.setFromGuiPiece(this.piece);
            chess.setFirstSquareClicked(false);
        } else {
            chess.setToGuiPiece(this.piece);
            chess.setFirstSquareClicked(true);
            chess.move(chess.getFromGuiPiece().convertCoordinatesToSquare(), chess.getToGuiPiece().convertCoordinatesToSquare());
        }
    }
    
}
