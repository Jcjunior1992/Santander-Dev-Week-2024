package me.dio.ClientTest;

import me.dio.domain.model.Cliente;
import me.dio.domain.repository.ClienteRepository;
import me.dio.service.ClienteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteServiceImpl clienteService;

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
        when(clienteRepository.findAll()).thenReturn(Arrays.asList(cliente1, cliente2));

        List<Cliente> clientes = clienteService.listarClientes();
        assertEquals(2, clientes.size());
        verify(clienteRepository, times(1)).findAll();
    }

    @Test
    void buscarClientePorId() {
        when(clienteRepository.findById(cliente1.getId())).thenReturn(Optional.of(cliente1));

        Cliente cliente = clienteService.buscarClientePorId(cliente1.getId());
        assertEquals(cliente1.getNome(), cliente.getNome());
        verify(clienteRepository, times(1)).findById(cliente1.getId());
    }

    @Test
    void buscarClientePorIdNotFound() {
        when(clienteRepository.findById(any(UUID.class))).thenReturn(Optional.empty());

        Cliente cliente = clienteService.buscarClientePorId(UUID.randomUUID());
        assertNull(cliente);
        verify(clienteRepository, times(1)).findById(any(UUID.class));
    }

    @Test
    void buscarClientesPorNome() {
        when(clienteRepository.findByNomeContainingIgnoreCase(anyString())).thenReturn(Arrays.asList(cliente1));

        List<Cliente> clientes = clienteService.buscarClientesPorNome("Cliente Um");
        assertEquals(1, clientes.size());
        verify(clienteRepository, times(1)).findByNomeContainingIgnoreCase(anyString());
    }
}
