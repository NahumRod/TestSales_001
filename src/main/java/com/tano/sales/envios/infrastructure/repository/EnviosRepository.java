package com.tano.sales.envios.infrastructure.repository;

import com.tano.sales.envios.infrastructure.entity.Envios;
import com.tano.sales.envios.projection.EnviosProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Envios entity.
 * Provides CRUD operations and custom projection queries.
 */
public interface EnviosRepository extends JpaRepository<Envios, Long> {

    /**
     * Find a projection of the Envios entity by its ID.
     *
     * @param id the ID of the Envios entity
     * @return an Optional containing the projected Envios entity, or empty if not found
     */
    Optional<EnviosProjection> findProjectionById(Long id);

    /**
     * Find all projections of the Envios entity.
     *
     * @return a list of all projected Envios entities
     */
    List<EnviosProjection> findAllProjections();
}