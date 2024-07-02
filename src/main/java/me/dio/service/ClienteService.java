package me.dio.service;

import me.dio.domain.model.Cliente;
import java.util.List;
import java.util.UUID;

public interface ClienteService {
    List<Cliente> listarClientes();
    Cliente buscarClientePorId(UUID id);
    List<Cliente> buscarClientesPorNome(String nome);
}
