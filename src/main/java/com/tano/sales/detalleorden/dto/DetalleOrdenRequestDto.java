package com.tano.sales.detalleorden.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * Request DTO for DetalleOrden entity.
 * Represents the data required to create or update a DetalleOrden.
 */
public class DetalleOrdenRequestDto {

    /**
     * Identifier of the order.
     * Cannot be null.
     */
    @NotNull
    public Long ordenId;

    /**
     * Identifier of the product.
     * Cannot be null.
     */
    @NotNull
    public Long productoId;

    /**
     * Quantity of the product.
     * Must be positive and not null.
     */
    @NotNull
    @Positive
    public Integer cantidad;

    /**
     * Unit price of the product.
     * Must be zero or positive and not null.
     */
    @NotNull
    @DecimalMin(value = "0.00", inclusive = true)
    public BigDecimal precioUnitario;

    /**
     * User who creates the record.
     * Cannot be null and maximum length is 50 characters.
     */
    @NotNull
    @Size(max = 50)
    public String usuarioCreacion;

}