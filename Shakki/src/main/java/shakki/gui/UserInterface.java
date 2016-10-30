/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;
import shakki.game.Chess;
import shakki.game.Square;
import shakki.piece.Bishop;
import shakki.piece.King;
import shakki.piece.Knight;
import shakki.piece.Pawn;
import shakki.piece.Piece;
import shakki.piece.Queen;
import shakki.piece.Rook;

/**
 *
 * @author Laura
 */
public class UserInterface implements Runnable {

    private JFrame frame;
    private Chess chess;
    private JLabel message;
    private JPanel board;
    private SquareButton squares[][];
    private JToolBar tools;
    private SquareButton firstSquareClicked;

    public UserInterface(Chess chess) {
        this.chess = chess;
        this.message = new JLabel(chess.getMessage());
    }

    @Override
    public void run() {
        frame = new JFrame("Chess");
        frame.setPreferredSize(new Dimension(600, 600));
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        container.setLayout(new BorderLayout());
        container.add(createToolBar(), BorderLayout.NORTH);
        container.add(createBoard(), BorderLayout.CENTER);
    }

    private JToolBar createToolBar() {
        this.tools = new JToolBar();
        JButton newGame = new JButton("New");
        newGame.addActionListener((ActionEvent ae) -> {
            chess = new Chess();
            repaintBoard();
        });
        tools.add(newGame);
        tools.addSeparator();
        tools.add(message);

        return tools;
    }

    private JPanel createBoard() {
        this.board = new JPanel(new GridLayout(0, 9));
        this.squares = new SquareButton[8][8];
        createSquares();
        // add the row numbers and the squares created
        for (int i = 0; i < 8; i++) {
            board.add(new JLabel("" + (i + 1)));
            for (int j = 0; j < 8; j++) {
                board.add(squares[i][j]);
            }
        }
        board.add(new JLabel(""));
        // add the column letters
        String[] columns = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};
        for (int i = 0; i < 8; i++) {
            board.add(new JLabel(columns[i]));
        }
        return this.board;
    }

    private void createSquares() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                SquareButton button = new SquareButton(i, j);
                // Sets the background color: every other square is white and every other one is black
                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) {
                    button.setBackground(Color.WHITE);
                } else {
                    button.setBackground(Color.BLACK);
                }
                setPieceToSquare(this.chess.getBoard().getPiece(button.convertCoordinatesToSquare()), button);
                button.addActionListener(new ButtonListener(this.chess, this));
                squares[i][j] = button;
            }
        }
    }

    public void setPieceToSquare(Piece p, SquareButton square) {
        String s = "";
        if (p == null) {
            setPieceLabel(s, square, Color.WHITE);
        } else if (p.getColor() == shakki.piece.Color.WHITE) {
            if (p.getClass() == King.class) {
                s = "\u2654";
            }
            if (p.getClass() == Queen.class) {
                s = "\u2655";
            }
            if (p.getClass() == Pawn.class) {
                s = "\u2659";
            }
            if (p.getClass() == Bishop.class) {
                s = "\u2657";
            }
            if (p.getClass() == Rook.class) {
                s = "\u2656";
            }
            if (p.getClass() == Knight.class) {
                s = "\u2658";
            }
            setPieceLabel(s, square, Color.GRAY);
        } else {
            if (p.getClass() == King.class) {
                s = "\u265A";
            }
            if (p.getClass() == Queen.class) {
                s = "\u265B";
            }
            if (p.getClass() == Pawn.class) {
                s = "\u265F";
            }
            if (p.getClass() == Bishop.class) {
                s = "\u265D";
            }
            if (p.getClass() == Rook.class) {
                s = "\u265C";
            }
            if (p.getClass() == Knight.class) {
                s = "\u265E";
            }
            setPieceLabel(s, square, Color.DARK_GRAY);
        }
    }

    //Sets the font and color of the unicode char
    private void setPieceLabel(String s, SquareButton b, Color color) {
        b.setFont(new Font("Sans-Serif", Font.PLAIN, 30));
        b.setForeground(color);
        if (b.getBackground() == Color.BLACK) {
            b.setBackground(Color.BLACK);
        } else {
            b.setBackground(Color.WHITE);
        }
        b.setText(s);
    }

    public void setFirstSquareClicked(SquareButton square) {
        this.firstSquareClicked = square;
    }

    public SquareButton getFirstSquareClicked() {
        return this.firstSquareClicked;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void repaintBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                setPieceToSquare(chess.getBoard().getPiece(new Square(Math.abs(7 - j), Math.abs(7 - i))), squares[i][j]);
            }
        }
        this.message.setText(chess.getMessage());
        this.frame.getContentPane().validate();
        this.frame.getContentPane().repaint();
    }
}
