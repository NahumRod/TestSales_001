package com.tano.sales.envios.application.implementation;

import com.tano.sales.envios.application.definition.EnviosControllerDefinition;
import com.tano.sales.envios.domain.ports.api.EnviosApiPort;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Implementation of EnviosControllerDefinition that delegates calls to EnviosApiPort.
 * Handles HTTP requests for Envios entity.
 */
@RestController
@RequestMapping("/envios")
public class EnviosControllerImplementation implements EnviosControllerDefinition {

    private final EnviosApiPort enviosApiPort;

    public EnviosControllerImplementation(EnviosApiPort enviosApiPort) {
        this.enviosApiPort = enviosApiPort;
    }

    /**
     * Save a new Envios entity.
     * @param dto EnviosRequestDto containing data to save
     * @return ResponseEntity with EnviosResponseDto
     */
    @Override
    @PostMapping
    public ResponseEntity<EnviosResponseDto> save(@RequestBody EnviosRequestDto dto) {
        return ResponseEntity.ok(enviosApiPort.save(dto));
    }

    /**
     * Update an existing Envios entity by id.
     * @param id Long primary key of the Envios entity
     * @param dto EnviosRequestDto containing updated data
     * @return ResponseEntity with EnviosResponseDto
     */
    @Override
    @PutMapping("/{id}")
    public ResponseEntity<EnviosResponseDto> update(@PathVariable Long id, @RequestBody EnviosRequestDto dto) {
        return ResponseEntity.ok(enviosApiPort.update(id, dto));
    }

    /**
     * Find an Envios entity by id.
     * @param id Long primary key of the Envios entity
     * @return ResponseEntity with EnviosProjection
     */
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<EnviosProjection> findById(@PathVariable Long id) {
        return ResponseEntity.ok(enviosApiPort.findById(id));
    }

    /**
     * Find all Envios entities.
     * @return ResponseEntity with list of EnviosProjection
     */
    @Override
    @GetMapping
    public ResponseEntity<List<EnviosProjection>> findAll() {
        return ResponseEntity.ok(enviosApiPort.findAll());
    }

    /**
     * Delete an Envios entity by id.
     * @param id Long primary key of the Envios entity
     * @return ResponseEntity with no content
     */
    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        enviosApiPort.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
