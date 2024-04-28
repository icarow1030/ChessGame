package boardGame;

import boardGame.Position;

public abstract class Piece {

    protected Position position;
    private Board board;

    public Piece() {

    }

    public Piece(Board board) {
        this.board = board;
        this.position = null;
    }

    protected Board getBoard() {
        return this.board;
    }

    /**
     * @return boolean matrix, where 'true' is a possible move, and 'false' is an impossible move
     */


}
