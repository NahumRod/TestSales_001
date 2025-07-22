package com.tano.sales.cliente.infrastructure.adapters;

import com.tano.sales.cliente.domain.ports.spi.ClienteSpiPort;
import com.tano.sales.cliente.dto.ClienteRequestDto;
import com.tano.sales.cliente.dto.ClienteResponseDto;
import com.tano.sales.cliente.infrastructure.entity.Cliente;
import com.tano.sales.cliente.infrastructure.exceptions.ClienteNotFoundException;
import com.tano.sales.cliente.infrastructure.mappers.ClienteMapper;
import com.tano.sales.cliente.infrastructure.projection.ClienteProjection;
import com.tano.sales.cliente.infrastructure.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * SPI Adapter implementation for Cliente entity.
 * Handles persistence operations using ClienteRepository and maps entities to DTOs and projections.
 */
public class ClienteSpiAdapter implements ClienteSpiPort {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    /**
     * Constructor injection of repository and mapper.
     *
     * @param clienteRepository repository for Cliente entity
     * @param clienteMapper mapper for Cliente entity and DTOs
     */
    public ClienteSpiAdapter(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    /**
     * Saves a new Cliente entity.
     *
     * @param dto ClienteRequestDto containing data to save
     * @return ClienteResponseDto with saved data
     */
    @Override
    @Transactional
    public ClienteResponseDto save(ClienteRequestDto dto) {
        Cliente entity = clienteMapper.toEntity(dto);
        Cliente saved = clienteRepository.save(entity);
        return clienteMapper.toResponseDto(saved);
    }

    /**
     * Updates an existing Cliente entity by id.
     *
     * @param id Long identifier of the Cliente
     * @param dto ClienteRequestDto containing updated data
     * @return ClienteResponseDto with updated data
     * @throws ClienteNotFoundException if Cliente with id not found
     */
    @Override
    @Transactional
    public ClienteResponseDto update(Long id, ClienteRequestDto dto) throws ClienteNotFoundException {
        if (!clienteRepository.existsById(id)) {
            throw new ClienteNotFoundException("Cliente not found with id: " + id);
        }
        Cliente entity = clienteMapper.toEntity(dto);
        entity.setClienteId(id);
        Cliente updated = clienteRepository.save(entity);
        return clienteMapper.toResponseDto(updated);
    }

    /**
     * Finds a ClienteProjection by id.
     *
     * @param id Long identifier of the Cliente
     * @return ClienteProjection projection of the Cliente
     * @throws ClienteNotFoundException if Cliente with id not found
     */
    @Override
    public ClienteProjection findById(Long id) throws ClienteNotFoundException {
        Optional<ClienteProjection> optionalProjection = clienteRepository.findProjectionById(id);
        return optionalProjection.orElseThrow(() -> new ClienteNotFoundException("Cliente not found with id: " + id));
    }

    /**
     * Finds all ClienteProjection.
     *
     * @return List of ClienteProjection
     */
    @Override
    public List<ClienteProjection> findAll() {
        return clienteRepository.findAllProjections();
    }

    /**
     * Deletes a Cliente by id.
     *
     * @param id Long identifier of the Cliente
     * @throws ClienteNotFoundException if Cliente with id not found
     */
    @Override
    @Transactional
    public void deleteById(Long id) throws ClienteNotFoundException {
        if (!clienteRepository.existsById(id)) {
            throw new ClienteNotFoundException("Cliente not found with id: " + id);
        }
        clienteRepository.deleteById(id);
    }
}