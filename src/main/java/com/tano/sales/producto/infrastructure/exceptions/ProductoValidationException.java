package com.tano.sales.producto.infrastructure.exceptions;

/**
 * Exception thrown when a Producto entity fails validation checks.
 */
public class ProductoValidationException extends RuntimeException {

    /**
     * Constructs a new ProductoValidationException with the specified detail message.
     *
     * @param message the detail message
     */
    public ProductoValidationException(String message) {
        super(message);
    }

    /**
     * Constructs a new ProductoValidationException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause of the exception
     */
    public ProductoValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new ProductoValidationException with the specified cause.
     *
     * @param cause the cause of the exception
     */
    public ProductoValidationException(Throwable cause) {
        super(cause);
    }
}