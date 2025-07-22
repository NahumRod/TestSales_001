package com.tano.sales.envios.application.definition;

import com.tano.sales.envios.dto.EnviosRequestDto;
import com.tano.sales.envios.dto.EnviosResponseDto;
import com.tano.sales.envios.projection.EnviosProjection;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Defines the REST API endpoints for Envios entity.
 * Implemented by the EnviosControllerImplementation class.
 */
public interface EnviosControllerDefinition {

    /**
     * Saves a new Envios entity.
     *
     * @param dto the EnviosRequestDto containing data to save
     * @return ResponseEntity containing the saved EnviosResponseDto
     */
    @PostMapping("/")
    ResponseEntity<EnviosResponseDto> save(@RequestBody EnviosRequestDto dto);

    /**
     * Updates an existing Envios entity by its ID.
     *
     * @param id the ID of the Envios entity to update
     * @param dto the EnviosRequestDto containing updated data
     * @return ResponseEntity containing the updated EnviosResponseDto
     */
    @PutMapping("/{id}")
    ResponseEntity<EnviosResponseDto> update(@PathVariable Long id, @RequestBody EnviosRequestDto dto);

    /**
     * Finds an Envios entity by its ID.
     *
     * @param id the ID of the Envios entity
     * @return ResponseEntity containing the EnviosProjection
     */
    @GetMapping("/{id}")
    ResponseEntity<EnviosProjection> findById(@PathVariable Long id);

    /**
     * Retrieves all Envios entities.
     *
     * @return ResponseEntity containing a list of EnviosProjection
     */
    @GetMapping("/")
    ResponseEntity<java.util.List<EnviosProjection>> findAll();

    /**
     * Deletes an Envios entity by its ID.
     *
     * @param id the ID of the Envios entity to delete
     * @return ResponseEntity with no content
     */
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable Long id);
}