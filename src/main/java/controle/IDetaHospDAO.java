package controle;

import java.sql.Connection;
import java.util.ArrayList;

import modelo.DetalhesHospedagem;
import modelo.Hospedes;

public interface IDetaHospDAO {
	
	public int inserirDetalhes(DetalhesHospedagem end);

	public ArrayList<DetalhesHospedagem> listarDetalhes();

	public boolean atualizarDetalhes(DetalhesHospedagem end);

	public int removerDetalhes(DetalhesHospedagem end);

	public DetalhesHospedagem buscarDetalhesPorId(int idDetalheHospedagem);

}
