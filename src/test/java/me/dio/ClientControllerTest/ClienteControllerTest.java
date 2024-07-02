package me.dio.ClientControllerTest;

import me.dio.controller.ClienteController;
import me.dio.domain.model.Cliente;
import me.dio.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ClienteControllerTest {

    @Mock
    private ClienteService clienteService;

    @InjectMocks
    private ClienteController clienteController;

    private Cliente cliente1;
    private Cliente cliente2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cliente1 = new Cliente();
        cliente1.setId(UUID.randomUUID());
        cliente1.setNome("Cliente Um");
        cliente1.setEmail("cliente1@example.com");

        cliente2 = new Cliente();
        cliente2.setId(UUID.randomUUID());
        cliente2.setNome("Cliente Dois");
        cliente2.setEmail("cliente2@example.com");
    }

    @Test
    void listarClientes() {
        when(clienteService.listarClientes()).thenReturn(Arrays.asList(cliente1, cliente2));

        ResponseEntity<List<Cliente>> response = clienteController.listarClientes();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
        verify(clienteService, times(1)).listarClientes();
    }

    @Test
    void buscarClientePorId() {
        when(clienteService.buscarClientePorId(cliente1.getId())).thenReturn(cliente1);

        ResponseEntity<Cliente> response = clienteController.buscarClientePorId(cliente1.getId());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cliente1.getNome(), response.getBody().getNome());
        verify(clienteService, times(1)).buscarClientePorId(cliente1.getId());
    }

    @Test
    void buscarClientePorIdNotFound() {
        when(clienteService.buscarClientePorId(any(UUID.class))).thenReturn(null);

        ResponseEntity<Cliente> response = clienteController.buscarClientePorId(UUID.randomUUID());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(clienteService, times(1)).buscarClientePorId(any(UUID.class));
    }

    @Test
    void buscarClientesPorNome() {
        when(clienteService.buscarClientesPorNome(anyString())).thenReturn(Arrays.asList(cliente1));

        ResponseEntity<List<Cliente>> response = clienteController.buscarClientesPorNome("Cliente Um");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        verify(clienteService, times(1)).buscarClientesPorNome(anyString());
    }
}