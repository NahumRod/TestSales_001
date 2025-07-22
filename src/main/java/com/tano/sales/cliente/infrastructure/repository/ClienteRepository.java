package com.tano.sales.cliente.infrastructure.repository;

import com.tano.sales.cliente.infrastructure.entity.Cliente;
import com.tano.sales.cliente.projection.ClienteProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Cliente entity.
 * Provides methods to perform CRUD operations and to retrieve projections.
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    /**
     * Find a projection of the Cliente entity by its ID.
     *
     * @param id the ID of the Cliente
     * @return an Optional containing the projected Cliente, or empty if not found
     */
    Optional<ClienteProjection> findProjectionById(Long id);

    /**
     * Find all projections of the Cliente entity.
     *
     * @return a list of all projected Clientes
     */
    List<ClienteProjection> findAllProjections();
}