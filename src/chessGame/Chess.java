package chessGame;

import chess.ChessMatch;

public class Chess {
    public static void main(String[] args) {

        ChessMatch match = new ChessMatch();
        UI.printBoard(match.getPieces());

    }
}
