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

/**
 *
 * @author Laura
 */
public class MouseListener implements ActionListener {
    private JLabel from;
    private JLabel to;
    
    public MouseListener(JLabel from, JLabel to) {
        this.from = from;
        this.to = to;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.to.setText(this.from.getText());
        this.from.setText("");
    }
    
}
