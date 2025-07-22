package com.tano.sales.cliente.application.definition;

import com.tano.sales.cliente.dto.ClienteRequestDto;
import com.tano.sales.cliente.dto.ClienteResponseDto;
import com.tano.sales.cliente.projection.ClienteProjection;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Defines the REST API endpoints for Cliente entity.
 * Implemented by the ClienteControllerImplementation class.
 * Ensures consistent API contract for Cliente operations.
 */
public interface ClienteControllerDefinition {

    /**
     * Creates a new Cliente.
     *
     * @param dto the ClienteRequestDto containing the data to create
     * @return ResponseEntity containing the created ClienteResponseDto
     */
    @PostMapping("/")
    ResponseEntity<ClienteResponseDto> save(@RequestBody ClienteRequestDto dto);

    /**
     * Updates an existing Cliente by ID.
     *
     * @param id the ID of the Cliente to update
     * @param dto the ClienteRequestDto containing updated data
     * @return ResponseEntity containing the updated ClienteResponseDto
     */
    @PutMapping("/{id}")
    ResponseEntity<ClienteResponseDto> update(@PathVariable Long id, @RequestBody ClienteRequestDto dto);

    /**
     * Finds a Cliente by its ID.
     *
     * @param id the ID of the Cliente to find
     * @return ResponseEntity containing the ClienteProjection
     */
    @GetMapping("/{id}")
    ResponseEntity<ClienteProjection> findById(@PathVariable Long id);

    /**
     * Retrieves all Clientes.
     *
     * @return ResponseEntity containing a list of ClienteProjection
     */
    @GetMapping("/")
    ResponseEntity<java.util.List<ClienteProjection>> findAll();

    /**
     * Deletes a Cliente by its ID.
     *
     * @param id the ID of the Cliente to delete
     * @return ResponseEntity with no content
     */
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable Long id);
}