/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.game;

import shakki.player.Black;
import shakki.player.Player;
import shakki.player.White;

/**
 *
 * @author Laura
 */
public class Chess {
    private boolean continues;
    private Player white;
    private Player black;
    
    public Chess () {
        this.continues = true;
        this.white = new White();
        this.black = new Black();
    }
}
