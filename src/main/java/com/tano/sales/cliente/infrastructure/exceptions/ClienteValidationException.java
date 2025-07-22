package com.tano.sales.cliente.infrastructure.exceptions;

/**
 * Exception thrown when validation of a Cliente entity fails.
 */
public class ClienteValidationException extends RuntimeException {

    /**
     * Constructs a new ClienteValidationException with the specified detail message.
     *
     * @param message the detail message
     */
    public ClienteValidationException(String message) {
        super(message);
    }

    /**
     * Constructs a new ClienteValidationException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause of the exception
     */
    public ClienteValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new ClienteValidationException with the specified cause.
     *
     * @param cause the cause of the exception
     */
    public ClienteValidationException(Throwable cause) {
        super(cause);
    }
}