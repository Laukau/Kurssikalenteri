/**
 * Class provides the actual game logic.
 */
package shakki.game;


import shakki.piece.King;
import shakki.piece.Pawn;
import shakki.piece.Piece;
import shakki.player.HumanPlayer;
import shakki.player.Player;



public class Chess {

    private boolean continues;
    private ChessBoard board;
    private HumanPlayer player;

    public Chess() {
        this.continues = true;
        this.board = new ChessBoard();
        this.player = new HumanPlayer();

    }

    public void play() {
        
    }
    
    /**
     * If possible, moves the piece and changes the turn.
     * Also checks some game situations.
     * @param from The initial position
     * @param to The destination
     */
    public void move(Square from, Square to) {
        Piece moving = board.getPiece(from);
        Piece captured = board.getPiece(to);
        
        if (moving.legalMove(from, to, board) && (moving.getColor() != captured.getColor()) && player.movingOwnPiece(moving)) {
            if (captured.getClass() == King.class) {
                this.continues = false;
            }
            
            board.setPiece(moving, to);
            board.setPiece(null, from);
            player.changeTurn();
        }
    }
    
    /**
     * Method checks if it is checkmate.
     * 
     * @return true if the game is over and false if the game continues
     */
    public boolean checkmate() {
        return !this.continues;
    }
}
