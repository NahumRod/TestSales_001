package com.tano.sales.cliente.domain.ports.api;

import com.tano.sales.cliente.dto.ClienteRequestDto;
import com.tano.sales.cliente.dto.ClienteResponseDto;
import com.tano.sales.cliente.projection.ClienteProjection;
import java.util.List;

/**
 * API Port interface for Cliente entity.
 * <p>
 * Defines the operations available for managing Clientes.
 * Implemented by the service layer and used by the controller.
 */
public interface ClienteApiPort {

    /**
     * Saves a new Cliente using the provided DTO.
     *
     * @param dto the DTO containing the data for the new Cliente
     * @return the saved Cliente as a DTO
     */
    ClienteResponseDto save(ClienteRequestDto dto);

    /**
     * Updates an existing Cliente with the provided DTO.
     *
     * @param id the ID of the Cliente to update
     * @param dto the DTO containing the updated data for the Cliente
     * @return the updated Cliente as a DTO
     */
    ClienteResponseDto update(Long id, ClienteRequestDto dto);

    /**
     * Finds a Cliente by its ID.
     *
     * @param id the ID of the Cliente to find
     * @return the found Cliente as a Projection
     */
    ClienteProjection findById(Long id);

    /**
     * Finds all Clientes.
     *
     * @return a list of all Clientes as Projections
     */
    List<ClienteProjection> findAll();

    /**
     * Deletes a Cliente by its ID.
     *
     * @param id the ID of the Cliente to delete
     */
    void deleteById(Long id);
}