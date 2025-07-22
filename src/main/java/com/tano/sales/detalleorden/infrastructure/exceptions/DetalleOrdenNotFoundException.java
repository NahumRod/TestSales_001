package com.tano.sales.detalleorden.infrastructure.exceptions;

/**
 * Exception thrown when a DetalleOrden entity is not found.
 */
public class DetalleOrdenNotFoundException extends RuntimeException {

    /**
     * Constructs a new DetalleOrdenNotFoundException with the specified detail message.
     *
     * @param message the detail message
     */
    public DetalleOrdenNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new DetalleOrdenNotFoundException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause of the exception
     */
    public DetalleOrdenNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new DetalleOrdenNotFoundException with the specified cause.
     *
     * @param cause the cause of the exception
     */
    public DetalleOrdenNotFoundException(Throwable cause) {
        super(cause);
    }
}