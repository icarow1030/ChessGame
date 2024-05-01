package chess.pieces;

import boardGame.Board;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class Knight extends ChessPiece {

    private final String symbol;

    public Knight(Board board, Color color) {
        super(board, color);
        if(color == Color.WHITE) {
            this.symbol = "K";
        }
        else {
            this.symbol = "K";
        }
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matrixMoves = new boolean[getBoard().getRows()][getBoard().getColumns()];

        ChessPosition p = new ChessPosition(position.getX(), position.getY());

        // Above-left
        p.setValues(position.getX() - 2, position.getY() - 1);
        if(getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }
        if(getBoard().positionExists(p) && hasOpponentPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }

        // Above-right
        p.setValues(position.getX() - 2, position.getY() + 1);
        if(getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }
        if(getBoard().positionExists(p) && hasOpponentPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }

        // Left-above
        p.setValues(position.getX() - 1, position.getY() - 2);
        if(getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }
        if(getBoard().positionExists(p) && hasOpponentPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }

        // Left-down
        p.setValues(position.getX() + 1, position.getY() - 2);
        if(getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }
        if(getBoard().positionExists(p) && hasOpponentPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }

        p.setValues(position.getX() + 1, position.getY() - 2);
        if(getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }
        if(getBoard().positionExists(p) && hasOpponentPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }

        // Down-left
        p.setValues(position.getX() + 2, position.getY() - 1);
        if(getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }
        if(getBoard().positionExists(p) && hasOpponentPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }

        // Down-right
        p.setValues(position.getX() + 2, position.getY() + 1);
        if(getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }
        if(getBoard().positionExists(p) && hasOpponentPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }

        // Right-above
        p.setValues(position.getX() - 1, position.getY() + 2);
        if(getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }
        if(getBoard().positionExists(p) && hasOpponentPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }

        // Right-down
        p.setValues(position.getX() + 1, position.getY() + 2);
        if(getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }
        if(getBoard().positionExists(p) && hasOpponentPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }

        if(getBoard().positionExists(p) && hasOpponentPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }

        return matrixMoves;
    }

    private boolean checkOpponentPiece(ChessPosition p) {
        return getBoard().positionExists(p) && hasOpponentPiece(p);
    }

    @Override
    public String toString() {
        return symbol;
    }
}
