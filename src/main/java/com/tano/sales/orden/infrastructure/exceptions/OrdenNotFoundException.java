package com.tano.sales.orden.infrastructure.exceptions;

/**
 * Exception thrown when an Orden entity is not found.
 */
public class OrdenNotFoundException extends RuntimeException {

    /**
     * Constructs a new OrdenNotFoundException with the specified detail message.
     *
     * @param message the detail message
     */
    public OrdenNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new OrdenNotFoundException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause of the exception
     */
    public OrdenNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new OrdenNotFoundException with the cause.
     *
     * @param cause the cause of the exception
     */
    public OrdenNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new OrdenNotFoundException with no detail message or cause.
     */
    public OrdenNotFoundException() {
        super();
    }
}