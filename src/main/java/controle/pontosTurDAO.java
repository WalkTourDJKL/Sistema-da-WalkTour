package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import modelo.pontosTur;

public class pontosTurDAO implements IpontosTurDAO {
	
	private static pontosTurDAO instancia;
	
	private pontosTurDAO() {
		
	}
	
	public static pontosTurDAO getInstancia() {
		if(instancia == null) {
			instancia = new pontosTurDAO();
		}
		return instancia;
	}

	public int inserirPontoTur(pontosTur end) {
String SQL = "INSERT INTO pontosTur(ponto_id,horaabre,horafecha,preco,nomepontotur) VALUES (?,?,?,?,?)";
		
		Conexao con = Conexao.getConexao();
		Connection conDB = con.conectar();
		
		
		try {
			PreparedStatement ps = conDB.prepareStatement(SQL);
		
			ps.setInt(1, end.getPontoId());
			ps.setTime(2, end.getHoraAbre());
			ps.setTime(3, end.getHoraFecha());
			ps.setFloat(4, end.getPreco());
			ps.setString(5, end.getNomePontoTur());			
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return 0;	
		
		
	}

	public ArrayList<pontosTur> listarPontoTur() {
			ArrayList<pontosTur> pontosTur = new ArrayList<pontosTur>();
			
			String SQL = "SELECT * FROM pontosTur";
			
			Conexao con = Conexao.getConexao();
			Connection conDB = con.conectar();
			
			try {
				PreparedStatement ps = conDB.prepareStatement(SQL);
				
				ResultSet rs = ps.executeQuery();
				
				while (rs.next()) {
					pontosTur end = new pontosTur();
					
					Integer pontoId = rs.getInt("ponto_id");
					Time horaAbre = rs.getTime("horaabre");
					Time horaFecha = rs.getTime("horafecha");
					Float preco = rs.getFloat("preco");
					String nomePontoTur = rs.getString("nomepontotur");
					
					end.setPontoId(pontoId);
					end.setHoraAbre(horaAbre);
					end.setHoraFecha(horaFecha);
					end.setPreco(preco);
					end.setNomePontoTur(nomePontoTur);
				
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				con.fecharConexao();
				
			}
			return pontosTur;
		
		}

	public boolean atualizarPontosTur(pontosTur end) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removerPontosTur(pontosTur end) {
		// TODO Auto-generated method stub
		return false;
	}

	public pontosTur buscarPontoTurPorNome(String nomePontoTur) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void setInstancia(pontosTurDAO instancia) {
		pontosTurDAO.instancia = instancia;
	}

}
