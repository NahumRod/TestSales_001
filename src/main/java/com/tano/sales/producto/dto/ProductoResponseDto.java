package com.tano.sales.producto.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Response DTO for Producto entity.
 * Represents the data returned for a product.
 */
public class ProductoResponseDto {

    /**
     * Unique identifier of the product.
     */
    @NotNull
    public Long productoId;

    /**
     * Name of the product.
     */
    @NotNull
    @Size(max = 150)
    public String nombre;

    /**
     * Description of the product.
     */
    public String descripcion;

    /**
     * Unit price of the product. Must be positive.
     */
    @NotNull
    @Positive
    public BigDecimal precioUnitario;

    /**
     * Category of the product.
     */
    @Size(max = 50)
    public String categoria;

    /**
     * Stock quantity of the product. Must be zero or positive.
     */
    @NotNull
    @Positive
    public Integer stock;

    /**
     * Status of the product. 'A' for active, 'I' for inactive.
     */
    @Size(min = 1, max = 1)
    public String estado;

    /**
     * Date when the product was added.
     */
    public Date fechaAlta;

    /**
     * User who created the product.
     */
    @NotNull
    @Size(max = 50)
    public String usuarioCreacion;

}