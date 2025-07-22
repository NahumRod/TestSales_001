package com.tano.sales.producto.projection;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Read-only projection interface for Producto entity.
 * Provides access to essential Producto fields for optimized database queries.
 */
public interface ProductoProjection {

    /**
     * Gets the unique identifier of the product.
     * @return the product ID
     */
    Long getProductoId();

    /**
     * Gets the name of the product.
     * @return the product name
     */
    String getNombre();

    /**
     * Gets the description of the product.
     * @return the product description
     */
    String getDescripcion();

    /**
     * Gets the unit price of the product.
     * @return the unit price
     */
    BigDecimal getPrecioUnitario();

    /**
     * Gets the category of the product.
     * @return the category
     */
    String getCategoria();

    /**
     * Gets the stock quantity available.
     * @return the stock quantity
     */
    Integer getStock();

    /**
     * Gets the status of the product (e.g., 'A' for active, 'I' for inactive).
     * @return the product status
     */
    String getEstado();

    /**
     * Gets the date when the product was added.
     * @return the creation date
     */
    Date getFechaAlta();

    /**
     * Gets the username of the creator of the product record.
     * @return the creator username
     */
    String getUsuarioCreacion();
}