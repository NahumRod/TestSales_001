package com.tano.sales.detalleorden.infrastructure.repository;

import com.tano.sales.detalleorden.infrastructure.entity.DetalleOrden;
import com.tano.sales.detalleorden.projection.DetalleOrdenProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the DetalleOrden entity.
 * Provides methods to perform CRUD operations and fetch projections.
 */
public interface DetalleOrdenRepository extends JpaRepository<DetalleOrden, Long> {

    /**
     * Find a projection of DetalleOrden by its ID.
     *
     * @param id the ID of the DetalleOrden
     * @return an Optional containing the projected DetalleOrden, or empty if not found
     */
    Optional<DetalleOrdenProjection> findProjectionById(Long id);

    /**
     * Find all projections of DetalleOrden.
     *
     * @return a list of all projected DetalleOrden entities
     */
    List<DetalleOrdenProjection> findAllProjections();
}