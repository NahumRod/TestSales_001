package com.tano.sales.orden.infrastructure.repository;

import com.tano.sales.orden.infrastructure.entity.Orden;
import com.tano.sales.orden.projection.OrdenProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Orden entity.
 * Provides CRUD operations and custom projection queries.
 */
public interface OrdenRepository extends JpaRepository<Orden, Long> {

    /**
     * Find a projection of the Orden entity by its ID.
     *
     * @param id the ID of the Orden
     * @return an Optional containing the projected Orden, or empty if not found
     */
    Optional<OrdenProjection> findProjectionById(Long id);

    /**
     * Find all projections of the Orden entity.
     *
     * @return a list of all projected Orden entities
     */
    List<OrdenProjection> findAllProjections();
}