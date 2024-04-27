package chess;

import boardGame.Board;
import boardGame.Position;
import chess.pieces.*;

public class ChessMatch {

    private Board board;

    public ChessMatch() {
        board = new Board(8, 8);
        initialSetup();

    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for(int i = 0; i < board.getRows(); i++) {
            for(int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }

    private void initialSetup() {
        // Black Pawns
        for(int i = 0; i < 8; i++) {
            board.placePiece(new Pawn(board, Color.BLACK), new Position(1, i));
        }
        // Black Rooks
        board.placePiece(new Rook(board, Color.BLACK), new Position(0, 0));
        board.placePiece(new Rook(board, Color.BLACK), new Position(0, 7));
        // Black Knights
        board.placePiece(new Knight(board, Color.BLACK), new Position(0, 1));
        board.placePiece(new Knight(board, Color.BLACK), new Position(0, 6));
        // Black Bishops
        board.placePiece(new Bishop(board, Color.BLACK), new Position(0, 2));
        board.placePiece(new Bishop(board, Color.BLACK), new Position(0, 5));
        // Black King
        board.placePiece(new King(board, Color.BLACK), new Position(0, 3));
        // Black Queen
        board.placePiece(new Queen(board, Color.BLACK), new Position(0, 4));

        // White Pawns
        for(int i = 0; i < 8; i++) {
            board.placePiece(new Pawn(board, Color.WHITE), new Position(6, i));
        }
        // White Rooks
        board.placePiece(new Rook(board, Color.WHITE), new Position(7, 0));
        board.placePiece(new Rook(board, Color.WHITE), new Position(7, 7));
        // White Knights
        board.placePiece(new Knight(board, Color.WHITE), new Position(7, 1));
        board.placePiece(new Knight(board, Color.WHITE), new Position(7, 6));
        // White Bishops
        board.placePiece(new Bishop(board, Color.WHITE), new Position(7, 2));
        board.placePiece(new Bishop(board, Color.WHITE), new Position(7, 5));
        // Black King
        board.placePiece(new King(board, Color.WHITE), new Position(7, 3));
        // Black Queen
        board.placePiece(new Queen(board, Color.WHITE), new Position(7, 4));

    }
}
