package com.tano.sales.orden.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.tano.sales.orden.infrastructure.entity.Cliente;

/**
 * Entity representing an order (ordenes) in the system.
 */
@Entity
@Table(name = "ordenes")
public class Orden {

    /**
     * Primary key: Unique identifier for the order.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orden_id")
    private Long ordenId;

    /**
     * The client who placed the order.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    /**
     * Date when the order was placed.
     * Defaults to current system date.
     */
    @Column(name = "fecha_orden", nullable = false)
    private LocalDate fechaOrden;

    /**
     * Status of the order.
     * Allowed values: Pendiente, En Proceso, Enviado, Entregado, Cancelado
     * Defaults to 'Pendiente'.
     */
    @Column(name = "estado", length = 20, nullable = false)
    private String estado = "Pendiente";

    /**
     * Total amount of the order.
     * Must be greater or equal to zero.
     * Defaults to 0.
     */
    @Column(name = "total_orden", precision = 12, scale = 2, nullable = false)
    private BigDecimal totalOrden = BigDecimal.ZERO;

    /**
     * Payment method used for the order.
     * Allowed values: Tarjeta, Transferencia, Efectivo, Crédito
     */
    @Column(name = "metodo_pago", length = 30)
    private String metodoPago;

    /**
     * Additional notes for the order.
     */
    @Column(name = "notas", columnDefinition = "CLOB")
    private String notas;

    /**
     * User who created the order.
     */
    @Column(name = "usuario_creacion", length = 50, nullable = false)
    private String usuarioCreacion;

    // Getters and setters

    public Long getOrdenId() {
        return ordenId;
    }

    public void setOrdenId(Long ordenId) {
        this.ordenId = ordenId;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(LocalDate fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getTotalOrden() {
        return totalOrden;
    }

    public void setTotalOrden(BigDecimal totalOrden) {
        this.totalOrden = totalOrden;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }
}