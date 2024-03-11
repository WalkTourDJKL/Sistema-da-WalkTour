<<<<<<< HEAD
package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.modeloQuarto;

public class ModeloQuartoDAO implements IModeloQuartoDAO{

	private static ModeloQuartoDAO instancia; 
	
	private ModeloQuartoDAO(){
		
	}
	
	public static ModeloQuartoDAO getInstancia() {
		if(instancia == null) {
			instancia = new ModeloQuartoDAO();
		}
		return instancia; 
	}
	
	
	public int inserirModeloQuarto(modeloQuarto end) {
		String SQL = "INSERT INTO modeloQuarto(tipo_id,nome_modelo,qtd_banheiro,qtd_camas,frigobar,servico_quarto) VALUES (?,?,?,?,?,?)";
		
		Conexao con = Conexao.getConexao();
		Connection conDB = con.conectar();
		
		
		try {
			PreparedStatement ps = conDB.prepareStatement(SQL);
		
			ps.setInt(1, end.getTipoId());
			ps.setString(2, end.getNomeModelo());
			ps.setInt(3, end.getQtdBanheiro());
			ps.setInt(4, end.getQtdCamas());
			ps.setBoolean(5, end.isFrigobar());
			ps.setBoolean(6, end.isServicoQuarto());
			
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}	
		
		return 0;
	}
	

	public ArrayList<modeloQuarto> listarModeloQuarto() {
		ArrayList<modeloQuarto> modeloQuarto = new ArrayList<modeloQuarto>();
		
		String SQL = "SELECT * FROM modeloQuarto";
		
		Conexao con = Conexao.getConexao();
		Connection conDB = con.conectar();
		
		try {
			PreparedStatement ps = conDB.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				modeloQuarto end = new modeloQuarto();
				
				Integer tipoId = rs.getInt("tipo_id");
				String nomeModelo = rs.getString("nome_modelo");
				Integer qtdBanheiro = rs.getInt("qtd_banheiro");
				Integer qtdCamas = rs.getInt("qtd_camas");
				Boolean frigobar = rs.getBoolean("frigobar");
				Boolean servicoQuarto = rs.getBoolean("servico_quarto");
				
				end.setTipoId(tipoId);
				end.setNomeModelo(nomeModelo);
				end.setQtdBanheiro(qtdBanheiro);
				end.setQtdCamas(qtdCamas);
				end.setFrigobar(frigobar);
				end.setServicoQuarto(servicoQuarto);
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
			
		}
		return modeloQuarto;
	
	}

	public int atualizarModeloQuarto(modeloQuarto end) {
        String SQL = "UPDATE modeloQuarto SET nomeModelo = ?, qtdBanheiro = ?, qtdCamas = ?, frigobar = ?, servicoQuarto = ? WHERE tipo_id = ?";
		
		Conexao con = Conexao.getConexao();
		
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setString(1, end.getNomeModelo());
			ps.setInt(2, end.getQtdBanheiro());
			ps.setInt(3, end.getQtdCamas());
			ps.setBoolean(4, end.isFrigobar());
			ps.setBoolean(5, end.isServicoQuarto());

			
			retorno = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		return retorno;
	}

	public boolean removerModeloQuarto(modeloQuarto end) {
		String SQL = "DELETE FROM modeloQuarto WHERE tipo_id = ?";
		return false;
	}

	public modeloQuarto buscarModeloQuartoPorNome(String nomeModelo) {
		// TODO Auto-generated method stub
		return null;
	}

}
=======
package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.modeloQuarto;

public class ModeloQuartoDAO implements IModeloQuartoDAO{

	private static ModeloQuartoDAO instancia; 
	
	private ModeloQuartoDAO(){
		
	}
	
	public static ModeloQuartoDAO getInstancia() {
		if(instancia == null) {
			instancia = new ModeloQuartoDAO();
		}
		return instancia; 
	}
	
	
	public int inserirModeloQuarto(modeloQuarto end) {
		String SQL = "INSERT INTO modeloQuarto(nome_modelo,qtd_banheiro,qtd_camas,frigobar,servico_quarto) VALUES (?,?,?,?,?,?)";
		
		Conexao con = Conexao.getConexao();
		Connection conDB = con.conectar();
		
		int chavePrimariaGerada = Integer.MIN_VALUE;
		
		try {
			PreparedStatement ps = conDB.prepareStatement(SQL);
		
			ps.setInt(1, end.getTipoId());
			ps.setString(2, end.getNomeModelo());
			ps.setInt(3, end.getQtdBanheiro());
			ps.setInt(4, end.getQtdCamas());
			ps.setBoolean(5, end.isFrigobar());
			ps.setBoolean(6, end.isServicoQuarto());
			
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				chavePrimariaGerada = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}	
		
		return chavePrimariaGerada;
	}
	

	public ArrayList<modeloQuarto> listarModeloQuarto() {
		ArrayList<modeloQuarto> modeloQuarto = new ArrayList<modeloQuarto>();
		
		String SQL = "SELECT * FROM modeloQuarto";
		
		Conexao con = Conexao.getConexao();
		Connection conDB = con.conectar();
		
		try {
			PreparedStatement ps = conDB.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				modeloQuarto end = new modeloQuarto();
				
				Integer tipoId = rs.getInt("tipo_id");
				String nomeModelo = rs.getString("nome_modelo");
				Integer qtdBanheiro = rs.getInt("qtd_banheiro");
				Integer qtdCamas = rs.getInt("qtd_camas");
				Boolean frigobar = rs.getBoolean("frigobar");
				Boolean servicoQuarto = rs.getBoolean("servico_quarto");
				
				end.setTipoId(tipoId);
				end.setNomeModelo(nomeModelo);
				end.setQtdBanheiro(qtdBanheiro);
				end.setQtdCamas(qtdCamas);
				end.setFrigobar(frigobar);
				end.setServicoQuarto(servicoQuarto);
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
			
		}
		return modeloQuarto;
	
	}

	public boolean atualizarModeloQuarto(modeloQuarto end) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removerModeloQuarto(modeloQuarto end) {
		// TODO Auto-generated method stub
		return false;
	}

	public modeloQuarto buscarModeloQuartoPorNome(String nomeModelo) {
		// TODO Auto-generated method stub
		return null;
	}

}
>>>>>>> main
