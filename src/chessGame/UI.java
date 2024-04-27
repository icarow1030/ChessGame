package chessGame;

import chess.ChessPiece;
import chess.Color;

/**
 * This class is responsible for the User Interface (UI) of the chess game.
 * It includes methods to print the chess board and the chess pieces.
 */
public class UI {

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
        System.out.println("\n     a  b  c  d  e  f  g  h");

    }// This is a board

    /**
     * This private method prints a single chess piece on the console.
     * If the piece is null, it prints a dash ("-") to represent an empty square.
     * Otherwise, it prints the string representation of the ChessPiece object.
     *
     * @param piece ChessPiece object to be printed.
     */
    private static void printPiece(ChessPiece piece, int square) {
        String red = "\033[0;31m";    // RED
        String blue = "\033[0;34m";   // BLUE
        String reset = "\033[0m";
        if(piece == null) {
            System.out.print("- ");
        }
        else {
            if(piece.getColor() == Color.BLACK) {
                System.out.print(red + piece + "  " + reset);
            }
            else {
                System.out.print(blue + piece + "  " + reset);
            }
        }
        System.out.print(" ");
    }

}
