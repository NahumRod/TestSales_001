package com.tano.sales.cliente.projection;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Projection interface for read-only access to Cliente entity fields.
 * Includes only primitive and enum fields necessary for read operations.
 */
public interface ClienteProjection {

    /**
     * Gets the unique identifier of the cliente.
     * @return cliente ID
     */
    Long getClienteId();

    /**
     * Gets the first name of the cliente.
     * @return nombre
     */
    String getNombre();

    /**
     * Gets the last name of the cliente.
     * @return apellido
     */
    String getApellido();

    /**
     * Gets the gender of the cliente.
     * @return genero (M or F)
     */
    String getGenero();

    /**
     * Gets the birth date of the cliente.
     * @return fechaNacimiento
     */
    Date getFechaNacimiento();

    /**
     * Gets the email address of the cliente.
     * @return email
     */
    String getEmail();

    /**
     * Gets the phone number of the cliente.
     * @return telefono
     */
    String getTelefono();

    /**
     * Gets the address of the cliente.
     * @return direccion
     */
    String getDireccion();

    /**
     * Gets the city of the cliente.
     * @return ciudad
     */
    String getCiudad();

    /**
     * Gets the postal code of the cliente.
     * @return codigoPostal
     */
    String getCodigoPostal();

    /**
     * Gets the country of the cliente.
     * @return pais
     */
    String getPais();

    /**
     * Gets the marital status of the cliente.
     * @return estadoCivil
     */
    String getEstadoCivil();

    /**
     * Gets the annual income of the cliente.
     * @return ingresosAnuales
     */
    BigDecimal getIngresosAnuales();

    /**
     * Gets the registration date of the cliente.
     * @return fechaRegistro
     */
    Date getFechaRegistro();

    /**
     * Gets the active status of the cliente.
     * @return activo (S or N)
     */
    String getActivo();

    /**
     * Gets the type of the cliente.
     * @return tipoCliente
     */
    String getTipoCliente();

    /**
     * Gets the loyalty points of the cliente.
     * @return puntosFidelidad
     */
    Integer getPuntosFidelidad();

    /**
     * Gets the risk level of the cliente.
     * @return nivelRiesgo
     */
    String getNivelRiesgo();

    /**
     * Gets the user who created the cliente record.
     * @return usuarioCreacion
     */
    String getUsuarioCreacion();
}