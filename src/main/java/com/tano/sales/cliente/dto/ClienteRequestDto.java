package com.tano.sales.cliente.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Request DTO for Cliente entity.
 * Represents the data required to create or update a Cliente.
 */
public class ClienteRequestDto {

    /**
     * First name of the client.
     * Cannot be null and max length is 100 characters.
     */
    @NotNull
    @Size(max = 100)
    public String nombre;

    /**
     * Last name of the client.
     * Cannot be null and max length is 100 characters.
     */
    @NotNull
    @Size(max = 100)
    public String apellido;

    /**
     * Gender of the client.
     * Must be either 'M' or 'F' if provided.
     */
    @Pattern(regexp = "[MF]")
    public String genero;

    /**
     * Birth date of the client.
     * Cannot be null.
     */
    @NotNull
    public LocalDate fechaNacimiento;

    /**
     * Email address of the client.
     * Cannot be null, must be a valid email format, max length 255.
     */
    @NotNull
    @Email
    @Size(max = 255)
    public String email;

    /**
     * Phone number of the client.
     * Optional, max length 20.
     */
    @Size(max = 20)
    public String telefono;

    /**
     * Address of the client.
     * Optional, max length 255.
     */
    @Size(max = 255)
    public String direccion;

    /**
     * City of the client.
     * Optional, max length 100.
     */
    @Size(max = 100)
    public String ciudad;

    /**
     * Postal code of the client.
     * Optional, max length 10.
     */
    @Size(max = 10)
    public String codigoPostal;

    /**
     * Country of the client.
     * Optional, max length 50, defaults to 'Argentina' if not provided.
     */
    @Size(max = 50)
    public String pais;

    /**
     * Marital status of the client.
     * Optional, must be one of 'Soltero', 'Casado', 'Divorciado', 'Viudo' if provided.
     */
    @Pattern(regexp = "Soltero|Casado|Divorciado|Viudo")
    public String estadoCivil;

    /**
     * Annual income of the client.
     * Optional, must be >= 0 if provided.
     */
    @DecimalMin(value = "0", inclusive = true)
    public BigDecimal ingresosAnuales;

    /**
     * Active status of the client.
     * Optional, must be 'S' or 'N' if provided.
     */
    @Pattern(regexp = "[SN]")
    public String activo;

    /**
     * Client type.
     * Optional, must be one of 'Minorista', 'Mayorista', 'Corporativo' if provided.
     */
    @Pattern(regexp = "Minorista|Mayorista|Corporativo")
    public String tipoCliente;

    /**
     * Comments about the client.
     * Optional, no length restriction.
     */
    public String comentarios;

    /**
     * Loyalty points of the client.
     * Optional, must be >= 0 if provided.
     */
    @Min(0)
    public Integer puntosFidelidad;

    /**
     * Risk level of the client.
     * Optional, must be one of 'Alto', 'Medio', 'Bajo' if provided.
     */
    @Pattern(regexp = "Alto|Medio|Bajo")
    public String nivelRiesgo;

    /**
     * User who created the client record.
     * Cannot be null, max length 50.
     */
    @NotNull
    @Size(max = 50)
    public String usuarioCreacion;

}