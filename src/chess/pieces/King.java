package chess.pieces;

import boardGame.Board;
import chess.ChessPiece;
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



        return matrixMoves;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
