package exceptions;

import java.io.Serial;

public class BoardException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public BoardException(String msg) {
        super(msg);
    }
}
