package com.tano.sales.envios.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tano.sales.envios.domain.ports.spi.EnviosSpiPort;
import com.tano.sales.envios.infrastructure.adapters.EnviosSpiAdapter;
import com.tano.sales.envios.infrastructure.mappers.EnviosMapper;
import com.tano.sales.envios.infrastructure.repository.EnviosRepository;

/**
 * Configuration class for Envios module.
 *
 * It defines the beans required for wiring EnviosSpiPort implementation
 * using EnviosSpiAdapter with its dependencies.
 */
@Configuration
public class EnviosConfig {

    @Bean
    public EnviosSpiPort enviosSpiPort(EnviosRepository enviosRepository, EnviosMapper enviosMapper) {
        return new EnviosSpiAdapter(enviosRepository, enviosMapper);
    }
}