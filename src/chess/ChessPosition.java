package chess;

import boardGame.Position;
import exceptions.BoardException;
import exceptions.ChessException;
import boardGame.Board;

public class ChessPosition extends Position {

    private char column;
    private int row;

    public ChessPosition(int x, int y) throws ChessException {
        super();
        try {
            this.column = fromColumn(y);
            this.row = fromRow(x);
        } catch(ChessException e) {
            throw new ChessException(e.getMessage());
        }
        setValues(x, y);
    }

    public ChessPosition(char column, int row) throws ChessException {
        super();
        try {
            setValues(toRow(row), toColumn(column));
        } catch(ChessException e) {
            throw new ChessException(e.getMessage());
        }
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public char getColumn() {
        return column;
    }

    // Transform ChessPosition to Position
    protected static int toColumn(char column) throws ChessException {
        return switch (column) {
            case 'a' -> 0;
            case 'b' -> 1;
            case 'c' -> 2;
            case 'd' -> 3;
            case 'e' -> 4;
            case 'f' -> 5;
            case 'g' -> 6;
            case 'h' -> 7;
            default ->
                    throw new ChessException("Error ChessPosition to Position: Position [row, " + column + "] out of bounds");
        };
    }
    protected static int toRow(int row) throws ChessException {
        return switch (row) {
            case 8 -> 0;
            case 7 -> 1;
            case 6 -> 2;
            case 5 -> 3;
            case 4 -> 4;
            case 3 -> 5;
            case 2 -> 6;
            case 1 -> 7;
            default ->
                    throw new ChessException("Error Position to ChessPosition: Position [" + row + ", column] out of bounds");
        };
    }

    protected Position toPosition() {
        return new Position(toRow(row), toColumn(column));
    }

    protected static char fromColumn(int y) throws ChessException {
        return switch (y) {
            case 0 -> 'a';
            case 1 -> 'b';
            case 2 -> 'c';
            case 3 -> 'd';
            case 4 -> 'e';
            case 5 -> 'f';
            case 6 -> 'g';
            case 7 -> 'h';
            default ->
                    throw new ChessException("Error Position to ChessPosition: Position [x, " + y + "] out of bounds");
        };
    }

    protected static int fromRow(int x) throws ChessException {
        return switch (x) {
            case 0 -> 8;
            case 1 -> 7;
            case 2 -> 6;
            case 3 -> 5;
            case 4 -> 4;
            case 5 -> 3;
            case 6 -> 2;
            case 7 -> 1;
            default ->
                    throw new ChessException("Error Position to ChessPosition: Position [" + x + ", y] out of bounds");
        };
    }

    // Transform Position to ChessPosition
    protected static ChessPosition fromPosition(Position position) {
        return new ChessPosition(fromColumn(position.getY()), fromRow(position.getX()));
    }

    @Override
    public String toString() {
        return "[" + column + row + "]";
    }
}