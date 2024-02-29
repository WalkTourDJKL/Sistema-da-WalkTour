package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.hospedes;

public class HospedesDAO implements IHospedesDAO {

	private static HospedesDAO instancia;

	private HospedesDAO() {
	}

	public static HospedesDAO getInstancia() {
		if (instancia == null) {
			instancia = new HospedesDAO();
		}
		return instancia;
	}

	public int inserirHopesdes(hospedes end) {
		String SQL = "INSERT INTO hospedes (idHospede,nome,senha,nomeSocial,dtNasc, cpf) VALUES (?,?,?,?,?,?)";
		return 0;
	}

	public ArrayList<hospedes> listarHopesdess() {
		ArrayList<hospedes> hospede = new ArrayList<hospedes>();

		String SQL = "SELECT * FROM hospedes";

		Conexao con = Conexao.getConexao();
		Connection conDB = con.conectar();
		try {
			PreparedStatement ps = conDB.prepareStatement(SQL);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				hospedes end = new hospedes();

				String nome = rs.getString("nome");
				String nomeSocial = rs.getString("nome_social");
				Date dtNasc = rs.getDate("dt_nasc");
				String cpf = rs.getString("cpf");
				Integer idHospede = rs.getInt("id_hospede");

				end.setNome(nome);
				end.setNomeSocial(nomeSocial);
				end.setDtNasc(dtNasc);
				end.setCpf(cpf);
				end.setIdHospede(idHospede);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return hospede;
	}

	public boolean atualizarHopesdes(hospedes end) {
		String SQL = "UPDATE hospedes set nome = ?, nome_social = ?, dt_nasc = ?, cpf = ? WHERE id_hospede = ?";
		return false;
	}

	public boolean removerHopesdes(hospedes end) {

		return false;
	}

	public hospedes buscarHopesdesPorCPF(int cpf) {

		return null;
	}

}
