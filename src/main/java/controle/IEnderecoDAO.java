package controle;

import java.util.ArrayList;

import modelo.Endereco;

public interface IEnderecoDAO {
	
	public int inserirEndereco(Endereco end);

	public ArrayList<Endereco> listarEndereco();

	public int atualizarEndereco(Endereco end);

	public int removerEndereco(Endereco end);

	public Endereco buscarEnderecoPorCEP(int cep);
	
}
