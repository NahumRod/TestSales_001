package com.tano.sales.envios.projection;

import java.util.Date;

/**
 * Projection interface for read-only access to Envios entity data.
 * Includes only fields necessary for read operations.
 */
public interface EnviosProjection {

    /**
     * Gets the unique identifier of the envio.
     * @return envio ID
     */
    Long getEnvioId();

    /**
     * Gets the identifier of the associated orden.
     * @return orden ID
     */
    Long getOrdenId();

    /**
     * Gets the date when the envio was sent.
     * @return envio date
     */
    Date getFechaEnvio();

    /**
     * Gets the shipping address.
     * @return shipping address
     */
    String getDireccionEnvio();

    /**
     * Gets the city of the shipping address.
     * @return city
     */
    String getCiudad();

    /**
     * Gets the country of the shipping address.
     * @return country
     */
    String getPais();

    /**
     * Gets the postal code of the shipping address.
     * @return postal code
     */
    String getCodigoPostal();

    /**
     * Gets the shipping company.
     * @return shipping company
     */
    String getEmpresaEnvio();

    /**
     * Gets the current status of the envio.
     * @return envio status
     */
    String getEstadoEnvio();

    /**
     * Gets the user who created the envio record.
     * @return user creation
     */
    String getUsuarioCreacion();
}