package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Hospedes;
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

	public int inserirModeloQuarto(ModeloQuarto modelo) {
<<<<<<< HEAD
		// SQL sem a coluna 'tipo_id' que Ã© autoincrementada
=======
		// SQL sem a coluna 'tipo_id' que é autoincrementada
>>>>>>> 0e85260bf0a49b3ab828726a1ab8e2ba4d2930a2
		String SQL = "INSERT INTO modelo_quarto(nome_modelo, qtd_banheiro, qtd_camas, frigobar, servico_quarto, preco) VALUES (?, ?, ?, ?, ?, ?)";
		Conexao con = Conexao.getConexao();
		Connection conDB = con.conectar();
		int chavePrimariaGerada = Integer.MIN_VALUE;

		try {
<<<<<<< HEAD
			// Preparando o comando SQL e informando que queremos recuperar chaves primÃ¡rias
=======
			// Preparando o comando SQL e informando que queremos recuperar chaves primárias
>>>>>>> 0e85260bf0a49b3ab828726a1ab8e2ba4d2930a2
			// geradas
			PreparedStatement ps = conDB.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setString(1, modelo.getNomeModelo());
			ps.setInt(2, modelo.getQtdBanheiro());
			ps.setInt(3, modelo.getQtdCamas());
			ps.setBoolean(4, modelo.isFrigobar());
			ps.setBoolean(5, modelo.isServicoQuarto());
			ps.setString(6, modelo.getPreco());

			int affectedRows = ps.executeUpdate();

			// Verificando se foram inseridas linhas e recuperando a chave gerada
			if (affectedRows > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
<<<<<<< HEAD
					chavePrimariaGerada = rs.getInt(1); // ObtÃ©m a chave primÃ¡ria gerada
=======
					chavePrimariaGerada = rs.getInt(1); // Obtém a chave primária gerada
>>>>>>> 0e85260bf0a49b3ab828726a1ab8e2ba4d2930a2
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return chavePrimariaGerada; // Retorna o ID gerado ou -1 se houver erro
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
		String SQL = "UPDATE modelo_quarto SET nome_modelo = ?, qtd_banheiro = ?, qtd_camas = ?, frigobar = ?, servico_quarto = ?, preco = ? WHERE tipo_id = ?";

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
			ps.setString(6, end.getPreco());
			ps.setInt(7, end.getTipoId());

			retorno = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return (retorno == 0 ? false : true);
	}

	public int removerModeloQuarto(ModeloQuarto end) {
		String SQL = "DELETE FROM modelo_quarto WHERE tipo_id = ?";

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

<<<<<<< HEAD
}
=======
}
>>>>>>> 0e85260bf0a49b3ab828726a1ab8e2ba4d2930a2
