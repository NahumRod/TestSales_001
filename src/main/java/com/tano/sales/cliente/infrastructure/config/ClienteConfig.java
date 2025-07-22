package com.tano.sales.cliente.infrastructure.config;

import com.tano.sales.cliente.domain.ports.spi.ClienteSpiPort;
import com.tano.sales.cliente.infrastructure.adapters.ClienteSpiAdapter;
import com.tano.sales.cliente.infrastructure.mappers.ClienteMapper;
import com.tano.sales.cliente.infrastructure.repository.ClienteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for Cliente related beans.
 * Wires the ClienteSpiAdapter as the implementation of ClienteSpiPort,
 * injecting the required ClienteMapper and ClienteRepository dependencies.
 */
@Configuration
public class ClienteConfig {

    @Bean
    public ClienteSpiPort clienteSpiPort(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        return new ClienteSpiAdapter(clienteRepository, clienteMapper);
    }
}