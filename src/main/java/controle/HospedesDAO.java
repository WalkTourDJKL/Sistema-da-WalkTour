package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

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

	public hospedes hospAchado = null;

	public int inserirHopesdes(hospedes end) {
		String SQL = "INSERT INTO hospedes (nome, nome_social, dt_nasc, cpf) VALUES (?, ?, ?, ?)";

		Conexao con = Conexao.getConexao();
		Connection conDB = con.conectar();
		int chavePrimariaGerada = Integer.MIN_VALUE;

		try {
			PreparedStatement ps = conDB.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, end.getNome());
			ps.setString(2, end.getNomeSocial());
			ps.setDate(3, end.getDtNasc());
			ps.setString(4, end.getCpf());

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

	public ArrayList<hospedes> listarHopesdes() { // Adicione o parâmetro Connection

		Conexao con = Conexao.getConexao();
		Connection conDB = con.conectar();

		ArrayList<hospedes> hospede = new ArrayList<hospedes>();

		String SQL = "SELECT * FROM hospedes";

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

				hospede.add(end); // Adicione o objeto hospede à lista
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return hospede;
	}

	public boolean atualizarHopesdes(hospedes end) {
		String SQL = "UPDATE hospedes SET nome = ?, nome_social = ?, dt_nasc = ?, cpf = ? WHERE id_hospede = ?";

		Conexao con = Conexao.getConexao();
		Connection conDB = con.conectar();

		int retorn = 0;

		try {
			PreparedStatement ps = conDB.prepareStatement(SQL);

			ps.setString(2, end.getNome());
			ps.setString(3, end.getNomeSocial());
			ps.setDate(4, end.getDtNasc());
			ps.setString(5, end.getCpf());
			ps.setInt(6, end.getIdHospede());

			retorn = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return (retorn == 0 ? false : true);
	}

	public int removerHopesdes(hospedes end) {
		String SQL = "DELETE FROM hospedes WHERE id_hospede = ?;";
		Conexao con = Conexao.getConexao();

		Connection conBD = con.conectar();

		int retorno = 0;

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setInt(1, end.getIdHospede());
			retorno = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return retorno;
	}

	public hospedes buscarHopesdesPorCPF(int cpf) {

		return null;
	}

	public hospedes login(hospedes h) {
		hospAchado = null;
		for (hospedes hosp : listarHopesdes()) {
			if ((hosp.getNome().equals(h.getNome()) || hosp.getNomeSocial().equals(h.getNomeSocial()))
					&& hosp.getCpf().equals(h.getCpf())) { // Verifica se o Nome e CPF
				// colocados na tale Login
				// são iguais a algum no
				// banco de dados
				hospAchado = hosp;

				return hospAchado;
			}

		}
		return hospAchado;
	}
	public hospedes passaLogado() {
		return hospAchado;
	}

}
