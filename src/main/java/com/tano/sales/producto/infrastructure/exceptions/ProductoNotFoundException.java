package com.tano.sales.producto.infrastructure.exceptions;

/**
 * Exception thrown when a Producto entity is not found.
 */
public class ProductoNotFoundException extends RuntimeException {

    /**
     * Constructs a new ProductoNotFoundException with the specified detail message.
     *
     * @param message the detail message
     */
    public ProductoNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new ProductoNotFoundException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause of the exception
     */
    public ProductoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new ProductoNotFoundException with the specified cause.
     *
     * @param cause the cause of the exception
     */
    public ProductoNotFoundException(Throwable cause) {
        super(cause);
    }
}