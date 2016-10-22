/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.game;

import javax.swing.SwingUtilities;
import shakki.gui.UserInterface;



/**
 *
 * @author Laura
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Chess chess = new Chess();
        
        UserInterface userInterface = new UserInterface(chess);
        SwingUtilities.invokeLater(userInterface);
        
        //chess.play();
    }

}
