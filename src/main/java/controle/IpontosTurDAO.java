package controle;

import java.util.ArrayList;

import modelo.PontosTur;

public interface IpontosTurDAO {
	public int inserirPontoTur(PontosTur end);

	public ArrayList<PontosTur> listarPontoTur();

	public int atualizarPontosTur(PontosTur end);

	public int removerPontosTur(PontosTur end);

	public PontosTur buscarPontoTurPorNome(String nomePontoTur);
}
