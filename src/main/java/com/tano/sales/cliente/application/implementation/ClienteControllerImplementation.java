package com.tano.sales.cliente.application.implementation;

import com.tano.sales.cliente.application.definition.ClienteControllerDefinition;
import com.tano.sales.cliente.domain.ports.api.ClienteApiPort;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementation of the ClienteControllerDefinition interface.
 * This controller handles HTTP requests for Cliente entity operations
 * and delegates the business logic to the ClienteApiPort service.
 */
@RestController
@RequestMapping("/clientes")
public class ClienteControllerImplementation implements ClienteControllerDefinition {

    private final ClienteApiPort clienteApiPort;

    /**
     * Constructor for ClienteControllerImplementation.
     * @param clienteApiPort the service port to delegate business logic
     */
    public ClienteControllerImplementation(ClienteApiPort clienteApiPort) {
        this.clienteApiPort = clienteApiPort;
    }

    /**
     * Saves a new Cliente.
     * @param dto the ClienteRequestDto containing data to save
     * @return ResponseEntity with the saved ClienteResponseDto
     */
    @Override
    @PostMapping
    public ResponseEntity<ClienteResponseDto> save(@RequestBody ClienteRequestDto dto) {
        return ResponseEntity.ok(clienteApiPort.save(dto));
    }

    /**
     * Updates an existing Cliente by id.
     * @param id the primary key of the Cliente to update
     * @param dto the ClienteRequestDto containing updated data
     * @return ResponseEntity with the updated ClienteResponseDto
     */
    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> update(@PathVariable Long id, @RequestBody ClienteRequestDto dto) {
        return ResponseEntity.ok(clienteApiPort.update(id, dto));
    }

    /**
     * Finds a Cliente by its id.
     * @param id the primary key of the Cliente
     * @return ResponseEntity with the ClienteProjection
     */
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ClienteProjection> findById(@PathVariable Long id) {
        return ResponseEntity.ok(clienteApiPort.findById(id));
    }

    /**
     * Retrieves all Clientes.
     * @return ResponseEntity with a list of ClienteProjection
     */
    @Override
    @GetMapping
    public ResponseEntity<java.util.List<ClienteProjection>> findAll() {
        return ResponseEntity.ok(clienteApiPort.findAll());
    }

    /**
     * Deletes a Cliente by its id.
     * @param id the primary key of the Cliente to delete
     * @return ResponseEntity with no content
     */
    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        clienteApiPort.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}