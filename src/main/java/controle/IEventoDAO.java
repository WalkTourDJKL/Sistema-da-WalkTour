package controle;

import java.util.ArrayList;

import modelo.evento;

public interface IEventoDAO {
	public int inserirEvento (evento end);

	public ArrayList<evento> listarEventos();

	public int atualizarEventos(evento end);

	public int removerEventos(evento end);

	public evento buscarEventoPorNome(String nomeEvento);

}
