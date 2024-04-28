package chess;

import boardGame.Position;
import exceptions.ChessException;

/**
 * This class represents a position on a chess board.
 * It extends the Position class and adds chess-specific functionality.
 */
public class ChessPosition extends Position {

    // The column of the chess position (a-h)
    private char column;
    // The row of the chess position (1-8)
    private int row;

    /**
     * Constructor for the ChessPosition class.
     * It initializes the x and y fields with the provided values and converts them to a chess position.
     * @param x The x-coordinate of the position.
     * @param y The y-coordinate of the position.
     * @throws ChessException If the position is invalid.
     */
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

    /**
     * Constructor for the ChessPosition class.
     * It initializes the column and row fields with the provided values and converts them to a position.
     * @param column The column of the chess position (a-h).
     * @param row The row of the chess position (1-8).
     * @throws ChessException If the position is invalid.
     */
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

    /**
     * Getter for the row field.
     * @return The row of the chess position (1-8).
     */
    public int getRow() {
        return row;
    }

    /**
     * Getter for the column field.
     * @return The column of the chess position (a-h).
     */
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