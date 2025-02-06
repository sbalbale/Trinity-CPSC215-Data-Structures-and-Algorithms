package edu.trincoll;

/**
 * Exception thrown when an attempt is made to set a product quantity to an invalid value.
 */
public class InsufficientQuantityException extends Exception {
    /**
     * Constructs a new InsufficientQuantityException with the specified detail message.
     *
     * @param message the detail message
     */
    public InsufficientQuantityException(String message) {
        super(message);
    }
}