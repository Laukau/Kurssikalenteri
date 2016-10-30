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
public class SquareButton extends JButton {
    private final int x;
    private final int y;
    
    
    public SquareButton(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Square convertCoordinatesToSquare() {
        return new Square(Math.abs(7 - this.y), Math.abs(7-this.x));
    }
    
    @Override
    public int getX() {
        return this.x;
    }
    
    @Override
    public int getY() {
        return this.y;
    }
    
}
