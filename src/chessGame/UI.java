package chessGame;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;
import exceptions.ChessException;

import java.util.ArrayList;

/**
 * This class is responsible for the User Interface (UI) of the chess game.
 * It includes methods to print the chess board and the chess pieces.
 */
public class UI {

    public static final String red = "\033[0;31m";    // RED
    public static final String blue = "\033[0;34m";   // BLUE
    public static final String yellow_background = "\u001B[43m";
    public static final String reset = "\033[0m";

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static ChessPosition readChessPosition() throws NumberFormatException, IllegalArgumentException {
        try {
            String chessPosition = UserInput.readString();
            if(chessPosition.equals("z9")) {
                return null;
            }
            if(chessPosition.length() != 2 || !Character.isLetter(chessPosition.charAt(0))) {
                throw new IllegalArgumentException("Error: input a valid chess position (a1 - h8)");
            }
            char column = chessPosition.charAt(0);
            int row = Integer.parseInt(String.valueOf(chessPosition.charAt(1)));
            return new ChessPosition(column, row);
        } catch(NumberFormatException e) {
            throw new NumberFormatException("Error parsing string to int: the row isn't a valid number");
        } catch(ChessException e) {
            throw new IllegalArgumentException("Error: input a valid chess position (a1 - h8)");
        }
    }

    public static void printMatch(ChessMatch match, boolean[][] possibleMoves) {
        printBoard(match.getPieces(), possibleMoves);
        System.out.println();
        System.out.println("Turn: " + match.getTurn());
        System.out.println("Current Player: " + match.getCurrentPlayer());
    }

    public static void printMatch(ChessMatch match) {
        printBoard(match.getPieces());
        System.out.println();
        System.out.println("Turn: " + match.getTurn());
        System.out.println("Current Player: " + match.getCurrentPlayer());
    }

    /**
     * This method prints the chess board on the console.
     * It iterates over the 2D array of ChessPiece objects and prints each piece on its respective position.
     * The chess board is 8x8, and the rows are labeled in reverse order from 8 to 1.
     * The columns are labeled from 'a' to 'h'.
     *
     * @param pieces 2D array representing the chess board, where each element is a ChessPiece object.
     */
    public static void printBoard(ChessPiece[][] pieces) {

        for(int i = 0; i < pieces.length; i++) {
            System.out.print((8 - i) + "   ");
            for(int j = 0; j < pieces.length; j++) {
                printPiece(pieces[i][j], false);
            }
            System.out.println();
        }
        System.out.println("\n     a  b  c  d  e  f  g  h");

    }

    public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {

        for(int i = 0; i < pieces.length; i++) {
            System.out.print((8 - i) + "   ");
            for(int j = 0; j < pieces.length; j++) {
                printPiece(pieces[i][j], possibleMoves[i][j]);
            }
            System.out.println();
        }
        System.out.println("\n     a  b  c  d  e  f  g  h");

    }

    /**
     * This private method prints a single chess piece on the console.
     * If the piece is null, it prints a dash ("-") to represent an empty square.
     * Otherwise, it prints the string representation of the ChessPiece object.
     *
     * @param piece ChessPiece object to be printed.
     */
    private static void printPiece(ChessPiece piece, boolean background) {
        if(background) {
            System.out.print(yellow_background);
        }
        if(piece == null) {
            System.out.print(" -" + reset);
        }
        else {
            if(piece.getColor() == Color.BLACK) {
                System.out.print(" " + red + piece + reset);
            }
            else {
                System.out.print(" " + blue + piece + reset);
            }
        }
        System.out.print(" ");
    }

    public static void printCapturedPieces(ArrayList<ChessPiece> capturedPieces) {
        System.out.print("Black: [");
        for(ChessPiece capturedPiece : capturedPieces) {
            if(capturedPiece.getColor() == Color.BLACK) {
                System.out.print(red + " " + capturedPiece + " " + reset);
            }
        }
        System.out.println("]");
        System.out.print("White: [");
        for(ChessPiece capturedPiece : capturedPieces) {
            if(capturedPiece.getColor() == Color.WHITE) {
                System.out.print(blue + " " + capturedPiece + " " + reset);
            }
        }
        System.out.println("]");
    }

}
