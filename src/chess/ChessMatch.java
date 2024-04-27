package chess;

import boardGame.Board;
import boardGame.Position;
import chess.pieces.*;
import exceptions.ChessException;

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

    private void placeNewPiece(char column, int row, ChessPiece piece) throws ChessException {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    private void initialSetup() {
        // Black Pawns
        for(char column = 'a'; column <= 'h'; column++) {
            placeNewPiece(column, 7, new Pawn(board, Color.BLACK));
        }
        // Black Rooks
        placeNewPiece('a', 8, new Rook(board, Color.BLACK));
        placeNewPiece('h', 8, new Rook(board, Color.BLACK));


        // Black Knights
        placeNewPiece('b', 8, new Knight(board, Color.BLACK));
        placeNewPiece('g', 8, new Knight(board, Color.BLACK));

        // Black Bishops
        placeNewPiece('c', 8, new Bishop(board, Color.BLACK));
        placeNewPiece('f', 8, new Bishop(board, Color.BLACK));

        // Black Queen
        placeNewPiece('d', 8, new Queen(board, Color.BLACK));

        // Black King
        placeNewPiece('e', 8, new King(board, Color.BLACK));

        // White Pawns
        for(char column = 'a'; column <= 'h'; column++) {
            placeNewPiece(column, 2, new Pawn(board, Color.WHITE));
        }

        // White Rooks
        placeNewPiece('a', 1, new Rook(board, Color.WHITE));
        placeNewPiece('h', 1, new Rook(board, Color.WHITE));

        // White Knights
        placeNewPiece('b', 1, new Knight(board, Color.WHITE));
        placeNewPiece('g', 1, new Knight(board, Color.WHITE));

        // White Bishops
        placeNewPiece('c', 1, new Bishop(board, Color.WHITE));
        placeNewPiece('f', 1, new Bishop(board, Color.WHITE));

        // White Queen
        placeNewPiece('d', 1, new Queen(board, Color.WHITE));

        // White King
        placeNewPiece('e', 1, new King(board, Color.WHITE));
    }
}
