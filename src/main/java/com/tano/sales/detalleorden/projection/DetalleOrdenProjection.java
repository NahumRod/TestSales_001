package com.tano.sales.detalleorden.projection;

/**
 * Projection interface for read-only access to DetalleOrden data.
 * Includes only primitive fields necessary for read operations.
 */
public interface DetalleOrdenProjection {

    /**
     * Returns the unique identifier of the detalle orden.
     * @return detalleId
     */
    Long getDetalleId();

    /**
     * Returns the identifier of the associated orden.
     * @return ordenId
     */
    Long getOrdenId();

    /**
     * Returns the identifier of the associated producto.
     * @return productoId
     */
    Long getProductoId();

    /**
     * Returns the quantity of the producto in the detalle orden.
     * @return cantidad
     */
    Integer getCantidad();

    /**
     * Returns the unit price of the producto.
     * @return precioUnitario
     */
    java.math.BigDecimal getPrecioUnitario();

    /**
     * Returns the subtotal calculated as cantidad * precioUnitario.
     * @return subtotal
     */
    java.math.BigDecimal getSubtotal();

    /**
     * Returns the user who created the detalle orden.
     * @return usuarioCreacion
     */
    String getUsuarioCreacion();
}