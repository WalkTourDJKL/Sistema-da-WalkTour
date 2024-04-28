package controle;

import java.util.ArrayList;

import modelo.ModeloQuarto;

public interface IModeloQuartoDAO {

	public int inserirModeloQuarto(ModeloQuarto end);

	public ArrayList<ModeloQuarto> listarModeloQuarto();

	public boolean atualizarModeloQuarto(ModeloQuarto end);

	public int removerModeloQuarto(ModeloQuarto end);

	public ModeloQuarto buscarModeloQuartoPorNome(String nomeModelo);
}
