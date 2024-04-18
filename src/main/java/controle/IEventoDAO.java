package controle;

import java.util.ArrayList;

import modelo.Evento;

public interface IEventoDAO {
	public int inserirEvento (Evento end);

	public ArrayList<Evento> listarEventos();

	public int atualizarEventos(Evento end);

	public int removerEventos(Evento end);

	public Evento buscarEventoPorNome(String nomeEvento);

}
