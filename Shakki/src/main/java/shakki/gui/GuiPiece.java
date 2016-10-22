/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import shakki.game.Chess;
import shakki.game.Square;

/**
 *
 * @author Laura
 */
public class GuiPiece {
    private final int x;
    private final int y;
    private JLabel label;
    
    public GuiPiece(int x, int y, String label) {
        this.x = x;
        this.y = y;
        this.label = new JLabel(label);
    }
    
    public void move(GuiPiece movedGuiPiece) {
        this.label = new JLabel(movedGuiPiece.label.getText());
        movedGuiPiece.label = new JLabel("");
    }
    public Square convertCoordinatesToSquare() {
        return new Square(Math.abs(7 - this.x), Math.abs(7 - this.y));
    }
    public int convertXToColumn(Square square) {
        return Math.abs(7 - square.getColumn());
    }
    public int convertYToRow(Square square) {
        return Math.abs(7 - square.getRow());
    }
}
