package chess.pieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;
import exceptions.BoardException;

public class Rook extends ChessPiece {

    private final String symbol;

    public Rook(Board board, Color color) {
        super(board, color);
        if(color == Color.WHITE) {
            this.symbol = "H";
        }
        else {
            this.symbol = "H";
        }
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matrixMoves = new boolean[getBoard().getRows()][getBoard().getColumns()];

        ChessPosition p = new ChessPosition(position.getX(), position.getY());

        // Up Movement
        p.setValues(position.getX() - 1, position.getY());
        while(getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
            p.setX(p.getX() - 1);
        }
        matrixMoves[p.getX()][p.getY()] = checkOpponentPiece(p);

        // Down Movement
        p.setValues(position.getX() + 1, position.getY());
        while(getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
            p.setX(p.getX() + 1);
        }
        matrixMoves[p.getX()][p.getY()] = checkOpponentPiece(p);

        // Left Movement
        p.setValues(position.getX(), position.getY() - 1);
        while(getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
            p.setY(p.getY() - 1);
        }
        matrixMoves[p.getX()][p.getY()] = checkOpponentPiece(p);

        // Right Movement
        p.setValues(position.getX(), position.getY() + 1);
        while(getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
            matrixMoves[p.getX()][p.getY()] = true;
            p.setY(p.getY() + 1);
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
