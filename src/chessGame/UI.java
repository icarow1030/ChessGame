package chessGame;

import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;
import exceptions.ChessException;

/**
 * This class is responsible for the User Interface (UI) of the chess game.
 * It includes methods to print the chess board and the chess pieces.
 */
public class UI {

    public static final String red = "\033[0;31m";    // RED
    public static final String blue = "\033[0;34m";   // BLUE
    public static final String reset = "\033[0m";

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static ChessPosition readChessPosition() throws NumberFormatException, IllegalArgumentException {
        try {
            String chessPosition = UserInput.readString();
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
                printPiece(pieces[i][j], i + j);
            }
            System.out.println();
        }
        System.out.println("\n     a  b  c  d  e  f  g  h");

    }// This is a board

    /**
     * This private method prints a single chess piece on the console.
     * If the piece is null, it prints a dash ("-") to represent an empty square.
     * Otherwise, it prints the string representation of the ChessPiece object.
     *
     * @param piece ChessPiece object to be printed.
     */
    private static void printPiece(ChessPiece piece, int square) {
        if(piece == null) {
            System.out.print(" -");
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

}
