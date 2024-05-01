package chess.pieces;

import boardGame.Board;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class King extends ChessPiece {

    private final String symbol;

    public King(Board board, Color color) {
        super(board, color);
        if(color == Color.WHITE) {
            this.symbol = "R";
        }
        else {
            this.symbol = "R";
        }
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matrixMoves = new boolean[getBoard().getRows()][getBoard().getColumns()];

        ChessPosition p = new ChessPosition(0, 0);

        // Above
        p.setValues(position.getX() - 1, position.getY());
        if(getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }
        if(getBoard().positionExists(p) && hasOpponentPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }
        // Down
        p.setValues(position.getX() + 1, position.getY());
        if(getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }
        if(getBoard().positionExists(p) && hasOpponentPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }

        // Right
        p.setValues(position.getX(), position.getY() + 1);
        if(getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }
        if(getBoard().positionExists(p) && hasOpponentPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }

        // Left
        p.setValues(position.getX(), position.getY() - 1);
        if(getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }
        if(getBoard().positionExists(p) && hasOpponentPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }

        // Diagonal top left
        p.setValues(position.getX() - 1, position.getY() - 1);
        if(getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }
        if(getBoard().positionExists(p) && hasOpponentPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }

        // Diagonal top right
        p.setValues(position.getX() - 1, position.getY() + 1);
        if(getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }
        if(getBoard().positionExists(p) && hasOpponentPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }

        // Diagonal bottom left
        p.setValues(position.getX() + 1, position.getY() - 1);
        if(getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }
        if(getBoard().positionExists(p) && hasOpponentPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }

        // Diagonal bottom right
        p.setValues(position.getX() + 1, position.getY() + 1);
        if(getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }
        if(getBoard().positionExists(p) && hasOpponentPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
        }

        return matrixMoves;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
