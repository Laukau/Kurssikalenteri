/**
 * Class provides the game logic.
 */
package shakki.game;

import java.util.Scanner;
import javax.swing.SwingUtilities;
import shakki.gui.SquareButton;
import shakki.gui.TextUserInterface;
import shakki.gui.UserInterface;
import shakki.piece.Bishop;
import shakki.piece.Color;
import shakki.piece.King;
import shakki.piece.Knight;
import shakki.piece.Pawn;
import shakki.piece.Piece;
import shakki.piece.Queen;
import shakki.piece.Rook;
import shakki.player.HumanPlayer;
import shakki.player.Player;

public class Chess {

    private boolean continues;
    private ChessBoard board;
    private Player player;
    private boolean check;
    private boolean enPassantPossible;
    private boolean castlingPossible;
    private String message;
    //private TextUserInterface ui;

    /**
     * Constructor sets the board, the players and the initial values of some
     * game situations.
     */
    public Chess() {
        this.continues = true;
        this.board = new ChessBoard();
        this.player = new HumanPlayer();
        this.enPassantPossible = false;
        this.castlingPossible = false;
        this.check = false;
        this.message = "White player starts";
        //this.ui = new TextUserInterface();

    }

    /**
     * If possible, moves the piece and changes the turn. Also checks some game
     * situations.
     *
     * @param from The initial position
     * @param to The destination
     */
    public void move(Square from, Square to) {
        Piece moving = board.getPiece(from);
        Piece captured = board.getPiece(to);
        if (moving == null) {
            System.out.println("Cannot move empty square");
            this.message = "Tried to move empty square";
            return;
        }
        System.out.println("Moving");
        if (moving.legalMove(from, to, board) && player.movingOwnPiece(moving)) {
            System.out.println("legal move");
            if (captured != null) {
                if (moving.getColor() == captured.getColor()) {
                    System.out.println("Cannot capture own piece");
                    return;
                }
                if (captured.getClass() == King.class) {
                    this.continues = false;
                    if(this.player.whiteTurn()) {
                     this.message = "Game over. White player won";
                     } else {
                     this.message = "Game over. Black player won";
                     }
                    return;
                }
                System.out.println("Captured a piece");
            }
            
            /*if (moving.getClass() == Pawn.class && to.getRow() == 7) {
                moving = ui.promotePawn(moving.getColor());
            }
            */
            board.setPiece(moving, to);
            board.setPiece(null, from);
            System.out.println("piece set on logic board");
            player.changeTurn();
            if(this.player.whiteTurn()) {
                this.message = "White player's turn";
                System.out.println("White player's turn");
             } else {
                this.message = "Black player's turn";
                System.out.println("Black player's turn");
             }
            
        }
        
    }

    /**
     * Checks if it is check.
     *
     * @return true if the king is in check and false otherwise
     */
    public boolean check() {
        return this.check;
    }

    /**
     * Method checks if it is checkmate.
     *
     * @return true if the game is over and false if the game continues
     */
    public boolean checkmate() {
        return !this.continues;
    }
    
    public String getMessage() {
        return this.message;
    }
    public ChessBoard getBoard() {
        return this.board;
    }
}
