package com.tano.sales.orden.domain.ports.api;

import com.tano.sales.orden.dto.OrdenRequestDto;
import com.tano.sales.orden.dto.OrdenResponseDto;
import com.tano.sales.orden.projection.OrdenProjection;
import java.util.List;

/**
 * API Port interface for Orden entity.
 * <p>
 * Defines the operations available for Orden that are exposed to the application layer,
 * implemented by the service layer and used by controllers.
 */
public interface OrdenApiPort {

    /**
     * Saves a new Orden using the provided DTO.
     *
     * @param dto the DTO containing the data for the new Orden
     * @return the saved Orden as a DTO
     */
    OrdenResponseDto save(OrdenRequestDto dto);

    /**
     * Updates an existing Orden with the provided DTO.
     *
     * @param id the ID of the Orden to update
     * @param dto the DTO containing the updated data for the Orden
     * @return the updated Orden as a DTO
     */
    OrdenResponseDto update(Long id, OrdenRequestDto dto);

    /**
     * Finds an Orden by its ID.
     *
     * @param id the ID of the Orden to find
     * @return the found Orden as a Projection
     */
    OrdenProjection findById(Long id);

    /**
     * Finds all Orden entities.
     *
     * @return a list of all Orden entities as Projections
     */
    List<OrdenProjection> findAll();

    /**
     * Deletes an Orden by its ID.
     *
     * @param id the ID of the Orden to delete
     */
    void deleteById(Long id);
}