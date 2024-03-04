package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import modelo.quarto;

public class QuartoDAO implements IQuartoDAO{
	
	private static QuartoDAO instancia;
	
	private QuartoDAO() {
		
	}
	
	public static QuartoDAO getInstancia1() {
		if(instancia == null) {
			instancia = new QuartoDAO();
		}
		return instancia; 
	}

	public int inserirQuarto(quarto end) {
String SQL = "INSERT INTO quarto(numquarto,horalimpeza,servicoquarto,tipo_id) VALUES (?,?,?,?)";
		
		Conexao con = Conexao.getConexao();
		Connection conDB = con.conectar();
		
		
		try {
			PreparedStatement ps = conDB.prepareStatement(SQL);
		
			ps.setInt(1, end.getNumQuarto());
			ps.setTime(2, end.getHoraLimpeza());
			ps.setBoolean(3, end.isServicoQuarto());
			ps.setInt(4, end.getTipoId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return 0;	
		
		
	}

	public ArrayList<quarto> listarQuartos() {
ArrayList<quarto> quarto = new ArrayList<quarto>();
		
		String SQL = "SELECT * FROM quarto";
		
		Conexao con = Conexao.getConexao();
		Connection conDB = con.conectar();
		
		try {
			PreparedStatement ps = conDB.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				quarto end = new quarto();
				
				Integer numQuarto = rs.getInt("numquarto");
				Time horaLimpeza = rs.getTime("horalimpeza");
				Boolean servicoQuarto = rs.getBoolean("servicoquarto");
				Integer tipoId = rs.getInt("tipo_id");
				
				
				end.setNumQuarto(numQuarto);
				end.setHoraLimpeza(horaLimpeza);
				end.setServicoQuarto(servicoQuarto);
				end.setTipoId(tipoId);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
			
		}
		return quarto;
	
	}

	public boolean atualizarQuarto(quarto end) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removerQuarto(quarto end) {
		// TODO Auto-generated method stub
		return false;
	}

	public quarto buscarQuartoPorNúmero(int numQuarto) {
		// TODO Auto-generated method stub
		return null;
	}

	public static QuartoDAO getInstancia() {
		return instancia;
	}

	public static void setInstancia(QuartoDAO instancia) {
		QuartoDAO.instancia = instancia;
	}

}
