package chess.pieces;

import boardGame.Board;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class Queen extends ChessPiece {

    private final String symbol;

    public Queen(Board board, Color color) {
        super(board, color);
        if(color == Color.WHITE) {
            this.symbol = "Q";
        }
        else {
            this.symbol = "Q";
        }
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matrixMoves = new boolean[getBoard().getRows()][getBoard().getColumns()];

        ChessPosition p = new ChessPosition(0, 0);

        // Above
        p.setValues(position.getX() - 1, position.getY());
        while(getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
            p.setX(p.getX() - 1);
        }
        matrixMoves[p.getX()][p.getY()] = checkOpponentPiece(p);

        // Left-above
        p.setValues(position.getX() - 1, position.getY() - 1);
        while(getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
            p.setValues(p.getX() - 1, p.getY() - 1);
        }
        matrixMoves[p.getX()][p.getY()] = checkOpponentPiece(p);

        // Left
        p.setValues(position.getX(), position.getY() - 1);
        while(getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
            p.setY(p.getY() - 1);
        }
        matrixMoves[p.getX()][p.getY()] = checkOpponentPiece(p);

        // Left-down
        p.setValues(position.getX() + 1, position.getY() - 1);
        while(getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
            p.setValues(p.getX() + 1, p.getY() - 1);
        }
        matrixMoves[p.getX()][p.getY()] = checkOpponentPiece(p);

        // Down
        p.setValues(position.getX() + 1, position.getY());
        while(getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
            p.setX(p.getX() + 1);
        }
        matrixMoves[p.getX()][p.getY()] = checkOpponentPiece(p);

        // Right-down
        p.setValues(position.getX() + 1, position.getY() + 1);
        while(getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
            p.setValues(p.getX() + 1, p.getY() + 1);
        }
        matrixMoves[p.getX()][p.getY()] = checkOpponentPiece(p);

        // Right
        p.setValues(position.getX(), position.getY() + 1);
        while(getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
            p.setY(p.getY() + 1);
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
