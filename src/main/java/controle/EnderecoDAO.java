package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modelo.Endereco;

public class EnderecoDAO implements IEnderecoDAO {

	private static EnderecoDAO instancia;

	private EnderecoDAO() {

	}

	public static EnderecoDAO getInstancia() {
		if (instancia == null) {
			instancia = new EnderecoDAO();
		}
		return instancia;
	}

	public int inserirEndereco(Endereco end) {
		String SQL = "INSERT INTO endereco (cep,cidade,estado,pais) VALUES (?,?,?,?,?)";

		Conexao con = Conexao.getConexao();
		Connection conDB = con.conectar();

		int chavePrimariaGerada = Integer.MIN_VALUE;

		try {
			PreparedStatement ps = conDB.prepareStatement(SQL);

			ps.setString(1, end.getCep());
			ps.setString(2, end.getCidade());
			ps.setString(3, end.getEstado());
			ps.setString(4, end.getPais());

			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				chavePrimariaGerada = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return chavePrimariaGerada;
	}

	public ArrayList<Endereco> listarEndereco() {
		ArrayList<Endereco> enderecos = new ArrayList<Endereco>();

		String SQL = "SELECT * FROM endereco";

		Conexao con = Conexao.getConexao(); // Pegou a conexão do banco de dados
		Connection conDB = con.conectar(); // Se conectou realmente ao banco de dados
		try {
			PreparedStatement ps = conDB.prepareStatement(SQL);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Endereco end = new Endereco();

				Integer enderecoId = rs.getInt("endereco_id");
				String cep = rs.getString("cep");
				String cidade = rs.getString("cidade");
				String estado = rs.getString("estado");
				String pais = rs.getString("pais");

				end.setEnderecoId(enderecoId);
				end.setCep(cep);
				end.setCidade(cidade);
				end.setEstado(estado);
				end.setPais(pais);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return enderecos;
	}

	public int atualizarEndereco(Endereco end) {
		String SQL = "UPDATE endereco SET cep = ?, cidade = ?, estado = ?, pais = ? WHERE endereco_id = ?";

		Conexao con = Conexao.getConexao();

		Connection conBD = con.conectar();

		int retorno = 0;

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setString(1, end.getCep());
			ps.setString(2, end.getCidade());
			ps.setString(3, end.getEstado());
			ps.setString(4, end.getPais());

			retorno = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return retorno;
	}

	public int removerEndereco(Endereco end) {
		String SQL = "DELETE FROM endereco WHERE endereco_id = ?";

		Conexao con = Conexao.getConexao();

		Connection conBD = con.conectar();

		int retorno = 0;

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setInt(1, end.getEnderecoId());
			retorno = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return retorno;
	}

	public Endereco buscarEnderecoPorCEP(int cpf) {

		return null;
	}

}
