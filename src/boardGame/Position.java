package boardGame;

public class Position {
    protected int x;
    protected int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position() {

    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setValues(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
