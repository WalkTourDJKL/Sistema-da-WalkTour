package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import modelo.DetalhesHospedagem;
import modelo.Usuarios;
import modelo.Reserva;

public class DetaHospDAO implements IDetaHospDAO {

	private static DetaHospDAO instancia;

	private DetaHospDAO() {
	}

	public static DetaHospDAO getInstancia() {
		if (instancia == null) {
			instancia = new DetaHospDAO();
		}
		return instancia;
	}

	public DetalhesHospedagem hospAchado = null;

	public int inserirDetalhes(DetalhesHospedagem end) {
		String SQL = "INSERT INTO detalhes_hospedagem ( id_hospedagem, id_usuario) VALUES (?, ?)";

		Conexao con = Conexao.getConexao();
		Connection conDB = con.conectar();
		int chavePrimariaGerada = Integer.MIN_VALUE;

		try {
			PreparedStatement ps = conDB.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, end.getIdHospedagem());
			ps.setInt(2, end.getIdUsuario());

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				chavePrimariaGerada = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return chavePrimariaGerada;
	}

	public ArrayList<DetalhesHospedagem> listarDetalhes() { // Adicione o parâmetro Connection

		Conexao con = Conexao.getConexao();
		Connection conDB = con.conectar();

		ArrayList<DetalhesHospedagem> hospede = new ArrayList<DetalhesHospedagem>();

		String SQL = "SELECT * FROM detalhes_hospedagem";

		try {
			PreparedStatement ps = conDB.prepareStatement(SQL);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				DetalhesHospedagem end = new DetalhesHospedagem();

				Integer idDetHospedagem = rs.getInt("id_detalhe_hospedagem");
				Integer idHospedagem = rs.getInt("id_hospedagem");
				Integer idUsuario = rs.getInt("id_usuario");

				end.setIdDetalheHospedagem(idDetHospedagem);
				end.setIdHospedagem(idHospedagem);
				end.setIdUsuario(idUsuario);

				hospede.add(end); // Adicione o objeto hospede à lista
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return hospede;
	}

	public boolean atualizarDetalhes(DetalhesHospedagem end) {
		String SQL = "UPDATE detalhes_hospedagem SET id_hospedagem = ?, id_usuario = ? WHERE id_detalhe_hospedagem = ?";

		Conexao con = Conexao.getConexao();
		Connection conDB = con.conectar();

		int retorn = 0;

		try {
			PreparedStatement ps = conDB.prepareStatement(SQL);

			ps.setInt(2, end.getIdHospedagem());
			ps.setInt(3, end.getIdUsuario());
			ps.setInt(6, end.getIdDetalheHospedagem());

			retorn = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return (retorn == 0 ? false : true);
	}

	public int removerDetalhesTodos(Usuarios hosp) {
		String SQL = "DELETE FROM detalhes_hospedagem WHERE id_usuario = ?;";
		Conexao con = Conexao.getConexao();

		Connection conBD = con.conectar();

		int retorno = 0;

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setInt(1, hosp.getIdUsuario());
			retorno = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return retorno;
	}

	public int removerDetalhes(DetalhesHospedagem end) {
		String SQL = "DELETE FROM detalhes_hospedagem WHERE id_detalhe_hospedagem = ?;";
		Conexao con = Conexao.getConexao();

		Connection conBD = con.conectar();

		int retorno = 0;

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setInt(1, end.getIdDetalheHospedagem());
			retorno = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return retorno;
	}

	@Override
	public DetalhesHospedagem buscarDetalhesPorId(int idDetalheHospedagem) {
		// TODO Auto-generated method stub
		return null;
	}

}
