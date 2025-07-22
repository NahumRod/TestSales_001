package com.tano.sales.detalleorden.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * Response DTO for DetalleOrden entity.
 * Represents the details of an order item including calculated subtotal.
 */
public class DetalleOrdenResponseDto {

    /**
     * Unique identifier of the order detail.
     */
    @NotNull
    public Long detalleId;

    /**
     * Identifier of the order this detail belongs to.
     */
    @NotNull
    public Long ordenId;

    /**
     * Identifier of the product in this order detail.
     */
    @NotNull
    public Long productoId;

    /**
     * Quantity of the product ordered. Must be greater than 0.
     */
    @NotNull
    @Positive
    public Integer cantidad;

    /**
     * Unit price of the product. Must be zero or positive.
     */
    @NotNull
    @Positive
    public BigDecimal precioUnitario;

    /**
     * Subtotal amount for this order detail (cantidad * precioUnitario).
     */
    @NotNull
    public BigDecimal subtotal;

    /**
     * User who created this order detail.
     */
    @NotNull
    @Size(max = 50)
    public String usuarioCreacion;

}