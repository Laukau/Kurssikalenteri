/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import shakki.game.Chess;

/**
 *
 * @author Laura
 */
public class Painter extends JPanel{
    private Chess chess;
            
    public Painter(Chess chess) {
        super.setBackground(Color.WHITE);
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
    }
}
