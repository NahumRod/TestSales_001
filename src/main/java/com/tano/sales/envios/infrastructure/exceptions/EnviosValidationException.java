package com.tano.sales.envios.infrastructure.exceptions;

/**
 * Exception thrown when validation errors occur in Envios operations.
 */
public class EnviosValidationException extends RuntimeException {

    /**
     * Constructs a new EnviosValidationException with the specified detail message.
     *
     * @param message the detail message
     */
    public EnviosValidationException(String message) {
        super(message);
    }

    /**
     * Constructs a new EnviosValidationException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause of the exception
     */
    public EnviosValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new EnviosValidationException with the specified cause.
     *
     * @param cause the cause of the exception
     */
    public EnviosValidationException(Throwable cause) {
        super(cause);
    }
}