package com.tano.sales.detalleorden.test;

import com.tano.sales.detalleorden.domain.service.DetalleOrdenServiceImpl;
import com.tano.sales.detalleorden.domain.ports.spi.DetalleOrdenSpiPort;
import com.tano.sales.detalleorden.domain.ports.api.DetalleOrdenApiPort;
import com.tano.sales.detalleorden.dto.DetalleOrdenRequestDto;
import com.tano.sales.detalleorden.dto.DetalleOrdenResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Unit tests for {@link DetalleOrdenServiceImpl}.
 *
 * Tests cover save, update, findById, findAll, and deleteById methods.
 */
@ExtendWith(SpringExtension.class)
class DetalleOrdenServiceTest {

    @Mock
    private DetalleOrdenSpiPort detalleOrdenSpiPort;

    @InjectMocks
    private DetalleOrdenServiceImpl detalleOrdenService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test saving a DetalleOrden.
     */
    @Test
    @DisplayName("Save DetalleOrden")
    void testSaveDetalleOrden() {
        DetalleOrdenRequestDto requestDto = new DetalleOrdenRequestDto();
        // minimal setup for requestDto if needed

        DetalleOrdenResponseDto responseDto = new DetalleOrdenResponseDto();
        when(detalleOrdenSpiPort.save(any())).thenReturn(responseDto);

        DetalleOrdenResponseDto result = detalleOrdenService.save(requestDto);

        assertNotNull(result);
        verify(detalleOrdenSpiPort, times(1)).save(any());
    }

    /**
     * Test updating a DetalleOrden.
     */
    @Test
    @DisplayName("Update DetalleOrden")
    void testUpdateDetalleOrden() {
        Long id = 1L;
        DetalleOrdenRequestDto requestDto = new DetalleOrdenRequestDto();

        DetalleOrdenResponseDto responseDto = new DetalleOrdenResponseDto();
        when(detalleOrdenSpiPort.update(eq(id), any())).thenReturn(responseDto);

        DetalleOrdenResponseDto result = detalleOrdenService.update(id, requestDto);

        assertNotNull(result);
        verify(detalleOrdenSpiPort, times(1)).update(eq(id), any());
    }

    /**
     * Test finding a DetalleOrden by id.
     */
    @Test
    @DisplayName("Find DetalleOrden by ID")
    void testFindById() {
        Long id = 1L;
        DetalleOrdenResponseDto responseDto = new DetalleOrdenResponseDto();
        when(detalleOrdenSpiPort.findById(id)).thenReturn(Optional.of(responseDto));

        Optional<DetalleOrdenResponseDto> result = detalleOrdenService.findById(id);

        assertTrue(result.isPresent());
        verify(detalleOrdenSpiPort, times(1)).findById(id);
    }

    /**
     * Test finding all DetalleOrden.
     */
    @Test
    @DisplayName("Find all DetalleOrden")
    void testFindAll() {
        List<DetalleOrdenResponseDto> list = Collections.singletonList(new DetalleOrdenResponseDto());
        when(detalleOrdenSpiPort.findAll()).thenReturn(list);

        List<DetalleOrdenResponseDto> result = detalleOrdenService.findAll();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        verify(detalleOrdenSpiPort, times(1)).findAll();
    }

    /**
     * Test deleting a DetalleOrden by id.
     */
    @Test
    @DisplayName("Delete DetalleOrden by ID")
    void testDeleteById() {
        Long id = 1L;
        doNothing().when(detalleOrdenSpiPort).deleteById(id);

        detalleOrdenService.deleteById(id);

        verify(detalleOrdenSpiPort, times(1)).deleteById(id);
    }
}