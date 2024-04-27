package chess.pieces;

import boardGame.Board;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {

    private final String symbol;

    public Knight(Board board, Color color) {
        super(board, color);
        if(color == Color.WHITE) {
            this.symbol = "♘";
        }
        else {
            this.symbol = "♞";
        }
    }

    @Override
    public String toString() {
        return symbol;
    }
}