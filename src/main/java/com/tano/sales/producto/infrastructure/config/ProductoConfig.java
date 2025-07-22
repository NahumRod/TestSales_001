package com.tano.sales.producto.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tano.sales.producto.domain.ports.spi.ProductoSpiPort;
import com.tano.sales.producto.infrastructure.adapters.ProductoSpiAdapter;
import com.tano.sales.producto.infrastructure.mappers.ProductoMapper;
import com.tano.sales.producto.infrastructure.repository.ProductoRepository;

/**
 * Configuration class for Producto related beans.
 *
 * Wires the ProductoSpiPort implementation using ProductoSpiAdapter,
 * injecting the required ProductoMapper and ProductoRepository.
 */
@Configuration
public class ProductoConfig {

    @Bean
    public ProductoSpiPort productoSpiPort(
            ProductoRepository productoRepository,
            ProductoMapper productoMapper) {
        return new ProductoSpiAdapter(productoRepository, productoMapper);
    }
}