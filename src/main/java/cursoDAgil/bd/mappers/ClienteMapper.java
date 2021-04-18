package cursoDAgil.bd.mappers;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Cliente;

public interface ClienteMapper {
	List<Cliente> listarTodosClientes();
	Integer nuevoCliente(Cliente cliente);
	Integer editarCliente(Cliente cliente);
	Cliente obtenerClientePorId(Map<String, Integer> mapCliente);
	Integer eliminarCliente(Map<String, Integer> mapCliente);
}

