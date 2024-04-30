package boardGame;

/**
 * This class represents a position on a board game.
 * It contains two integer fields, x and y, representing the coordinates of the position.
 */
public class Position {
    // The x-coordinate of the position
    protected int x;
    // The y-coordinate of the position
    protected int y;

    /**
     * Constructor for the Position class.
     * It initializes the x and y fields with the provided values.
     * @param x The x-coordinate of the position.
     * @param y The y-coordinate of the position.
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Default constructor for the Position class.
     * It initializes the x and y fields to zero.
     */
    public Position() {

    }

    /**
     * Getter for the x field.
     * @return The x-coordinate of the position.
     */
    public int getX() {
        return this.x;
    }

    /**
     * Getter for the y field.
     * @return The y-coordinate of the position.
     */
    public int getY() {
        return this.y;
    }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    /**
     * This method sets the x and y fields to the provided values.
     * @param x The new x-coordinate of the position.
     * @param y The new y-coordinate of the position.
     */
    public void setValues(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * This method returns a string representation of the position.
     * The string is in the format "[x, y]".
     * @return A string representing the position.
     */
    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}