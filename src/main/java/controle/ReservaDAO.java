package controle; 
 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Time; 
import java.util.ArrayList; 
import java.sql.Date; 
 
import modelo.quarto; 
import modelo.reserva; 
 
public class ReservaDAO implements IReservaDAO { 
	 
	private static ReservaDAO instancia; 
	 
	private ReservaDAO() { 
		 
	} 
	 
	public static ReservaDAO getInstancia() { 
		if(instancia == null) { 
			instancia = new ReservaDAO(); 
		} 
		return instancia;
	} 
 
	public int inserirReserva(reserva end) { 
String SQL = "INSERT INTO reserva(id_hospedagem,formapag,datin,dataout, preco) VALUES (?,?,?,?,?)"; 
		 
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
	public ArrayList<reserva> listarReservas() { 
ArrayList<reserva> reserva = new ArrayList<reserva>(); 
		 
		String SQL = "SELECT * FROM reserva"; 
		 
		Conexao con = Conexao.getConexao(); 
		Connection conDB = con.conectar(); 
		 
		try { 
			PreparedStatement ps = conDB.prepareStatement(SQL); 
			 
			ResultSet rs = ps.executeQuery(); 
			 
			while (rs.next()) { 
				reserva end = new reserva(); 
				 
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
		return reserva; 
	 
	} 
 
	public boolean atualizarReserva(reserva end) { 
		// TODO Auto-generated method stub 
		return false; 
	} 
 
	public boolean removerReserva(reserva end) { 
		// TODO Auto-generated method stub 
		return false; 
	} 
 
	public reserva buscarReservaPorIdHospedagem(int idHospedagem) { 
		// TODO Auto-generated method stub 
		return null; 
	} 
 
} 