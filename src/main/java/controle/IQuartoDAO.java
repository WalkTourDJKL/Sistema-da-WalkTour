package controle;

import java.util.ArrayList;

import modelo.quarto;

public interface IQuartoDAO {
			
		public int inserirQuarto(quarto end);

		public ArrayList<quarto> listarQuartos();

		public int atualizarQuarto(quarto end);

		public int removerQuarto(quarto end);

		public quarto buscarQuartoPorNúmero(int numQuarto);

}
