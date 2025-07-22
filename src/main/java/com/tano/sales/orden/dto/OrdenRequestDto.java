package com.tano.sales.orden.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Request DTO for creating or updating an Orden.
 */
public class OrdenRequestDto {

    /**
     * Identifier of the client placing the order.
     */
    @NotNull(message = "clienteId must not be null")
    public Long clienteId;

    /**
     * Date of the order. Defaults to current date if not provided.
     */
    @NotNull(message = "fechaOrden must not be null")
    public LocalDate fechaOrden;

    /**
     * Status of the order. Allowed values: Pendiente, En Proceso, Enviado, Entregado, Cancelado.
     */
    @NotBlank(message = "estado must not be blank")
    @Size(max = 20, message = "estado must be at most 20 characters")
    @Pattern(regexp = "Pendiente|En Proceso|Enviado|Entregado|Cancelado", message = "estado must be one of Pendiente, En Proceso, Enviado, Entregado, Cancelado")
    public String estado;

    /**
     * Total amount of the order. Must be zero or positive.
     */
    @NotNull(message = "totalOrden must not be null")
    @DecimalMin(value = "0.0", inclusive = true, message = "totalOrden must be zero or positive")
    public BigDecimal totalOrden;

    /**
     * Payment method. Allowed values: Tarjeta, Transferencia, Efectivo, Crédito.
     */
    @Size(max = 30, message = "metodoPago must be at most 30 characters")
    @Pattern(regexp = "Tarjeta|Transferencia|Efectivo|Crédito", message = "metodoPago must be one of Tarjeta, Transferencia, Efectivo, Crédito")
    public String metodoPago;

    /**
     * Additional notes for the order.
     */
    public String notas;

    /**
     * User who created the order.
     */
    @NotBlank(message = "usuarioCreacion must not be blank")
    @Size(max = 50, message = "usuarioCreacion must be at most 50 characters")
    public String usuarioCreacion;

}