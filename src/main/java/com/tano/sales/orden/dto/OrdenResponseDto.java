package com.tano.sales.orden.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Response DTO for Orden entity.
 * Represents the data returned for an Orden.
 */
public class OrdenResponseDto {

    /**
     * Unique identifier of the order.
     */
    @NotNull
    public Long ordenId;

    /**
     * Identifier of the client who placed the order.
     */
    @NotNull
    public Long clienteId;

    /**
     * Date when the order was placed.
     */
    @NotNull
    public LocalDate fechaOrden;

    /**
     * Current status of the order.
     * Allowed values: Pendiente, En Proceso, Enviado, Entregado, Cancelado
     */
    @NotNull
    @Size(max = 20)
    public String estado;

    /**
     * Total amount of the order.
     * Must be greater than or equal to 0.
     */
    @DecimalMin(value = "0.0", inclusive = true)
    public BigDecimal totalOrden;

    /**
     * Payment method used for the order.
     * Allowed values: Tarjeta, Transferencia, Efectivo, Crédito
     */
    @Size(max = 30)
    public String metodoPago;

    /**
     * Additional notes for the order.
     */
    public String notas;

    /**
     * User who created the order.
     */
    @NotNull
    @Size(max = 50)
    public String usuarioCreacion;

}