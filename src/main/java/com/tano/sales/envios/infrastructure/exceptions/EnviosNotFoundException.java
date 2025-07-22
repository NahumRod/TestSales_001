package com.tano.sales.envios.infrastructure.exceptions;

/**
 * Exception thrown when an Envios entity is not found.
 */
public class EnviosNotFoundException extends RuntimeException {

    /**
     * Constructs a new EnviosNotFoundException with the specified detail message.
     *
     * @param message the detail message
     */
    public EnviosNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new EnviosNotFoundException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause of the exception
     */
    public EnviosNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new EnviosNotFoundException with the specified cause.
     *
     * @param cause the cause of the exception
     */
    public EnviosNotFoundException(Throwable cause) {
        super(cause);
    }
}