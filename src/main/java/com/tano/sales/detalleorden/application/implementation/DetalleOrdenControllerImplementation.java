package com.tano.sales.detalleorden.application.implementation;

import com.tano.sales.detalleorden.application.definition.DetalleOrdenControllerDefinition;
import com.tano.sales.detalleorden.domain.ports.api.DetalleOrdenApiPort;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller implementation for DetalleOrden entity.
 * Delegates calls to DetalleOrdenApiPort service.
 */
@RestController
@RequestMapping("/detalleorden")
public class DetalleOrdenControllerImplementation implements DetalleOrdenControllerDefinition {

    private final DetalleOrdenApiPort detalleOrdenApiPort;

    public DetalleOrdenControllerImplementation(DetalleOrdenApiPort detalleOrdenApiPort) {
        this.detalleOrdenApiPort = detalleOrdenApiPort;
    }

    /**
     * Save a new DetalleOrden.
     * @param dto DetalleOrdenRequestDto with data to save
     * @return ResponseEntity with saved DetalleOrdenResponseDto
     */
    @Override
    @PostMapping
    public ResponseEntity<DetalleOrdenResponseDto> save(@RequestBody DetalleOrdenRequestDto dto) {
        return ResponseEntity.ok(detalleOrdenApiPort.save(dto));
    }

    /**
     * Update an existing DetalleOrden by id.
     * @param id Long identifier of DetalleOrden
     * @param dto DetalleOrdenRequestDto with updated data
     * @return ResponseEntity with updated DetalleOrdenResponseDto
     */
    @Override
    @PutMapping("/{id}")
    public ResponseEntity<DetalleOrdenResponseDto> update(@PathVariable Long id, @RequestBody DetalleOrdenRequestDto dto) {
        return ResponseEntity.ok(detalleOrdenApiPort.update(id, dto));
    }

    /**
     * Find DetalleOrden by id.
     * @param id Long identifier of DetalleOrden
     * @return ResponseEntity with DetalleOrdenProjection
     */
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<DetalleOrdenProjection> findById(@PathVariable Long id) {
        return ResponseEntity.ok(detalleOrdenApiPort.findById(id));
    }

    /**
     * Find all DetalleOrden entities.
     * @return ResponseEntity with list of DetalleOrdenProjection
     */
    @Override
    @GetMapping
    public ResponseEntity<List<DetalleOrdenProjection>> findAll() {
        return ResponseEntity.ok(detalleOrdenApiPort.findAll());
    }

    /**
     * Delete DetalleOrden by id.
     * @param id Long identifier of DetalleOrden
     * @return ResponseEntity with no content
     */
    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        detalleOrdenApiPort.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
