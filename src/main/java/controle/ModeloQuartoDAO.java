package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Usuarios;
import modelo.ModeloQuarto;

public class ModeloQuartoDAO implements IModeloQuartoDAO {

	private static ModeloQuartoDAO instancia;

	public static ModeloQuartoDAO getInstancia() {
		if (instancia == null) {
			instancia = new ModeloQuartoDAO();
		}
		return instancia;
	}
	
	public ModeloQuarto precoAchado = null;

	public int inserirModeloQuarto(ModeloQuarto end) {
		String SQL = "INSERT INTO modelo_quarto(nome_modelo,qtd_banheiro,qtd_camas,frigobar,servico_quarto,preco) VALUES (?,?,?,?,?,?,?)";

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
			ps.setString(7, end.getPreco());

			ps.executeUpdate();

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

	public ArrayList<ModeloQuarto> listarModeloQuarto() {
		Conexao con = Conexao.getConexao();
		Connection conDB = con.conectar();

		ArrayList<ModeloQuarto> modeloQuarto = new ArrayList<ModeloQuarto>();

		String SQL = "SELECT * FROM modelo_quarto";
		try {
			PreparedStatement ps = conDB.prepareStatement(SQL);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ModeloQuarto end = new ModeloQuarto();

				Integer tipoId = rs.getInt("tipo_id");
				String nomeModelo = rs.getString("nome_modelo");
				Integer qtdBanheiro = rs.getInt("qtd_banheiro");
				Integer qtdCamas = rs.getInt("qtd_camas");
				Boolean frigobar = rs.getBoolean("frigobar");
				Boolean servicoQuarto = rs.getBoolean("servico_quarto");
				String preco = rs.getString("preco");

				end.setTipoId(tipoId);
				end.setNomeModelo(nomeModelo);
				end.setQtdBanheiro(qtdBanheiro);
				end.setQtdCamas(qtdCamas);
				end.setFrigobar(frigobar);
				end.setServicoQuarto(servicoQuarto);
				end.setPreco(preco);

				modeloQuarto.add(end);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();

		}
		return modeloQuarto;

	}

	public boolean atualizarModeloQuarto(ModeloQuarto end) {
		String SQL = "UPDATE modeloQuarto SET nomeModelo = ?, qtdBanheiro = ?, qtdCamas = ?, frigobar = ?, servicoQuarto = ?, preco = ? WHERE tipo_id = ?";

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

		return (retorno == 0 ? false : true);
	}

	public int removerModeloQuarto(ModeloQuarto end) {
		String SQL = "DELETE modelo_quarto WHERE tipo_id = ?";

		Conexao con = Conexao.getConexao();

		Connection conBD = con.conectar();

		int retorno = 0;

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setInt(1, end.getTipoId());
			retorno = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return retorno;
	}

	public ModeloQuarto buscarModeloQuartoPorNome(String nomeModelo) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	public ModeloQuarto buscPreco(ModeloQuarto mQ) {
	    precoAchado = null;
	    Conexao con = Conexao.getConexao();
	    Connection conDB = con.conectar();

	    String SQL = "SELECT * FROM modelo_quarto WHERE nome_modelo = ?";
	    try {
	        PreparedStatement ps = conDB.prepareStatement(SQL);
	        ps.setString(1, mQ.getNomeModelo());
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            ModeloQuarto mQuar = new ModeloQuarto();
	            mQuar.setTipoId(rs.getInt("tipo_id"));
	            mQuar.setNomeModelo(rs.getString("nome_modelo"));
	            mQuar.setQtdBanheiro(rs.getInt("qtd_banheiro"));
	            mQuar.setQtdCamas(rs.getInt("qtd_camas"));
	            mQuar.setFrigobar(rs.getBoolean("frigobar"));
	            mQuar.setServicoQuarto(rs.getBoolean("servico_quarto"));
	            mQuar.setPreco(rs.getString("preco"));

	            precoAchado = mQuar;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        con.fecharConexao();
	    }
	    return precoAchado;
	}


}
