package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date; 


import modelo.evento;

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
	
	public int inserirEvento(evento end) {
		String SQL = "INSERT INTO evento(id_evento, diainicio, diafim, horainicio, horafim, nomeevento, preco) VALUES (?,?,?,?,?,?,?)";
		
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

	public ArrayList<evento> listarEventos() {
		ArrayList<evento> evento = new ArrayList<evento>(); 
		
		String SQL = "SELECT * FROM evento";
		
		Conexao con = Conexao.getConexao(); 
		Connection conDB = con.conectar(); 
		
		try {
			PreparedStatement ps = conDB.prepareStatement(SQL); 
			 
			ResultSet rs = ps.executeQuery(); 
			 
			while (rs.next()) { 
				evento end = new evento(); 
				
				Integer idEvento = rs.getInt("id_evento");
				Date diaInicio = rs.getDate("diainicio");
				Date diaFim = rs.getDate("diafim");
				Time horaInicio = rs.getTime("horainicio");
				Time horaFim = rs.getTime("horafim");
				String nomeEvento = rs.getString("nomeevento");
				Float preco = rs.getFloat("preco");
				 
				 
				end.setIdEvento(idEvento);
				end.setDiaInicio(diaInicio);
				end.setDiaFim(diaFim);
				end.setHoraInicio(horaInicio);
				end.setHoraFim(horaFim);
				end.setNomeEvento(nomeEvento);
				end.setPreco(preco);
 
			} 
			 
		} catch (Exception e) { 
			e.printStackTrace(); 
		} finally { 
			con.fecharConexao(); 
			 
		} 
		return evento; 
	}

	public boolean atualizarEventos(evento end) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removerEventos(evento end) {
		// TODO Auto-generated method stub
		return false;
	}

	public evento buscarEventoPorNome(String nomeEvento) {
		// TODO Auto-generated method stub
		return null;
	}

}
