package controle;

import java.util.ArrayList;

import modelo.Hotel;

public interface IHotelDAO {
	public int inserirHotel(Hotel end);

	public ArrayList<Hotel> listarHotel();

	public int atualizarHotel(Hotel end);

	public int removerHotel (Hotel end);

	public Hotel buscarHotelPorCidade(String cidade);

}
