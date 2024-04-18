package controle; 
 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Time; 
import java.util.ArrayList; 
import java.sql.Date; 
 
import modelo.Reserva; 
 
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
 
	public int inserirReserva(Reserva end) { 
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
	public ArrayList<Reserva> listarReservas() { 
ArrayList<Reserva> reserva = new ArrayList<Reserva>(); 
		 
		String SQL = "SELECT * FROM reserva"; 
		 
		Conexao con = Conexao.getConexao(); 
		Connection conDB = con.conectar(); 
		 
		try { 
			PreparedStatement ps = conDB.prepareStatement(SQL); 
			 
			ResultSet rs = ps.executeQuery(); 
			 
			while (rs.next()) { 
				Reserva end = new Reserva(); 
				 
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
 
	public int atualizarReserva(Reserva end) { 
		String SQL = "UPDATE reserva SET formPag = ?, dataIn = ?, dataOut = ?, preco = ? WHERE id_hospedagem = ?";
        
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
 
	public int removerReserva(Reserva end) { 
		String SQL = "DELETE FROM reserva WHERE id_hospedagem = ?";
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
 
	public Reserva buscarReservaPorIdHospedagem(int idHospedagem) { 
		// TODO Auto-generated method stub 
		return null; 
	} 
 
} 