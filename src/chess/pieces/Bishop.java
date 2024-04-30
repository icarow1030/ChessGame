package chess.pieces;

import boardGame.Board;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class Bishop extends ChessPiece {

    private final String symbol;

    public Bishop(Board board, Color color) {
        super(board, color);
        if(color == Color.WHITE) {
            this.symbol = "B";
        }
        else {
            this.symbol = "B";
        }
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matrixMoves = new boolean[getBoard().getRows()][getBoard().getColumns()];

        ChessPosition p = new ChessPosition(0, 0);

        // Left-above
        p.setValues(position.getX() - 1, position.getY() - 1);
        while(getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
            p.setValues(p.getX() - 1, p.getY() - 1);
        }
        matrixMoves[p.getX()][p.getY()] = checkOpponentPiece(p);

        // Left-down
        p.setValues(position.getX() + 1, position.getY() - 1);
        while(getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
            p.setValues(p.getX() + 1, p.getY() - 1);
        }
        matrixMoves[p.getX()][p.getY()] = checkOpponentPiece(p);

        // Right-down
        p.setValues(position.getX() + 1, position.getY() + 1);
        while(getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
            p.setValues(p.getX() + 1, p.getY() + 1);
        }
        matrixMoves[p.getX()][p.getY()] = checkOpponentPiece(p);

        // Right-above
        p.setValues(position.getX() - 1, position.getY() + 1);
        while(getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
            p.setValues(p.getX() - 1, p.getY() + 1);
        }
        matrixMoves[p.getX()][p.getY()] = checkOpponentPiece(p);

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
