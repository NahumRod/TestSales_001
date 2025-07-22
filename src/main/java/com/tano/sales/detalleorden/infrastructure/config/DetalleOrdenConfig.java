package com.tano.sales.detalleorden.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tano.sales.detalleorden.domain.ports.spi.DetalleOrdenSpiPort;
import com.tano.sales.detalleorden.infrastructure.adapters.DetalleOrdenSpiAdapter;
import com.tano.sales.detalleorden.infrastructure.mappers.DetalleOrdenMapper;
import com.tano.sales.detalleorden.infrastructure.repository.DetalleOrdenRepository;

/**
 * Configuration class for DetalleOrden beans.
 *
 * Wires together the DetalleOrdenSpiPort implementation with required dependencies.
 */
@Configuration
public class DetalleOrdenConfig {

    @Bean
    public DetalleOrdenSpiPort detalleOrdenSpiPort(
            DetalleOrdenRepository detalleOrdenRepository,
            DetalleOrdenMapper detalleOrdenMapper) {
        return new DetalleOrdenSpiAdapter(detalleOrdenRepository, detalleOrdenMapper);
    }
}