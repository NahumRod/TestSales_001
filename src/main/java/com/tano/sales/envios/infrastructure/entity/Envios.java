package com.tano.sales.envios.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import com.tano.sales.ordenes.infrastructure.entity.Ordenes;

/**
 * Entity class representing the envios table.
 */
@Entity
@Table(name = "envios")
public class Envios {

    /**
     * Primary key: envio_id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "envio_id")
    private Long envioId;

    /**
     * Foreign key to ordenes table: orden_id
     */
    @ManyToOne
    @JoinColumn(name = "orden_id", nullable = false)
    private Ordenes orden;

    /**
     * Date of shipment
     */
    @Column(name = "fecha_envio")
    private LocalDate fechaEnvio;

    /**
     * Shipping address
     */
    @Column(name = "direccion_envio", nullable = false, length = 255)
    private String direccionEnvio;

    /**
     * City
     */
    @Column(name = "ciudad", length = 100)
    private String ciudad;

    /**
     * Country, default 'Argentina'
     */
    @Column(name = "pais", length = 50)
    private String pais = "Argentina";

    /**
     * Postal code
     */
    @Column(name = "codigo_postal", length = 10)
    private String codigoPostal;

    /**
     * Shipping company
     */
    @Column(name = "empresa_envio", length = 50)
    private String empresaEnvio;

    /**
     * Shipping status, default 'Pendiente'
     * Allowed values: 'Pendiente', 'En Camino', 'Entregado', 'Devuelto'
     */
    @Column(name = "estado_envio", length = 20)
    private String estadoEnvio = "Pendiente";

    /**
     * User who created the record
     */
    @Column(name = "usuario_creacion", nullable = false, length = 50)
    private String usuarioCreacion;

    // Getters and setters

    public Long getEnvioId() {
        return envioId;
    }

    public void setEnvioId(Long envioId) {
        this.envioId = envioId;
    }

    public Ordenes getOrden() {
        return orden;
    }

    public void setOrden(Ordenes orden) {
        this.orden = orden;
    }

    public LocalDate getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDate fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getEmpresaEnvio() {
        return empresaEnvio;
    }

    public void setEmpresaEnvio(String empresaEnvio) {
        this.empresaEnvio = empresaEnvio;
    }

    public String getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(String estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }
}