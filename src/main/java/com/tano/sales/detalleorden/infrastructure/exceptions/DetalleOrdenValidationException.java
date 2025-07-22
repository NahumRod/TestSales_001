package com.tano.sales.detalleorden.infrastructure.exceptions;

/**
 * Exception thrown when validation of DetalleOrden entity fails.
 */
public class DetalleOrdenValidationException extends RuntimeException {

    /**
     * Constructs a new DetalleOrdenValidationException with the specified detail message.
     *
     * @param message the detail message
     */
    public DetalleOrdenValidationException(String message) {
        super(message);
    }

    /**
     * Constructs a new DetalleOrdenValidationException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause of the exception
     */
    public DetalleOrdenValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new DetalleOrdenValidationException with the specified cause.
     *
     * @param cause the cause of the exception
     */
    public DetalleOrdenValidationException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new DetalleOrdenValidationException with no detail message or cause.
     */
    public DetalleOrdenValidationException() {
        super();
    }
}