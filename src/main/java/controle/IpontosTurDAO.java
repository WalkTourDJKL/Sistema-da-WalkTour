package controle;

import java.util.ArrayList;

import modelo.pontosTur;

public interface IpontosTurDAO {
	public int inserirPontoTur(pontosTur end);

	public ArrayList<pontosTur> listarPontoTur();

	public boolean atualizarPontosTur(pontosTur end);

	public boolean removerPontosTur(pontosTur end);

	public pontosTur buscarPontoTurPorNome(String nomePontoTur);
}
