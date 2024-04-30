package chessGame;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.ArrayList;

public class Chess {
    public static void main(String[] args) {

        ChessMatch match = new ChessMatch();

        ArrayList<ChessPiece> capturedPieces = new ArrayList<>();

        do {
            try {
                UI.clearScreen();
                UI.printBoard(match.getPieces());
                for(ChessPiece piece : capturedPieces) {
                    System.out.print("[" + piece +"]");
                }
                System.out.print("Source > ");
                ChessPosition sourcePosition = UI.readChessPosition();
                System.out.println(sourcePosition);
                System.out.print("Target > ");
                ChessPosition targetPosition = UI.readChessPosition();
                System.out.println(targetPosition);
                ChessPiece capturedPiece = match.performChessMove(sourcePosition, targetPosition);
                if(capturedPiece != null) {
                    capturedPieces.add(capturedPiece);
                }
            } catch(RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } while(true);


    }
}
