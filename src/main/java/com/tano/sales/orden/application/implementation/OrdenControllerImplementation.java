package com.tano.sales.orden.application.implementation;

import com.tano.sales.orden.application.definition.OrdenControllerDefinition;
import com.tano.sales.orden.domain.ports.api.OrdenApiPort;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller implementation for Orden entity.
 * Delegates calls to the OrdenApiPort service.
 */
@RestController
@RequestMapping("/ordenes")
public class OrdenControllerImplementation implements OrdenControllerDefinition {

    private final OrdenApiPort ordenApiPort;

    public OrdenControllerImplementation(OrdenApiPort ordenApiPort) {
        this.ordenApiPort = ordenApiPort;
    }

    /**
     * Save a new Orden.
     * @param dto OrdenRequestDto with data to save
     * @return ResponseEntity with saved OrdenResponseDto
     */
    @Override
    @PostMapping
    public ResponseEntity<OrdenResponseDto> save(@RequestBody OrdenRequestDto dto) {
        return ResponseEntity.ok(ordenApiPort.save(dto));
    }

    /**
     * Update an existing Orden by id.
     * @param id Long primary key of the Orden
     * @param dto OrdenRequestDto with updated data
     * @return ResponseEntity with updated OrdenResponseDto
     */
    @Override
    @PutMapping("/{id}")
    public ResponseEntity<OrdenResponseDto> update(@PathVariable Long id, @RequestBody OrdenRequestDto dto) {
        return ResponseEntity.ok(ordenApiPort.update(id, dto));
    }

    /**
     * Find an Orden by id.
     * @param id Long primary key of the Orden
     * @return ResponseEntity with OrdenProjection
     */
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<OrdenProjection> findById(@PathVariable Long id) {
        return ResponseEntity.ok(ordenApiPort.findById(id));
    }

    /**
     * Find all Orden entities.
     * @return ResponseEntity with list of OrdenProjection
     */
    @Override
    @GetMapping
    public ResponseEntity<List<OrdenProjection>> findAll() {
        return ResponseEntity.ok(ordenApiPort.findAll());
    }

    /**
     * Delete an Orden by id.
     * @param id Long primary key of the Orden
     * @return ResponseEntity with no content
     */
    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        ordenApiPort.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
