/**
 * Class provides the game logic.
 */
package shakki.game;


import javax.swing.SwingUtilities;
import shakki.gui.GuiPiece;
import shakki.gui.UserInterface;
import shakki.piece.King;
import shakki.piece.Pawn;
import shakki.piece.Piece;
import shakki.player.HumanPlayer;
import shakki.player.Player;



public class Chess {

    private boolean continues;
    private ChessBoard board;
    private Player player;
    private boolean firstSquare;
    private boolean check;
    private boolean enPassantPossible;
    private boolean castlingPossible;
    private GuiPiece from;
    private GuiPiece to;
    private UserInterface ui;

    /**
     * Constructor sets the board, the players and the initial values of some game situations.
     */
    public Chess() {
        this.continues = true;
        this.board = new ChessBoard();
        this.player = new HumanPlayer();
        this.enPassantPossible = false;
        this.castlingPossible = false;
        this.check = false;
        this.firstSquare = true;
        this.ui = new UserInterface(this);
    }
    
    /**
     * Controls the proceeding of the game.
     */
    public void play() {
        SwingUtilities.invokeLater(ui);
    }
    
    
    /**
     * If possible, moves the piece and changes the turn.
     * Also checks some game situations.
     * 
     * @param from The initial position
     * @param to The destination
     */
    public void move(Square from, Square to) {
        Piece moving = board.getPiece(from);
        Piece captured = board.getPiece(to);
        System.out.println("move tried");
        if(moving == null) {
            System.out.println("moving = null");
            return;
        }
        System.out.println("moving != null");
        if (moving.legalMove(from, to, board) && !player.movingOwnPiece(moving)) {
            System.out.println("moving");
            if (captured != null) {
                System.out.println("captured != null");
                if (moving.getColor() == captured.getColor()) {
                    return;
                }
                if (captured.getClass() == King.class) {
                    this.continues = false;
                     if(this.player.whiteTurn()) {
                        ui.setMessage("White player won");
                    } else {
                        ui.setMessage("Black player won");
                    }
                }
                /*
                if (moving.getClass() == Pawn.class && to.getRow() == 7) {
                    moving = promotePawn();
                }
                */
            }
            
            
            board.setPiece(moving, to);
            board.setPiece(null, from);
            System.out.println("sovellusmove");
            ui.setPiece(this.from, this.to);
            //this.to.move(this.from);
            if(this.player.whiteTurn()) {
                ui.setMessage("Black player's turn");
            } else {
                ui.setMessage("White player's turn");
            }
            player.changeTurn();
            ui.repaintBoard();
            
        }
    }
    
    /**
     * Checks if it is check.
     * @return true if the king is in check and false otherwise
     */
    public boolean check() {
        return this.check;
    }
    
    /**
     * Method checks if it is checkmate.
     * @return true if the game is over and false if the game continues
     */
    public boolean checkmate() {
        return !this.continues;
    }
    
    /*public Piece promotePawn() {
        
    }*/
    public boolean firstSquareClicked(){
        return this.firstSquare;
    }
    public void setFirstSquareClicked(boolean value) {
        this.firstSquare = value;
    }
    public void setFromGuiPiece(GuiPiece from) {
        this.from = from;
    }
    public void setToGuiPiece(GuiPiece to) {
        this.to = to;
    }
    public GuiPiece getFromGuiPiece() {
        return this.from;
    }
    public GuiPiece getToGuiPiece() {
        return this.to;
    }
}
