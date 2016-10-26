/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
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
    private JButton squareButton;
    
    
    public GuiPiece(int x, int y, String label) {
        this.x = x;
        this.y = y;
        this.label = new JLabel(label);
        this.squareButton = new JButton();
    }
    
    public Square convertCoordinatesToSquare() {
        return new Square(Math.abs(7 - this.y), Math.abs(7 - this.x));
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public void setButton(JButton button) {
        this.squareButton = button;
    }
    public void setLabel(JLabel label) {
        this.label = label;
        this.squareButton.add(label);
    }
    public JLabel getLabel() {
        return this.label;
    }
}
