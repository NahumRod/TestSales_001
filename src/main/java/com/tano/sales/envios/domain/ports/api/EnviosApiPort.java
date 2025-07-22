package com.tano.sales.envios.domain.ports.api;

import com.tano.sales.envios.dto.EnviosRequestDto;
import com.tano.sales.envios.dto.EnviosResponseDto;
import com.tano.sales.envios.projection.EnviosProjection;
import java.util.List;

/**
 * API Port interface for Envios entity.
 * <p>
 * Defines the operations available for managing Envios.
 * This interface is used by the controller layer and implemented by the service layer.
 */
public interface EnviosApiPort {

    /**
     * Saves a new Envios using the provided DTO.
     *
     * @param dto the DTO containing the data for the new Envios
     * @return the saved Envios as a DTO
     */
    EnviosResponseDto save(EnviosRequestDto dto);

    /**
     * Updates an existing Envios with the provided DTO.
     *
     * @param id the ID of the Envios to update
     * @param dto the DTO containing the updated data for the Envios
     * @return the updated Envios as a DTO
     */
    EnviosResponseDto update(Long id, EnviosRequestDto dto);

    /**
     * Finds an Envios by its ID.
     *
     * @param id the ID of the Envios to find
     * @return the found Envios as a Projection
     */
    EnviosProjection findById(Long id);

    /**
     * Finds all Envios.
     *
     * @return a list of all Envios as Projections
     */
    List<EnviosProjection> findAll();

    /**
     * Deletes an Envios by its ID.
     *
     * @param id the ID of the Envios to delete
     */
    void deleteById(Long id);
}