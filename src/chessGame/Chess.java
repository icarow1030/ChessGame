package chessGame;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.ArrayList;

public class Chess {
    public static void main(String[] args) {

        ChessMatch match = new ChessMatch();

        do {
            try {
                UI.clearScreen();
                UI.printMatch(match);
                UI.printCapturedPieces(match.getCapturedPieces());
                System.out.println();
                System.out.print("Source > ");
                ChessPosition sourcePosition = UI.readChessPosition();
                if(sourcePosition == null) {
                    return;
                }
                boolean[][] possibleMoves = match.possibleMoves(sourcePosition);
                UI.clearScreen();
                UI.printMatch(match, possibleMoves);
                UI.printCapturedPieces(match.getCapturedPieces());

                System.out.println(sourcePosition);
                System.out.print("Target > ");
                ChessPosition targetPosition = UI.readChessPosition();
                System.out.println(targetPosition);
                ChessPiece capturedPiece = match.performChessMove(sourcePosition, targetPosition);
            } catch(RuntimeException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
                UserInput.waitEnt();
            }
        } while(!match.getCheckMate());
        UI.clearScreen();
        UI.printMatch(match);
        UI.printCapturedPieces(match.getCapturedPieces());
        System.out.println("END OF THE GAME! C H E C K M A T E!");
        System.out.println(match.getCurrentPlayer() + " WON!");
    }
}
