package boardGame;

import chess.ChessPiece;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
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

    public Piece piece(int row, int column) {
        return pieces[row][column];
    }

    public Piece piece(Position position) {
        return pieces[position.getX()][position.getY()];
    }

    public void placePiece(Piece piece, Position position) {
        if(!hasPiece(position)) {
            try {
                this.pieces[position.getX()][position.getY()] = piece;
                piece.position = position;
            } catch(IndexOutOfBoundsException e) {
                System.out.println("Out of Bounds");
            }
        }
        else {
            System.out.println("Occupied Position!");
        }

    }

    public boolean hasPiece(Position position) {
        return pieces[position.getX()][position.getY()] != null;
    }

}
