package controle;

import java.util.ArrayList;

import modelo.modeloQuarto;

public interface IModeloQuartoDAO {

	public int inserirModeloQuarto(modeloQuarto end);

	public ArrayList<modeloQuarto> listarModeloQuarto();

	public boolean atualizarModeloQuarto(modeloQuarto end);

	public boolean removerModeloQuarto(modeloQuarto end);

	public modeloQuarto buscarModeloQuartoPorNome(String nomeModelo);
}
