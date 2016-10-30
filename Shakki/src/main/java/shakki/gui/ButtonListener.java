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
import shakki.game.Square;

/**
 *
 * @author Laura
 */
public class ButtonListener implements ActionListener{
    private Chess chess;
    private Square square;
    private UserInterface ui;
    
    public ButtonListener(Square square, Chess chess, UserInterface ui) {
        this.square = square;
        this.chess = chess;
        this.ui = ui;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(chess.checkmate()) {
            return;
        }
        if(ui.getFirstSquareClicked() == null) {
            ui.setFirstSquareClicked(square);
        } else {
            chess.move(ui.getFirstSquareClicked(), square);
            ui.setFirstSquareClicked(null);
            ui.repaintBoard();
        }
        
    }
    
}
