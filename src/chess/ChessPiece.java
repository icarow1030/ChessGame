package chess;

import boardGame.Board;
import boardGame.Piece;

public abstract class ChessPiece extends Piece {

    private Color color;
    protected int movementCount;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
        movementCount = 0;
    }

    public Color getColor() {
        return this.color;
    }
    public ChessPosition getChessPosition() { return new ChessPosition(this.position.getX(), this.position.getY()); }
    public int getMovementCount() { return this.movementCount; }
    public void increaseMovementCount() { this.movementCount += 1; }

    protected boolean hasOpponentPiece(ChessPosition position) {
        ChessPiece piece = (ChessPiece) getBoard().piece(position);
        return piece != null && piece.getColor() != color;
    }

}
