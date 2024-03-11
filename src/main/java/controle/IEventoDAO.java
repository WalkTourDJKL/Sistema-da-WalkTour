package controle;

import java.util.ArrayList;

import modelo.evento;

public interface IEventoDAO {
	public int inserirEvento (evento end);

	public ArrayList<evento> listarEventos();

	public boolean atualizarEventos(evento end);

	public boolean removerEventos(evento end);

	public evento buscarEventoPorNome(String nomeEvento);

}
