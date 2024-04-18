package controle;

import java.sql.Connection;
import java.util.ArrayList;

import modelo.Hospedes;

public interface IHospedesDAO {
	
	public int inserirHopesdes(Hospedes end);

	public ArrayList<Hospedes> listarHopesdes();

	public boolean atualizarHopesdes(Hospedes end);

	public int removerHopesdes(Hospedes end);

	public Hospedes buscarHopesdesPorCPF(int cpf);

}
