package controle;

import java.sql.Connection;
import java.util.ArrayList;

import modelo.hospedes;

public interface IHospedesDAO {
	
	public int inserirHopesdes(hospedes end);

	public ArrayList<hospedes> listarHopesdes(Connection conDB);

	public boolean atualizarHopesdes(hospedes end);

	public boolean removerHopesdes(hospedes end);

	public hospedes buscarHopesdesPorCPF(int cpf);

}
