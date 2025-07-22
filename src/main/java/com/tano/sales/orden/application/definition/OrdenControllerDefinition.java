package com.tano.sales.orden.application.definition;

import com.tano.sales.orden.dto.OrdenRequestDto;
import com.tano.sales.orden.dto.OrdenResponseDto;
import com.tano.sales.orden.projection.OrdenProjection;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * REST API definition for Orden entity.
 * <p>
 * This interface defines the contract for the Orden controller,
 * specifying all REST endpoints and their signatures.
 * It must be implemented by the OrdenControllerImplementation class.
 */
public interface OrdenControllerDefinition {

    /**
     * Creates a new Orden.
     *
     * @param dto the Orden data transfer object containing the details to create
     * @return ResponseEntity containing the created OrdenResponseDto
     */
    @PostMapping("/")
    ResponseEntity<OrdenResponseDto> save(@RequestBody OrdenRequestDto dto);

    /**
     * Updates an existing Orden identified by id.
     *
     * @param id  the primary key of the Orden to update
     * @param dto the Orden data transfer object containing updated details
     * @return ResponseEntity containing the updated OrdenResponseDto
     */
    @PutMapping("/{id}")
    ResponseEntity<OrdenResponseDto> update(@PathVariable Long id, @RequestBody OrdenRequestDto dto);

    /**
     * Retrieves an Orden by its id.
     *
     * @param id the primary key of the Orden to retrieve
     * @return ResponseEntity containing the OrdenProjection
     */
    @GetMapping("/{id}")
    ResponseEntity<OrdenProjection> findById(@PathVariable Long id);

    /**
     * Retrieves all Orden entities.
     *
     * @return ResponseEntity containing a list of OrdenProjection
     */
    @GetMapping("/")
    ResponseEntity<java.util.List<OrdenProjection>> findAll();

    /**
     * Deletes an Orden by its id.
     *
     * @param id the primary key of the Orden to delete
     * @return ResponseEntity with no content
     */
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable Long id);
}
