package com.tano.sales.envios.infrastructure.exceptions;

/**
 * Generic application exception for Envios module.
 * Serves as the base exception for all application-specific exceptions.
 */
public class ApplicationException extends RuntimeException {

    /**
     * Constructs a new ApplicationException with the specified detail message.
     *
     * @param message the detail message
     */
    public ApplicationException(String message) {
        super(message);
    }

    /**
     * Constructs a new ApplicationException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause of the exception
     */
    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new ApplicationException with the specified cause.
     *
     * @param cause the cause of the exception
     */
    public ApplicationException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new ApplicationException with no detail message or cause.
     */
    public ApplicationException() {
        super();
    }
}