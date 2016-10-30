/**
 * Class provides the game logic.
 */
package shakki.game;

import shakki.piece.King;
import shakki.piece.Pawn;
import shakki.piece.Piece;
import shakki.piece.Queen;
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

    }

    /**
     * If possible, moves the piece and changes the turn. Also checks some game
     * situations.
     *
     * @param from The initial position
     * @param to The destination
     */
    public void move(Square from, Square to) {
        if (!squareOnBoard(from) || !squareOnBoard(to) || from.equals(to) || (board.getPiece(from) == null)) { //Piece has to move on board
            return;
        }
        Piece moving = board.getPiece(from);
        Piece captured = board.getPiece(to);

        if (moving.legalMove(from, to, board) && player.movingOwnPiece(moving)) {
            System.out.println("legal move");
            if (captured != null) {
                if (moving.getColor() == captured.getColor()) {
                    System.out.println("Cannot capture own piece");
                    return;
                }
                if (captured.getClass() == King.class) {
                    this.continues = false;
                    if (this.player.whiteTurn()) {
                        this.message = "Game over. White player won";
                    } else {
                        this.message = "Game over. Black player won";
                    }
                    return;
                }
                System.out.println("Captured a piece");
            }

            if (moving.getClass() == Pawn.class && to.getRow() == 7) {
                moving = new Queen(moving.getColor());
            }

            board.setPiece(moving, to);
            board.setPiece(null, from);
            player.changeTurn();
            if (this.player.whiteTurn()) {
                this.message = "White player's turn";
            } else {
                this.message = "Black player's turn";
            }
        }
    }

    /**
     * Checks if the square is on the board.
     *
     * @param square The square checked
     * @return true if the square is on the board and false if it is out of the
     * board
     */
    public boolean squareOnBoard(Square square) {
        boolean outOfBoard = (square.getColumn() < 0) || (8 <= square.getColumn()) || (square.getRow() < 0) || (8 <= square.getRow());
        return !outOfBoard;
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

    public Player getPlayer() {
        return this.player;
    }
}
