package boardGame;

import chess.ChessPiece;
import exceptions.*;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) throws BoardException {
        if(rows < 1 || columns < 1) {
            throw new BoardException("Error creating board: Board needs at least to be 1x1");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int x, int y) throws BoardException {
        if(positionExists(x, y)) {
            return pieces[x][y];
        }
        else {
            throw new BoardException("Error getting a piece: Position [" + x + ", " + y + "] is out of bounds");
        }
    }

    public Piece piece(Position position) throws BoardException {
        if(positionExists(position)) {
            return pieces[position.getX()][position.getY()];
        }
        else {
            throw new BoardException("Error getting a piece: Position " + position + "is out of bounds");
        }
    }

    public void placePiece(Piece piece, Position position) throws BoardException {
        try {
            if (!hasPiece(position)) {
                this.pieces[position.getX()][position.getY()] = piece;
                piece.position = position;
            } else {
                throw new BoardException("Error placing piece: Position " + position + " already occupied");
            }
        } catch(BoardException e) {
            throw new BoardException(e.getMessage());
        }
    }

    // Check if there is a piece
    public boolean hasPiece(Position position) throws BoardException {
        if(positionExists(position)) {
            return piece(position) != null;
        }
        else {
            throw new BoardException("Error checking if there is a piece: Position " + position + " is out of bounds");
        }
    }

    // Position Check
    public boolean positionExists(int x, int y) {
        return x < rows && y < columns && x >= 0 && y >= 0;
    }

    public boolean positionExists(Position position) {
        return positionExists(position.getX(), position.getY());
    }

}
