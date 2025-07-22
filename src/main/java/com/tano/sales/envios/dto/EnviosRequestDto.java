package com.tano.sales.envios.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotBlank;

/**
 * Request DTO for Envios entity.
 * Represents the data required to create or update an Envios record.
 */
public class EnviosRequestDto {

    /**
     * The ID of the order associated with the shipment.
     * Cannot be null.
     */
    @NotNull
    public Long ordenId;

    /**
     * The date of the shipment.
     * Optional field.
     */
    public java.util.Date fechaEnvio;

    /**
     * The shipping address.
     * Cannot be null or blank.
     * Maximum length 255 characters.
     */
    @NotBlank
    @Size(max = 255)
    public String direccionEnvio;

    /**
     * The city of the shipping address.
     * Optional field.
     * Maximum length 100 characters.
     */
    @Size(max = 100)
    public String ciudad;

    /**
     * The country of the shipping address.
     * Optional field.
     * Maximum length 50 characters.
     * Defaults to 'Argentina' if not provided.
     */
    @Size(max = 50)
    public String pais;

    /**
     * The postal code of the shipping address.
     * Optional field.
     * Maximum length 10 characters.
     */
    @Size(max = 10)
    public String codigoPostal;

    /**
     * The shipping company.
     * Optional field.
     * Maximum length 50 characters.
     */
    @Size(max = 50)
    public String empresaEnvio;

    /**
     * The shipping status.
     * Optional field.
     * Maximum length 20 characters.
     * Allowed values: 'Pendiente', 'En Camino', 'Entregado', 'Devuelto'.
     */
    @Size(max = 20)
    @Pattern(regexp = "Pendiente|En Camino|Entregado|Devuelto")
    public String estadoEnvio;

    /**
     * The user who created the shipment record.
     * Cannot be null or blank.
     * Maximum length 50 characters.
     */
    @NotBlank
    @Size(max = 50)
    public String usuarioCreacion;

}