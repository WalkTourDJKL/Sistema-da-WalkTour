package controle;

import java.util.ArrayList;

import modelo.cliente;

public interface IClienteDAO {
	
	public int inserirCliente(cliente end);

	public ArrayList<cliente> listarClientes();

	public boolean atualizarCliente(cliente end);

	public boolean removerCliente(cliente end);

	public cliente buscarClientePorCPF(int cpf);

}
