package com.tano.sales.detalleorden.domain.ports.api;

import com.tano.sales.detalleorden.dto.DetalleOrdenRequestDto;
import com.tano.sales.detalleorden.dto.DetalleOrdenResponseDto;
import com.tano.sales.detalleorden.projection.DetalleOrdenProjection;
import java.util.List;

/**
 * API Port interface for DetalleOrden.
 * <p>
 * Defines the operations available for DetalleOrden used by the controller
 * and implemented by the service layer.
 */
public interface DetalleOrdenApiPort {

    /**
     * Saves a new DetalleOrden using the provided DTO.
     *
     * @param dto the DTO containing the data for the new DetalleOrden
     * @return the saved DetalleOrden as a DTO
     */
    DetalleOrdenResponseDto save(DetalleOrdenRequestDto dto);

    /**
     * Updates an existing DetalleOrden with the provided DTO.
     *
     * @param id the ID of the DetalleOrden to update
     * @param dto the DTO containing the updated data for the DetalleOrden
     * @return the updated DetalleOrden as a DTO
     */
    DetalleOrdenResponseDto update(Long id, DetalleOrdenRequestDto dto);

    /**
     * Finds a DetalleOrden by its ID.
     *
     * @param id the ID of the DetalleOrden to find
     * @return the found DetalleOrden as a Projection
     */
    DetalleOrdenProjection findById(Long id);

    /**
     * Finds all DetalleOrden entities.
     *
     * @return a list of all DetalleOrden as Projections
     */
    List<DetalleOrdenProjection> findAll();

    /**
     * Deletes a DetalleOrden by its ID.
     *
     * @param id the ID of the DetalleOrden to delete
     */
    void deleteById(Long id);
}