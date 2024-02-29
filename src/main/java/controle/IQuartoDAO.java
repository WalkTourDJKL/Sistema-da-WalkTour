package controle;

import java.util.ArrayList;

import modelo.quarto;

public interface IQuartoDAO {
			
		public int inserirQuarto(quarto end);

		public ArrayList<quarto> listarQuartos();

		public boolean atualizarQuarto(quarto end);

		public boolean removerQuarto(quarto end);

		public quarto buscarQuartoPorNúmero(int numQuarto);

}
