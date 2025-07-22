package com.tano.sales.cliente.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Lob;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Entity representing a Cliente (Customer) in the system.
 */
@Entity
@Table(name = "clientes")
public class Cliente {

    /** Primary key: Unique identifier for the cliente. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Long clienteId;

    /** First name of the cliente. */
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    /** Last name of the cliente. */
    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    /** Gender of the cliente, either 'M' or 'F'. */
    @Column(name = "genero", length = 1)
    private String genero;

    /** Birth date of the cliente. */
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    /** Unique email address of the cliente. */
    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;

    /** Phone number of the cliente. */
    @Column(name = "telefono", length = 20)
    private String telefono;

    /** Address of the cliente. */
    @Column(name = "direccion", length = 255)
    private String direccion;

    /** City where the cliente lives. */
    @Column(name = "ciudad", length = 100)
    private String ciudad;

    /** Postal code of the cliente's address. */
    @Column(name = "codigo_postal", length = 10)
    private String codigoPostal;

    /** Country of the cliente, defaults to 'Argentina'. */
    @Column(name = "pais", length = 50)
    private String pais = "Argentina";

    /** Marital status of the cliente. */
    @Column(name = "estado_civil", length = 20)
    private String estadoCivil;

    /** Annual income of the cliente, must be non-negative. */
    @Column(name = "ingresos_anuales", precision = 12, scale = 2)
    private BigDecimal ingresosAnuales;

    /** Registration date of the cliente, defaults to current date. */
    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    /** Active status of the cliente, 'S' for active, 'N' for inactive. */
    @Column(name = "activo", length = 1)
    private String activo = "S";

    /** Type of cliente: Minorista, Mayorista, Corporativo. */
    @Column(name = "tipo_cliente", length = 20)
    private String tipoCliente;

    /** Additional comments about the cliente. */
    @Lob
    @Column(name = "comentarios")
    private String comentarios;

    /** Loyalty points of the cliente, non-negative. */
    @Column(name = "puntos_fidelidad")
    private Integer puntosFidelidad = 0;

    /** Risk level of the cliente: Alto, Medio, Bajo. */
    @Column(name = "nivel_riesgo", length = 10)
    private String nivelRiesgo;

    /** User who created the cliente record. */
    @Column(name = "usuario_creacion", nullable = false, length = 50)
    private String usuarioCreacion;

    // Getters and setters

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public BigDecimal getIngresosAnuales() {
        return ingresosAnuales;
    }

    public void setIngresosAnuales(BigDecimal ingresosAnuales) {
        this.ingresosAnuales = ingresosAnuales;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Integer getPuntosFidelidad() {
        return puntosFidelidad;
    }

    public void setPuntosFidelidad(Integer puntosFidelidad) {
        this.puntosFidelidad = puntosFidelidad;
    }

    public String getNivelRiesgo() {
        return nivelRiesgo;
    }

    public void setNivelRiesgo(String nivelRiesgo) {
        this.nivelRiesgo = nivelRiesgo;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }
}