package exceptions;

import java.io.Serial;

public class ChessException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public ChessException(String msg) {
        super(msg);
    }
}