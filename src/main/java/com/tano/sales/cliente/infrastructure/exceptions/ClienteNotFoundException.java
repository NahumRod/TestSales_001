package com.tano.sales.cliente.infrastructure.exceptions;

/**
 * Exception thrown when a Cliente entity is not found.
 */
public class ClienteNotFoundException extends RuntimeException {

    /**
     * Constructs a new ClienteNotFoundException with the specified detail message.
     *
     * @param message the detail message
     */
    public ClienteNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new ClienteNotFoundException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause of the exception
     */
    public ClienteNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new ClienteNotFoundException with the specified cause.
     *
     * @param cause the cause of the exception
     */
    public ClienteNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new ClienteNotFoundException with no detail message or cause.
     */
    public ClienteNotFoundException() {
        super();
    }
}