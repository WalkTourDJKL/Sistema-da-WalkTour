package controle;

import java.util.ArrayList;

import modelo.hotel;

public interface IHotelDAO {
	public int inserirHotel(hotel end);

	public ArrayList<hotel> listarHotel();

	public int atualizarHotel(hotel end);

	public int removerHotel (hotel end);

	public hotel buscarHotelPorCidade(String cidade);

}
