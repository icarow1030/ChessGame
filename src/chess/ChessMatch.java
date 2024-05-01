package chess;

import boardGame.Board;
import boardGame.Position;
import chess.pieces.*;
import exceptions.BoardException;
import exceptions.ChessException;

import java.util.ArrayList;

/**
 * This class represents a chess match
 */
public class ChessMatch {

    // The board on which the chess match is played
    private Board board;
    private int turn;
    private Color currentPlayer;

    private ArrayList<ChessPiece> piecesOnBoard = new ArrayList<>();
    private ArrayList<ChessPiece> capturedPieces = new ArrayList<>();

    /**
     * Constructor for the ChessMatch class.
     * Initializes the board and sets up the initial positions of the pieces.
     */
    public ChessMatch() {
        board = new Board(8, 8);
        turn = 1;
        currentPlayer = Color.WHITE;
        initialSetup();
    }

    public int getTurn() { return turn; }
    public Color getCurrentPlayer() { return currentPlayer; }

    public ArrayList<ChessPiece> getPiecesOnBoard() {
        return piecesOnBoard;
    }
    public ArrayList<ChessPiece> getCapturedPieces() {
        return capturedPieces;
    }

    /**
     * Returns a matrix representation of the current state of the chess board.
     *
     * @return A 2D array of ChessPiece objects representing the current state of the board.
     */
    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for(int i = 0; i < board.getRows(); i++) {
            for(int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }

    /**
     * Places a new piece on the board at the specified position.
     *
     * @param column The column (a-h) where the piece should be placed.
     * @param row The row (1-8) where the piece should be placed.
     * @param piece The piece to be placed on the board.
     * @throws ChessException If the position is invalid or already occupied.
     */
    private void placeNewPiece(char column, int row, ChessPiece piece) throws ChessException {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
        piecesOnBoard.add(piece);
    }

    public boolean[][] possibleMoves(ChessPosition source) {
        validateSourcePiece(source);
        return board.piece(source).possibleMoves();
    }

    public ChessPiece performChessMove(ChessPosition source, ChessPosition target) throws BoardException {
        validateSourcePiece(source);
        validateTargetPosition(source, target);
        nextTurn();
        return makeMove(source, target);
    }

    private ChessPiece makeMove(ChessPosition source, ChessPosition target) throws RuntimeException {
        ChessPiece sourcePiece = (ChessPiece) board.piece(source.toPosition());
        ChessPiece capturedPiece = null;
        if(hasPieceOnTarget(target)) {
            capturedPiece = capturePiece(target);
        }
        board.placePiece(sourcePiece, target);
        sourcePiece.increaseMovementCount();
        return capturedPiece;
    }

    /* public boolean[][] possibleMoves(ChessPosition source) {

    } */

    private void validateSourcePiece(ChessPosition position) throws BoardException {
        if(!board.hasPiece(position.toPosition())) {
            throw new ChessException("There is no piece on " + position);
        }
        if(currentPlayer != ((ChessPiece) board.piece(position)).getColor()) {
            throw new ChessException("This is not your piece");
        }
        if(!board.piece(position).isThereAnyPossibleMove()) {
            throw new ChessException("This piece doesn't have any possible moves");
        }
    }

    private void validateTargetPosition(ChessPosition source, ChessPosition target) throws BoardException {
        if(!board.piece(source).possibleMove(target)) {
            throw new ChessException("Invalid Move");
        }
    }

    private boolean hasPieceOnTarget(ChessPosition target) throws BoardException {
        return board.hasPiece(target.toPosition());
    }

    private ChessPiece capturePiece(ChessPosition target) throws BoardException {
        ChessPiece capturedPiece = (ChessPiece) board.piece(target);
        capturedPieces.add(capturedPiece);
        piecesOnBoard.remove(capturedPiece);
        return (ChessPiece) board.removePiece(target.toPosition());
    }

    private void nextTurn() {
        this.turn++;
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    /**
     * Sets up the initial positions of the pieces on the chess board.
     * This method is called when a new ChessMatch object is created.
     */
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
