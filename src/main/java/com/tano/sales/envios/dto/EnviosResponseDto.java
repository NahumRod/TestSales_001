package com.tano.sales.envios.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Date;

/**
 * Response DTO for Envios entity.
 * Represents the data returned for a shipment.
 */
public class EnviosResponseDto {

    /**
     * Unique identifier of the shipment.
     */
    @NotNull
    public Long envioId;

    /**
     * Identifier of the related order.
     */
    @NotNull
    public Long ordenId;

    /**
     * Date when the shipment was sent.
     */
    public Date fechaEnvio;

    /**
     * Shipping address.
     */
    @NotNull
    @Size(max = 255)
    public String direccionEnvio;

    /**
     * City of the shipping address.
     */
    @Size(max = 100)
    public String ciudad;

    /**
     * Country of the shipping address.
     * Defaults to 'Argentina' if not specified.
     */
    @Size(max = 50)
    public String pais;

    /**
     * Postal code of the shipping address.
     */
    @Size(max = 10)
    public String codigoPostal;

    /**
     * Shipping company.
     */
    @Size(max = 50)
    public String empresaEnvio;

    /**
     * Status of the shipment.
     * Allowed values: 'Pendiente', 'En Camino', 'Entregado', 'Devuelto'.
     * Defaults to 'Pendiente'.
     */
    @Size(max = 20)
    public String estadoEnvio;

    /**
     * User who created the shipment record.
     */
    @NotNull
    @Size(max = 50)
    public String usuarioCreacion;

}