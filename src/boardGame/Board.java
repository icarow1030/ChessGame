package boardGame;

import chess.ChessPiece;
import exceptions.*;

import java.util.ArrayList;

/**
 * This class represents a game board.
 */
public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    /**
     * Constructs a new Board with the specified number of rows and columns.
     *
     * @param rows the number of rows
     * @param columns tbe number of columns
     * @throws BoardException if rows or columns are less than 1
     */
    public Board(int rows, int columns) throws BoardException {
        if(rows < 1 || columns < 1) {
            throw new BoardException("Error creating board: Board needs at least to be 1x1");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    /**
     * Returns the number of rows in the board.
     *
     * @return the number of rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * Returns the number of columns in the board.
     *
     * @return the number of columns
     */
    public int getColumns() {
        return columns;
    }

    /**
     * Returns the piece at the specified position.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @return the piece at the specified position
     * @throws BoardException if the position if out of bounds
     */
    public Piece piece(int x, int y) throws BoardException {
        if(positionExists(x, y)) {
            return pieces[x][y];
        }
        else {
            throw new BoardException("Error getting a piece: Position [" + x + ", " + y + "] is out of bounds");
        }
    }

    /**
     * Returns the piece at the specified position.
     *
     * @param position the position (x-coordinate, y-coordinate)
     * @return the piece at the specified position
     * @throws BoardException if the position is out of bounds
     */
    public Piece piece(Position position) throws BoardException {
        if(positionExists(position)) {
            return pieces[position.getX()][position.getY()];
        }
        else {
            throw new BoardException("Error getting a piece: Position " + position + " is out of bounds");
        }
    }

    /**
     * Places a piece at the specified position.
     *
     * @param piece the piece to place
     * @param position the position to place the piece at
     * @throws BoardException if the position is already occupied or is out of bounds
     */
    public void placePiece(Piece piece, Position position) throws BoardException {
        try {
            if (!hasPiece(position)) {
                if(piece.position != null) {
                    removePiece(piece.position);
                }
                this.pieces[position.getX()][position.getY()] = piece;
                piece.position = position;
            } else {
                throw new BoardException("[Placing Piece] Error placing piece: Position " + position + " already occupied");
            }
        } catch(BoardException e) {
            throw new BoardException("[Placing Piece] " + e.getMessage());
        }
    }

    /**
     * Remove a piece at the specified position.
     *
     * @param position the position of the piece to remove
     * @return the piece that was removed from the board
     * @throws BoardException if the position doesn't have a piece or is out of bounds
     */
    public Piece removePiece(Position position) throws BoardException {
        try {
            if(hasPiece(position)) {
                Piece removedPiece = this.pieces[position.getX()][position.getY()];
                this.pieces[position.getX()][position.getY()].position = null;
                this.pieces[position.getX()][position.getY()] = null;
                return removedPiece;
            } else {
                throw new BoardException("[Removing Piece] Error removing piece: Position " + position + " doesn't have a piece");
            }
        } catch(BoardException e) {
            throw new BoardException("[Removing Piece] " + e.getMessage());
        }
    }

    /**
     * Checks if there is a piece at the specified position
     *
     * @param position the position to check
     * @return true if there is a piece at the specified position
     * @throws BoardException if the position is out of bounds
     */
    public boolean hasPiece(Position position) throws BoardException {
        if(positionExists(position)) {
            return piece(position) != null;
        }
        else {
            throw new BoardException("Error checking if there is a piece: Position " + position + " is out of bounds");
        }
    }

    /**
     * Checks if the specified position exists on the board
     *
     * @param x the x-coordinate to check
     * @param y the y-coordinate to check
     * @return true if the position exists
     */
    // Position Check
    public boolean positionExists(int x, int y) {
        return x < rows && y < columns && x >= 0 && y >= 0;
    }

    /**
     * Checks if the specified position exists on the board
     *
     * @param position the position to check
     * @return true if the position exists
     */
    public boolean positionExists(Position position) {
        return positionExists(position.getX(), position.getY());
    }



}
