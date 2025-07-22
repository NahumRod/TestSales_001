package com.tano.sales.detalleorden.application.definition;

import com.tano.sales.detalleorden.dto.DetalleOrdenRequestDto;
import com.tano.sales.detalleorden.dto.DetalleOrdenResponseDto;
import com.tano.sales.detalleorden.projection.DetalleOrdenProjection;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * REST API definition for DetalleOrden entity.
 *
 * Provides endpoint signatures for CRUD operations.
 * Implemented by the controller implementation class.
 */
public interface DetalleOrdenControllerDefinition {

    /**
     * Creates a new DetalleOrden.
     *
     * @param dto the DetalleOrden data transfer object
     * @return the created DetalleOrden response DTO wrapped in ResponseEntity
     */
    @PostMapping("/")
    ResponseEntity<DetalleOrdenResponseDto> save(@RequestBody DetalleOrdenRequestDto dto);

    /**
     * Updates an existing DetalleOrden by its ID.
     *
     * @param id  the ID of the DetalleOrden to update
     * @param dto the DetalleOrden data transfer object with updated data
     * @return the updated DetalleOrden response DTO wrapped in ResponseEntity
     */
    @PutMapping("/{id}")
    ResponseEntity<DetalleOrdenResponseDto> update(@PathVariable Long id, @RequestBody DetalleOrdenRequestDto dto);

    /**
     * Finds a DetalleOrden by its ID.
     *
     * @param id the ID of the DetalleOrden
     * @return the DetalleOrden projection wrapped in ResponseEntity
     */
    @GetMapping("/{id}")
    ResponseEntity<DetalleOrdenProjection> findById(@PathVariable Long id);

    /**
     * Retrieves all DetalleOrden records.
     *
     * @return list of DetalleOrden projections wrapped in ResponseEntity
     */
    @GetMapping("/")
    ResponseEntity<java.util.List<DetalleOrdenProjection>> findAll();

    /**
     * Deletes a DetalleOrden by its ID.
     *
     * @param id the ID of the DetalleOrden to delete
     * @return ResponseEntity with no content
     */
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable Long id);
}
