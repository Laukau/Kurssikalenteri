/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.game;

import shakki.player.HumanPlayer;
import shakki.player.Player;

/**
 *
 * @author Laura
 */
public class Chess {
    private boolean continues;
    private Player black;
    
    public Chess () {
        this.continues = true;
        this.black = new HumanPlayer();
    }
}
