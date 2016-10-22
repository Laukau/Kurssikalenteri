/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import shakki.game.Chess;

/**
 *
 * @author Laura
 */
public class ButtonListener implements ActionListener{
    private Chess chess;
    private GuiPiece piece;
    private JPanel board;
    
    public ButtonListener(GuiPiece piece, Chess chess, JPanel board) {
        this.piece = piece;
        this.chess = chess;
        this.board = board;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(chess.checkmate()) {
            return;
        }
        this.piece.setButton((JButton) ae.getSource());
        if(chess.firstSquareClicked()) {
            chess.setFromGuiPiece(this.piece);
            chess.setFirstSquareClicked(false);
            System.out.println("Eka GuiPiece lisätty");
        } else {
            chess.setToGuiPiece(this.piece);
            chess.setFirstSquareClicked(true);
            System.out.println("Toka GuiPiece lisätty");
            chess.move(chess.getFromGuiPiece().convertCoordinatesToSquare(), chess.getToGuiPiece().convertCoordinatesToSquare());
            
            
        }
    }
    
}
