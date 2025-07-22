package com.tano.sales.orden.infrastructure.exceptions;

/**
 * Exception thrown when validation of an Orden entity fails.
 */
public class OrdenValidationException extends RuntimeException {

    /**
     * Constructs a new OrdenValidationException with the specified detail message.
     *
     * @param message the detail message
     */
    public OrdenValidationException(String message) {
        super(message);
    }

    /**
     * Constructs a new OrdenValidationException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause of the exception
     */
    public OrdenValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}