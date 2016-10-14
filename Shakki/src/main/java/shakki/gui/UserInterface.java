/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import shakki.game.Chess;

/**
 *
 * @author Laura
 */
public class UserInterface implements Runnable {
    private JFrame frame;
    private Chess chess;
    
    public UserInterface(Chess chess) {
        this.chess = chess;
    }
    @Override
    public void run() {
        frame = new JFrame("Chess");
        frame.setPreferredSize(new Dimension(200, 100));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        Painter painter = new Painter(this.chess);
        container.add(painter);
    }

    public JFrame getFrame() {
        return frame;
    }
    
    
}
