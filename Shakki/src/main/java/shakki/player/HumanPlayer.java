/**
 * Class provides the human player.
 */
package shakki.player;


import static shakki.piece.Color.BLACK;
import static shakki.piece.Color.WHITE;
import shakki.piece.Piece;

public class HumanPlayer implements Player {

    private boolean whitePlayer;
    
    /**
     * Constructor sets the first turn to the white player.
     */
    public HumanPlayer() {
        this.whitePlayer = true;
    }

    @Override
    public boolean whiteTurn() {
        return this.whitePlayer;
    }

    @Override
    public void changeTurn() {
        boolean turn = this.whitePlayer;
        this.whitePlayer = !turn;
    }
    
    @Override
    public boolean movingOwnPiece(Piece piece) {
        return (whitePlayer && (piece.getColor() == WHITE)) || (!whitePlayer && (piece.getColor() == BLACK));
    }
}
