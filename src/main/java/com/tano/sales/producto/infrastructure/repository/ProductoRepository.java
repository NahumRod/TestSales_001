package com.tano.sales.producto.infrastructure.repository;

import com.tano.sales.producto.infrastructure.entity.Producto;
import com.tano.sales.producto.projection.ProductoProjection;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the Producto entity.
 *
 * Provides CRUD operations and custom projection queries.
 */
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    /**
     * Find a projection of the Producto entity by its ID.
     *
     * @param id the ID of the Producto
     * @return an Optional containing the projected Producto, or empty if not found
     */
    Optional<ProductoProjection> findProjectionById(Long id);

    /**
     * Find all projections of the Producto entity.
     *
     * @return a list of all projected Producto entities
     */
    List<ProductoProjection> findAllProjections();
}