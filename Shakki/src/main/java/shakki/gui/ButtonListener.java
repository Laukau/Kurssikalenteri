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
public class ButtonListener implements ActionListener {

    private Chess chess;
    private UserInterface ui;

    public ButtonListener(Chess chess, UserInterface ui) {
        this.chess = chess;
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (chess.checkmate()) {
            return;
        }
        SquareButton button = (SquareButton) ae.getSource();
        if (ui.getFirstSquareClicked() == null) {
            ui.setFirstSquareClicked(button);
        } else {
            chess.move(ui.getFirstSquareClicked().convertCoordinatesToSquare(), button.convertCoordinatesToSquare());
            ui.setFirstSquareClicked(null);
            ui.repaintBoard();
        }
    }
}
