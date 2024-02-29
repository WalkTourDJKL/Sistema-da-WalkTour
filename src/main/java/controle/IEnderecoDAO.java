package controle;

import java.util.ArrayList;

import modelo.endereco;

public interface IEnderecoDAO {
	
	public int inserirEndereco(endereco end);

	public ArrayList<endereco> listarEndereco();

	public boolean atualizarEndereco(endereco end);

	public boolean removerEndereco(endereco end);

	public endereco buscarEnderecoPorCEP(int cep);
	
}
