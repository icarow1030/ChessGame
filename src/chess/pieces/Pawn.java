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

        ChessPosition p = new ChessPosition(position.getX(), position.getY());

        // Initial Movement - White
        if(getColor() == Color.WHITE) {
            p.setValues(position.getX() - 1, position.getY());
            if(getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
                matrixMoves[p.getX()][p.getY()] = true;

                // Double forward move
                p.setValues(position.getX() - 2, position.getY());
                if(movementCount == 0 && getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
                    matrixMoves[p.getX()][p.getY()] = true;
                }
            }

            // Diagonal captures
            p.setValues(position.getX() - 1, position.getY() - 1);
            if(getBoard().positionExists(p) && hasOpponentPiece(p)) {
                matrixMoves[p.getX()][p.getY()] = true;
            }
            p.setValues(position.getX() - 1, position.getY() + 1);
            if(getBoard().positionExists(p) && hasOpponentPiece(p)) {
                matrixMoves[p.getX()][p.getY()] = true;
            }
        }
        // Initial Movement - Black
        else {
            p.setValues(position.getX() + 1, position.getY());
            if(getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
                matrixMoves[p.getX()][p.getY()] = true;

                // Double forward move
                p.setValues(position.getX() + 2, position.getY());
                if(movementCount == 0 && getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
                    matrixMoves[p.getX()][p.getY()] = true;
                }
            }

            // Diagonal captures
            p.setValues(position.getX() + 1, position.getY() - 1);
            if(getBoard().positionExists(p) && hasOpponentPiece(p)) {
                matrixMoves[p.getX()][p.getY()] = true;
            }
            p.setValues(position.getX() + 1, position.getY() + 1);
            if(getBoard().positionExists(p) && hasOpponentPiece(p)) {
                matrixMoves[p.getX()][p.getY()] = true;
            }
        }

        // Initial Movement - White
        /* p.setValues(position.getX(), position.getY());
        if(movementCount == 0) {
            if(!getBoard().hasPiece(new Position(p.getX() - 1, p.getY())) && getColor() == Color.WHITE) {
                matrixMoves[p.getX() - 1][p.getY()] = true;
            }
            if(!getBoard().hasPiece(new Position(p.getX() - 2, p.getY())) && getColor() == Color.WHITE) {
                matrixMoves[p.getX() - 2][p.getY()] = true;
            }
            if(!getBoard().hasPiece(new Position(p.getX() + 1, p.getY())) && getColor() == Color.BLACK) {
                matrixMoves[p.getX() + 1][p.getY()] = true;
            }
            if(!getBoard().hasPiece(new Position(p.getX() + 2, p.getY())) && getColor() == Color.BLACK) {
                matrixMoves[p.getX() + 2][p.getY()] = true;
            }
        }
        else {
            if(getColor() == Color.WHITE) {
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
            else {
                p.setX(position.getX() + 1);
                if(!getBoard().hasPiece(p)) {
                    matrixMoves[p.getX()][p.getY()] = true;
                }
                p.setValues(position.getX() + 1, position.getY() + 1);
                if(getBoard().hasPiece(p)) {
                    matrixMoves[p.getX()][p.getY()] = true;
                }
                p.setValues(position.getX() + 1, position.getY() - 1);
                if(getBoard().hasPiece(p)) {
                    matrixMoves[p.getX()][p.getY()] = true;
                }
            }
        } */
        return matrixMoves;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
