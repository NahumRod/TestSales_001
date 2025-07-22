package com.tano.sales.producto.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.DecimalMax;

import java.math.BigDecimal;

/**
 * Request DTO for Producto entity.
 * Represents the data required to create or update a Producto.
 */
public class ProductoRequestDto {

    /**
     * Name of the product.
     * Cannot be null and maximum length is 150 characters.
     */
    @NotNull
    @Size(max = 150)
    public String nombre;

    /**
     * Description of the product.
     * Optional field.
     */
    public String descripcion;

    /**
     * Unit price of the product.
     * Must be positive and not null.
     */
    @NotNull
    @DecimalMin(value = "0.01", inclusive = true)
    public BigDecimal precioUnitario;

    /**
     * Category of the product.
     * Optional field with maximum length 50.
     */
    @Size(max = 50)
    public String categoria;

    /**
     * Stock quantity.
     * Must be zero or positive.
     * Optional, defaults to 0 if not provided.
     */
    @Min(0)
    public Integer stock;

    /**
     * Status of the product.
     * Allowed values: 'A' (Active), 'I' (Inactive).
     * Optional, defaults to 'A' if not provided.
     */
    @Size(min = 1, max = 1)
    @NotNull
    public String estado;

    /**
     * Creation user.
     * Cannot be null and maximum length is 50 characters.
     */
    @NotNull
    @Size(max = 50)
    public String usuarioCreacion;

}