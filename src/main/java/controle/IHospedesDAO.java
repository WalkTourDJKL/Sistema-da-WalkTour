package controle;

import java.util.ArrayList;

import modelo.hospedes;

public interface IHospedesDAO {
	
	public int inserirHopesdes(hospedes end);

	public ArrayList<hospedes> listarHopesdess();

	public boolean atualizarHopesdes(hospedes end);

	public boolean removerHopesdes(hospedes end);

	public hospedes buscarHopesdesPorCPF(int cpf);

}