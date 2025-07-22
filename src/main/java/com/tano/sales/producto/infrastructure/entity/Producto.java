package com.tano.sales.producto.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Entity class representing a Producto.
 */
@Entity
@Table(name = "productos")
public class Producto {

    /**
     * Primary key: producto_id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_id", nullable = false, updatable = false)
    private Long productoId;

    /**
     * Nombre of the product.
     */
    @Column(name = "nombre", length = 150, nullable = false)
    private String nombre;

    /**
     * Descripcion of the product.
     */
    @Column(name = "descripcion", columnDefinition = "CLOB")
    private String descripcion;

    /**
     * Precio unitario of the product. Must be greater than 0.
     */
    @Column(name = "precio_unitario", precision = 10, scale = 2, nullable = false)
    private BigDecimal precioUnitario;

    /**
     * Categoria of the product.
     */
    @Column(name = "categoria", length = 50)
    private String categoria;

    /**
     * Stock available. Defaults to 0 and must be >= 0.
     */
    @Column(name = "stock", precision = 8)
    private Integer stock = 0;

    /**
     * Estado of the product. 'A' for active, 'I' for inactive. Defaults to 'A'.
     */
    @Column(name = "estado", length = 1)
    private String estado = "A";

    /**
     * Fecha de alta (creation date). Defaults to SYSDATE.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_alta")
    private Date fechaAlta;

    /**
     * Usuario who created the product.
     */
    @Column(name = "usuario_creacion", length = 50, nullable = false)
    private String usuarioCreacion;

    // Getters and setters

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }
}