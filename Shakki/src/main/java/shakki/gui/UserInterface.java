/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import shakki.game.Chess;

/**
 *
 * @author Laura
 */
public class UserInterface implements Runnable {
    private JFrame frame;
    private Chess chess;
    private JLabel message;
    private JPanel board;
    private JButton squares[][];
    private JToolBar tools;
    
    public UserInterface(Chess chess) {
        this.chess = chess;
        this.message = new JLabel("White player starts");
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
        tools.add(newGame);
        tools.addSeparator();
        tools.add(message);
        
        return tools;
    }
    
    private JPanel createBoard() {
        this.board = new JPanel(new GridLayout(0,9));
        createSquares();
        
        // add the row numbers and the squares
        for(int i = 0; i < 8; i++) {
            board.add(new JLabel("" + (i + 1)));
            for (int j = 0; j < 8; j++) {
                board.add(squares[i][j]);
            }
        }
        // add the column letters
        board.add(new JLabel(""));
        String[] columns = new String[] {"A", "B", "C", "D", "E", "F", "G", "H"};
        for(int i = 0; i < 8; i++) {
            board.add(new JLabel(columns[i]));
        }
        return board;
    }
    
    private void createSquares() {
        this.squares = new JButton[8][8];
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JButton button = new JButton();
                // every other square is white and every other one is black
                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) {
                    button.setBackground(Color.WHITE);
                } else {
                    button.setBackground(Color.BLACK);
                }
                squares[i][j] = button;
            }
        }
        String[] whitePieces = new String[] {"\u2656", "\u2658", "\u2657", "\u2655", "\u2654", "\u2657", "\u2658", "\u2656", "\u2659"};
        String[] blackPieces = new String[] {"\u265C", "\u265E", "\u265D", "\u265B", "\u265A", "\u265D", "\u265E", "\u265C", "\u265F"};
        for (int i = 0; i < 8; i++) {
            addPiece(blackPieces[i], squares[0][i], Color.DARK_GRAY);
            addPiece(blackPieces[8], squares[1][i], Color.DARK_GRAY);
            addPiece(whitePieces[8], squares[6][i], Color.GRAY);
            addPiece(whitePieces[i], squares[7][i], Color.GRAY);
            for (int j = 2; j < 6; j++) {
                squares[j][i].add(new JLabel(""));
            }
            for (int j = 0; j < 8; j++) {
                squares[j][i].addActionListener(new ButtonListener(new GuiPiece(j, i, squares[j][i].getText()), this.chess, this.board));
            }
        }
    }

    public void addPiece(String s, Container c, Color color) {
        JLabel label = new JLabel(s);
        label.setFont(new Font("Sans-Serif", Font.PLAIN, 30));
        label.setForeground(color);
        if(c.getBackground() == Color.BLACK) {
            label.setBackground(Color.BLACK);
        } else {
            label.setBackground(Color.WHITE);
        }
        c.add(label);
    }
    public JFrame getFrame() {
        return frame;
    }
    public void setMessage(String newMessage) {
        this.message = new JLabel(newMessage);
    }
    public void setPiece(GuiPiece fromPiece, GuiPiece toPiece) {
        this.squares[fromPiece.getY()][fromPiece.getX()].add(new Label(""));
        this.squares[toPiece.getY()][toPiece.getX()].add(fromPiece.getLabel());
        System.out.println("GuiPiece set");
    }
    public void repaintBoard() {
        //JPanel newBoard = new JPanel(new GridLayout(0,9));
        for(int i = 0; i < 8; i++) {
            this.board.add(new JLabel("" + (i + 1)));
            for (int j = 0; j < 8; j++) {
                this.board.add(this.squares[i][j]);
            }
        }
        // add the column letters
        this.board.add(new JLabel(""));
        String[] columns = new String[] {"A", "B", "C", "D", "E", "F", "G", "H"};
        for(int i = 0; i < 8; i++) {
            this.board.add(new JLabel(columns[i]));
        }
        
        System.out.println("repaint");
        //this.board = newBoard;
        this.frame.getContentPane().add(this.board);
        //this.board.repaint();
        
        //this.tools = createToolBar();
        //this.tools.repaint();
        this.frame.getContentPane().validate();
        this.frame.getContentPane().repaint();
    }    
}
