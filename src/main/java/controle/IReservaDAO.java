package controle;
	
import java.util.ArrayList;

import modelo.Reserva;

public interface IReservaDAO {
				
			public int inserirReserva(Reserva end);

			public ArrayList<Reserva> listarReservas();

			public int atualizarReserva(Reserva end);

			public int removerReserva(Reserva end);

			public Reserva buscarReservaPorIdHospedagem(int idHospedagem);

}
