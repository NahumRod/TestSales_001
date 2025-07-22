package com.tano.sales.detalleorden.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import com.tano.sales.ordenes.infrastructure.entity.Ordenes;
import com.tano.sales.productos.infrastructure.entity.Productos;

/**
 * Entity representing the detalle_orden table.
 * Stores details of each order including product, quantity, and pricing.
 */
@Entity
@Table(name = "detalle_orden")
public class DetalleOrden {

    /** Primary key: detalle_id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detalle_id", nullable = false, updatable = false)
    private Long detalleId;

    /** Foreign key to ordenes table */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "orden_id", nullable = false)
    private Ordenes orden;

    /** Foreign key to productos table */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "producto_id", nullable = false)
    private Productos producto;

    /** Quantity of product ordered, must be greater than 0 */
    @Column(name = "cantidad", nullable = false, precision = 5)
    private Integer cantidad;

    /** Unit price of the product, must be >= 0 */
    @Column(name = "precio_unitario", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioUnitario;

    /** Subtotal calculated as cantidad * precio_unitario, virtual column */
    @Column(name = "subtotal", precision = 12, scale = 2, insertable = false, updatable = false)
    private BigDecimal subtotal;

    /** User who created the record */
    @Column(name = "usuario_creacion", nullable = false, length = 50)
    private String usuarioCreacion;

    // Getters and setters

    public Long getDetalleId() {
        return detalleId;
    }

    public void setDetalleId(Long detalleId) {
        this.detalleId = detalleId;
    }

    public Ordenes getOrden() {
        return orden;
    }

    public void setOrden(Ordenes orden) {
        this.orden = orden;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }
}