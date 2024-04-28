package exceptions;

import java.io.Serial;

/**
 * This class represents a custom exception for the chess game.
 * It extends the RuntimeException class, meaning it's an unchecked exception.
 */
public class ChessException extends BoardException {

    @Serial
    // This field represents the serial version UID for the serialization mechanism in Java.
    private static final long serialVersionUID = 1L;

    /**
     * Constructor for the ChessException class.
     * It calls the superclass constructor (RuntimeException) passing the message.
     *
     * @param msg The detail message for the exception.
     */
    public ChessException(String msg) {
        super(msg);
    }
}