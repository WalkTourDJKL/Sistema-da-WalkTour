package controle;
	
import java.util.ArrayList;

import modelo.reserva;

public interface IReservaDAO {
				
			public int inserirReserva(reserva end);

			public ArrayList<reserva> listarReservas();

			public int atualizarReserva(reserva end);

			public boolean removerReserva(reserva end);

			public reserva buscarReservaPorIdHospedagem(int idHospedagem);

}
