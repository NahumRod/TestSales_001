package com.tano.sales.envios.domain.ports.spi;

import com.tano.sales.envios.dto.EnviosRequestDto;
import com.tano.sales.envios.dto.EnviosResponseDto;
import com.tano.sales.envios.projection.EnviosProjection;
import com.tano.sales.envios.infrastructure.exceptions.EnviosNotFoundException;

import java.util.List;

public interface EnviosSpiPort {

    EnviosResponseDto save(EnviosRequestDto dto);

    EnviosResponseDto update(Long id, EnviosRequestDto dto) throws EnviosNotFoundException;

    EnviosProjection findById(Long id) throws EnviosNotFoundException;

    List<EnviosProjection> findAll();

    void deleteById(Long id) throws EnviosNotFoundException;

}