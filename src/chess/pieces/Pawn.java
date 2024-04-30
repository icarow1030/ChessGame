package chess.pieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class Pawn extends ChessPiece {

    private final String symbol;

    public Pawn(Board board, Color color) {
        super(board, color);
        if(color == Color.WHITE) {
            this.symbol = "0";
        }
        else {
            this.symbol = "0";
        }
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matrixMoves = new boolean[getBoard().getRows()][getBoard().getColumns()];

        ChessPosition p = new ChessPosition(0, 0);

        // Initial Movement
        p.setValues(position.getX(), position.getY());
        if(movementCount == 0) {
            if(!getBoard().hasPiece(new Position(p.getX() - 1, p.getY()))) {
                matrixMoves[p.getX() - 1][p.getY()] = true;
            }
            if(!getBoard().hasPiece(new Position(p.getX() - 2, p.getY()))) {
                matrixMoves[p.getX() - 2][p.getY()] = true;
            }
        }
        else {
            p.setX(position.getX() - 1);
            if(!getBoard().hasPiece(p)) {
                matrixMoves[p.getX()][p.getY()] = true;
            }
            p.setValues(position.getX() - 1, position.getY() - 1);
            if(getBoard().hasPiece(p)) {
                matrixMoves[p.getX()][p.getY()] = true;
            }
            p.setValues(position.getX() - 1, position.getY() + 1);
            if(getBoard().hasPiece(p)) {
                matrixMoves[p.getX()][p.getY()] = true;
            }
        }

        return matrixMoves;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
