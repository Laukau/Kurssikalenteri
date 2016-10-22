/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.gui;

import java.util.Scanner;
import shakki.game.ChessBoard;
import shakki.game.Square;
import shakki.piece.Bishop;
import shakki.piece.Color;
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
public class TextUserInterface {
    private Scanner scanner;

    public TextUserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public void drawBoard(ChessBoard board) {
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                Piece p = board.getPiece(new Square(j, i));
                writePiece(p);
            }
            System.out.println("");
        }
    }

    public void writePiece(Piece p) {
        if (p == null) {
            System.out.print(" - ");
        } else if (p.getColor() == Color.WHITE) {
            if (p.getClass() == King.class) {
                System.out.print(" K ");
            }
            if (p.getClass() == Queen.class) {
                System.out.print(" Q ");
            }
            if (p.getClass() == Pawn.class) {
                System.out.print(" P ");
            }
            if (p.getClass() == Bishop.class) {
                System.out.print(" B ");
            }
            if (p.getClass() == Rook.class) {
                System.out.print(" R ");
            }
            if (p.getClass() == Knight.class) {
                System.out.print("Kn ");
            }
        } else {
            if (p.getClass() == King.class) {
                System.out.print(" k ");
            }
            if (p.getClass() == Queen.class) {
                System.out.print(" q ");
            }
            if (p.getClass() == Pawn.class) {
                System.out.print(" p ");
            }
            if (p.getClass() == Bishop.class) {
                System.out.print(" b ");
            }
            if (p.getClass() == Rook.class) {
                System.out.print(" r ");
            }
            if (p.getClass() == Knight.class) {
                System.out.print("kn ");
            }

        }
    }

    public Square readfromSquare() {
        System.out.println("Write the column number of the piece that you want to move");
        int x = Integer.parseInt(rowAndColumnNumbersBetween07());
        System.out.println("Write the row number of the piece that you want to move");
        int y = Integer.parseInt(rowAndColumnNumbersBetween07());
        return new Square(x, y);
    }
    
    public Square readToSquare() {
        System.out.println("Write the column number of the square where you want to move the piece");
        int x = Integer.parseInt(rowAndColumnNumbersBetween07());
        System.out.println("Write the row number of the square where you want to move the piece");
        int y = Integer.parseInt(rowAndColumnNumbersBetween07());
        return new Square(x, y);
    }
    
    public String rowAndColumnNumbersBetween07() {
        String input = scanner.nextLine(); 
        while(!input.matches("[0-7]{1}")) {
            System.out.println("Write one number between 0 and 7");
            input = scanner.nextLine();
        }
        return input;
    }
    public Piece promotePawn(Color color) {
        System.out.println("To what piece do you want to promote the pawn? Write q (queen), r (rook), b (bishop) or k (knight)");
        String input = scanner.nextLine();
        while(!input.matches("q|r|b|k")) {
            System.out.println("Write q (queen), r (rook), b (bishop) or k (knight)");
            input = scanner.nextLine();
        }
        Piece promotedPiece = null;
        switch (input) {
            case "q":
                promotedPiece = new Queen(color);
                break;
            case "r":
                promotedPiece = new Rook(color);
                break;
            case "b":
                promotedPiece = new Bishop(color);
                break;
            case "k":
                promotedPiece = new Knight(color);
                break;
        }
        return promotedPiece;
    }
}
