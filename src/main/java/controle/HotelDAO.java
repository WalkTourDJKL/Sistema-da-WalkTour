package controle;

import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.util.ArrayList; 
import java.sql.Date; 
import modelo.hotel;

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
	

	public int inserirHotel(hotel end) {
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

	public ArrayList<hotel> listarHotel() {
		ArrayList<hotel> hotel = new ArrayList<hotel>();
		
        String SQL = "SELECT * FROM hotel";
		
		Conexao con = Conexao.getConexao();
		Connection conDB = con.conectar();

		try {
			PreparedStatement ps = conDB.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				hotel end = new hotel();
				
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

	public int atualizarHotel(hotel end) {
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
	public int removerHotel(hotel end) {
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

	public hotel buscarHotelPorCidade(String cidade) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
