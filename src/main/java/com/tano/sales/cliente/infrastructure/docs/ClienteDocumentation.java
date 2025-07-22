package com.tano.sales.cliente.infrastructure.docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.*;
import com.tano.sales.cliente.dto.ClienteRequestDto;
import com.tano.sales.cliente.dto.ClienteResponseDto;
import java.util.List;

/**
 * Documentation class for Cliente REST API endpoints.
 * Provides OpenAPI annotations for controller methods.
 */
@RestController
@RequestMapping("/clientes")
public class ClienteDocumentation {

    /**
     * Retrieves a list of all clientes.
     *
     * @return List of ClienteResponseDto
     */
    @GetMapping
    @Operation(summary = "Get all clientes")
    public List<ClienteResponseDto> getAllClientes() {
        return null; // Documentation placeholder
    }

    /**
     * Retrieves a cliente by its ID.
     *
     * @param id Cliente identifier
     * @return ClienteResponseDto
     */
    @GetMapping("/{id}")
    @Operation(summary = "Get cliente by ID")
    public ClienteResponseDto getClienteById(@PathVariable Long id) {
        return null; // Documentation placeholder
    }

    /**
     * Creates a new cliente.
     *
     * @param clienteRequestDto Cliente data for creation
     * @return Created ClienteResponseDto
     */
    @PostMapping
    @Operation(summary = "Create a new cliente")
    public ClienteResponseDto createCliente(@RequestBody ClienteRequestDto clienteRequestDto) {
        return null; // Documentation placeholder
    }

    /**
     * Updates an existing cliente.
     *
     * @param id Cliente identifier
     * @param clienteRequestDto Cliente data for update
     * @return Updated ClienteResponseDto
     */
    @PutMapping("/{id}")
    @Operation(summary = "Update an existing cliente")
    public ClienteResponseDto updateCliente(@PathVariable Long id, @RequestBody ClienteRequestDto clienteRequestDto) {
        return null; // Documentation placeholder
    }

    /**
     * Deletes a cliente by its ID.
     *
     * @param id Cliente identifier
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a cliente by ID")
    public void deleteCliente(@PathVariable Long id) {
        // Documentation placeholder
    }
}
