package com.tano.sales.orden.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tano.sales.orden.domain.ports.spi.OrdenSpiPort;
import com.tano.sales.orden.infrastructure.adapters.OrdenSpiAdapter;
import com.tano.sales.orden.infrastructure.mappers.OrdenMapper;
import com.tano.sales.orden.infrastructure.repository.OrdenRepository;

/**
 * Configuration class for wiring Orden related beans.
 * Defines the OrdenSpiPort bean using OrdenSpiAdapter with required dependencies.
 */
@Configuration
public class OrdenConfig {

    @Bean
    public OrdenSpiPort ordenSpiPort(OrdenRepository ordenRepository, OrdenMapper ordenMapper) {
        return new OrdenSpiAdapter(ordenRepository, ordenMapper);
    }
}