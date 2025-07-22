package com.tano.sales.cliente.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Response DTO for Cliente entity.
 * Contains client details returned by the API.
 */
public class ClienteResponseDto {

    /**
     * Unique identifier of the client.
     */
    @NotNull
    public Long clienteId;

    /**
     * First name of the client.
     */
    @NotNull
    @Size(max = 100)
    public String nombre;

    /**
     * Last name of the client.
     */
    @NotNull
    @Size(max = 100)
    public String apellido;

    /**
     * Gender of the client. Allowed values: 'M', 'F'.
     */
    @Size(min = 1, max = 1)
    public String genero;

    /**
     * Birth date of the client.
     */
    @NotNull
    public LocalDate fechaNacimiento;

    /**
     * Email address of the client.
     */
    @NotNull
    @Size(max = 255)
    public String email;

    /**
     * Phone number of the client.
     */
    @Size(max = 20)
    public String telefono;

    /**
     * Address of the client.
     */
    @Size(max = 255)
    public String direccion;

    /**
     * City of the client.
     */
    @Size(max = 100)
    public String ciudad;

    /**
     * Postal code of the client.
     */
    @Size(max = 10)
    public String codigoPostal;

    /**
     * Country of the client. Defaults to 'Argentina'.
     */
    @Size(max = 50)
    public String pais;

    /**
     * Marital status of the client. Allowed values: 'Soltero', 'Casado', 'Divorciado', 'Viudo'.
     */
    @Size(max = 20)
    public String estadoCivil;

    /**
     * Annual income of the client. Must be non-negative.
     */
    @PositiveOrZero
    public BigDecimal ingresosAnuales;

    /**
     * Registration date of the client.
     */
    public LocalDate fechaRegistro;

    /**
     * Active status of the client. Allowed values: 'S', 'N'.
     */
    @Size(min = 1, max = 1)
    public String activo;

    /**
     * Client type. Allowed values: 'Minorista', 'Mayorista', 'Corporativo'.
     */
    @Size(max = 20)
    public String tipoCliente;

    /**
     * Comments about the client.
     */
    public String comentarios;

    /**
     * Loyalty points of the client. Must be non-negative.
     */
    @PositiveOrZero
    public Integer puntosFidelidad;

    /**
     * Risk level of the client. Allowed values: 'Alto', 'Medio', 'Bajo'.
     */
    @Size(max = 10)
    public String nivelRiesgo;

    /**
     * User who created the client record.
     */
    @NotNull
    @Size(max = 50)
    public String usuarioCreacion;

}