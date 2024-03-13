package controle;

import java.util.ArrayList;

import modelo.pontosTur;

public interface IpontosTurDAO {
	public int inserirPontoTur(pontosTur end);

	public ArrayList<pontosTur> listarPontoTur();

	public int atualizarPontosTur(pontosTur end);

	public int removerPontosTur(pontosTur end);

	public pontosTur buscarPontoTurPorNome(String nomePontoTur);
}
