package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date; 


import modelo.Evento;

public class EventoDAO implements IEventoDAO{
	
	private static EventoDAO instancia; 
	 
	private EventoDAO() { 
		 
	} 
	 
	public static EventoDAO getInstancia() { 
		if(instancia == null) { 
			instancia = new EventoDAO(); 
		} 
		return instancia;
	} 
	
	
	public int inserirEvento(Evento end) {
		String SQL = "INSERT INTO eventos(id_evento, diainicio, diafim, horainicio, horafim, nomeevento, preco) VALUES (?,?,?,?,?,?,?)";
		
		Conexao con = Conexao.getConexao();
		Connection conDB = con.conectar();
		
		
		try {
		    PreparedStatement ps = conDB.prepareStatement(SQL);

		    ps.setInt(1, end.getIdEvento());
		    ps.setDate(2, end.getDiaInicio());
		    ps.setDate(3, end.getDiaFim());
		    ps.setTime(4, end.getHoraInicio());
		    ps.setTime(5, end.getHoraFim());
		    ps.setString(6, end.getNomeEvento());
		    ps.setFloat(7, end.getPreco());

		    ps.executeUpdate();
		} catch (SQLException e) {
		    e.printStackTrace();
		} finally {
		    con.fecharConexao();
		}
		return 0;	
		
		
	}

	public ArrayList<Evento> listarEventos() {
		ArrayList<Evento> evento = new ArrayList<Evento>(); 
		
		String SQL = "SELECT * FROM eventos";
		
		Conexao con = Conexao.getConexao(); 
		Connection conDB = con.conectar(); 
		
		try {
			PreparedStatement ps = conDB.prepareStatement(SQL); 
			 
			ResultSet rs = ps.executeQuery(); 
			 
			while (rs.next()) { 
				Evento end = new Evento(); 
				
				Integer idEvento = rs.getInt("id_evento");
				Date diaInicio = rs.getDate("dia_inicio");
				Date diaFim = rs.getDate("dia_fim");
				Time horaInicio = rs.getTime("hora_inicio");
				Time horaFim = rs.getTime("hora_fim");
				String nomeEvento = rs.getString("nome_evento");
				Float preco = rs.getFloat("preco");
				 
				 
				end.setIdEvento(idEvento);
				end.setDiaInicio(diaInicio);
				end.setDiaFim(diaFim);
				end.setHoraInicio(horaInicio);
				end.setHoraFim(horaFim);
				end.setNomeEvento(nomeEvento);
				end.setPreco(preco);
				evento.add(end);
 
			} 
			 
		} catch (Exception e) { 
			e.printStackTrace(); 
		} finally { 
			con.fecharConexao(); 
			 
		} 
		return evento; 
	}

	public int atualizarEventos(Evento end) {
		String SQL = "UPDATE eventos SET diaInicio = ?, diaFim = ?, horaInicio = ?, horaFim = ?, nomeEvento = ?, preco = ? WHERE endereco_id = ?";
		
		Conexao con = Conexao.getConexao();
		
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setDate(1, end.getDiaInicio());
			ps.setDate(2, end.getDiaFim());
			ps.setTime(3, end.getHoraInicio());
			ps.setTime(4, end.getHoraFim());
			ps.setString(5, end.getNomeEvento());
			ps.setFloat(6, end.getPreco());

			
			
			retorno = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		return retorno;
	}
 
	public int removerEventos(Evento end) {
		String SQL = "DELETE FROM eventos WHERE id_evento = ?";
		Conexao con = Conexao.getConexao();

		Connection conBD = con.conectar();

		int retorno = 0;

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setInt(1, end.getIdEvento());
			retorno = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return retorno;
	}

	public Evento buscarEventoPorNome(String nomeEvento) {
		// TODO Auto-generated method stub
		return null;
	}

}
