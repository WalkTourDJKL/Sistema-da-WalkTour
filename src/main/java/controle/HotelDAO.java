package controle;

import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.util.ArrayList; 
import java.sql.Date; 
import modelo.Hotel;

public class HotelDAO implements IHotelDAO {
	
	private static HotelDAO instancia;
	
	private HotelDAO() {
		
	}
	
	public static HotelDAO getInstancia() {
		if(instancia == null) {
			instancia = new HotelDAO();
		}
		return instancia;
	}
	

	public int inserirHotel(Hotel end) {
		String SQL = "INSERT INTO hotel(id_hospedagem, formapag, datain, dataout, preco) VALUES (?,?,?,?,?)";
		
		Conexao con = Conexao.getConexao();
		Connection conDB = con.conectar();
		
		
		try {
			PreparedStatement ps = conDB.prepareStatement(SQL);
			
			ps.setInt(1, end.getIdHospedagem());
			ps.setString(2, end.getFormaPag());
			ps.setDate(3, end.getDataIn());
			ps.setDate(4, end.getDataOut());
			ps.setFloat(5, end.getPreco());

			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}	
		
		return 0;
	}

	public ArrayList<Hotel> listarHotel() {
		ArrayList<Hotel> hotel = new ArrayList<Hotel>();
		
        String SQL = "SELECT * FROM hotel";
		
		Conexao con = Conexao.getConexao();
		Connection conDB = con.conectar();

		try {
			PreparedStatement ps = conDB.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Hotel end = new Hotel();
				
				Integer idHospedagem = rs.getInt("id_hospedagem");
				String formaPag = rs.getString("formapag");
				Date dataIn = rs.getDate("datain");
				Date dataOut = rs.getDate("dataout");
				Float preco = rs.getFloat("preco");
				
				end.setIdHospedagem(idHospedagem);
				end.setFormaPag(formaPag);
				end.setDataIn(dataIn);
				end.setDataOut(dataOut);
				end.setPreco(preco);
                 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
			
		}
		return hotel;
	
	}

	public int atualizarHotel(Hotel end) {
		String SQL = "UPDATE hotel SET formaPag = ?, dataIn = ?, dataOut = ?, preco = ? WHERE id_hospedagem = ?";
		
		Conexao con = Conexao.getConexao();
		
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setString(1, end.getFormaPag());
			ps.setDate(2, end.getDataIn());
			ps.setDate(3, end.getDataOut());
			ps.setFloat(4, end.getPreco());
			
			retorno = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		return retorno;
	}
	public int removerHotel(Hotel end) {
		String SQL = "DELETE FROM hotel WHERE id_hospedagem = ?";

		Conexao con = Conexao.getConexao();

		Connection conBD = con.conectar();

		int retorno = 0;

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setInt(1, end.getIdHospedagem());
			retorno = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return retorno;
	}

	public Hotel buscarHotelPorCidade(String cidade) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
