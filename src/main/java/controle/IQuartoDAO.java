package controle;

import java.util.ArrayList;

import modelo.Quarto;

public interface IQuartoDAO {
			
		public int inserirQuarto(Quarto end);

		public ArrayList<Quarto> listarQuartos();

		public int atualizarQuarto(Quarto end);

		public int removerQuarto(Quarto end);

		public Quarto buscarQuartoPorNúmero(int numQuarto);

}
