package controle;

import java.util.ArrayList;

import modelo.modeloQuarto;

public interface IModeloQuartoDAO {

	public int inserirModeloQuarto(modeloQuarto end);

	public ArrayList<modeloQuarto> listarModeloQuarto();

	public int atualizarModeloQuarto(modeloQuarto end);

	public int removerModeloQuarto(modeloQuarto end);

	public modeloQuarto buscarModeloQuartoPorNome(String nomeModelo);
}
