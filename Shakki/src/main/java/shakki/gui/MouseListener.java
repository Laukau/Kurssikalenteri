/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import shakki.game.Chess;

/**
 *
 * @author Laura
 */
public class MouseListener implements ActionListener {
    private Chess chess;
    private Component component;
    
    public MouseListener(Chess chess, Component component) {
        this.chess = chess;
        this.component = component;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
