package com.tano.sales.orden.projection;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Read-only projection interface for Orden entity.
 * Provides only necessary fields for read operations.
 */
public interface OrdenProjection {

    /**
     * Gets the unique identifier of the order.
     * @return the order ID
     */
    Long getOrdenId();

    /**
     * Gets the identifier of the client who placed the order.
     * @return the client ID
     */
    Long getClienteId();

    /**
     * Gets the date when the order was placed.
     * @return the order date
     */
    Date getFechaOrden();

    /**
     * Gets the current status of the order.
     * @return the order status
     */
    String getEstado();

    /**
     * Gets the total amount of the order.
     * @return the total order amount
     */
    BigDecimal getTotalOrden();

    /**
     * Gets the payment method used for the order.
     * @return the payment method
     */
    String getMetodoPago();

    /**
     * Gets any notes associated with the order.
     * @return the notes
     */
    String getNotas();

    /**
     * Gets the username of the user who created the order.
     * @return the username of the creator
     */
    String getUsuarioCreacion();
}