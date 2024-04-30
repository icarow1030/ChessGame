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
    public abstract boolean[][] possibleMoves();

    public boolean possibleMove(Position position) {
        return possibleMoves()[position.getX()][position.getY()];
    }

    public boolean isThereAnyPossibleMove() {
        for(int i = 0; i < possibleMoves().length; i++) {
            for(int j = 0; j < possibleMoves().length; j++) {
                if(possibleMove(new Position(i, j))) {
                    return true;
                }
            }
        }
        return false;
    }

}
