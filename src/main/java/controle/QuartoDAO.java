package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import modelo.Endereco;
import modelo.Quarto;

public class QuartoDAO implements IQuartoDAO {

	private static QuartoDAO instancia;

	private QuartoDAO() {

	}

	public static QuartoDAO getInstancia1() {
		if (instancia == null) {
			instancia = new QuartoDAO();
		}
		return instancia;
	}

	public int inserirQuarto(Quarto end) {
		String SQL = "INSERT INTO quarto(numquarto,horalimpeza,servicoquarto,tipo_id) VALUES (?,?,?,?)";

		Conexao con = Conexao.getConexao();
		Connection conDB = con.conectar();

		try {
			PreparedStatement ps = conDB.prepareStatement(SQL);

			ps.setInt(1, end.getNumQuarto());
			ps.setTime(2, end.getHoraLimpeza());
			ps.setBoolean(3, end.isServicoQuarto());
			ps.setInt(4, end.getTipoId());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return 0;

	}

	public ArrayList<Quarto> listarQuartos() {
		ArrayList<Quarto> quarto = new ArrayList<Quarto>();

		String SQL = "SELECT * FROM quarto";

		Conexao con = Conexao.getConexao();
		Connection conDB = con.conectar();

		try {
			PreparedStatement ps = conDB.prepareStatement(SQL);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Quarto end = new Quarto();

				Integer numQuarto = rs.getInt("numquarto");
				Time horaLimpeza = rs.getTime("horalimpeza");
				Boolean servicoQuarto = rs.getBoolean("servicoquarto");
				Integer tipoId = rs.getInt("tipo_id");

				end.setNumQuarto(numQuarto);
				end.setHoraLimpeza(horaLimpeza);
				end.setServicoQuarto(servicoQuarto);
				end.setTipoId(tipoId);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();

		}
		return quarto;

	}

	public int atualizarQuarto(Quarto end) {
		String SQL = "UPDATE quarto SET numQuarto = ?, horaLimpeza = ?, servicoQuarto = ? WHERE tipo_id = ?";

		Conexao con = Conexao.getConexao();

		Connection conBD = con.conectar();

		int retorno = 0;

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setInt(1, end.getNumQuarto());
			ps.setTime(2, end.getHoraLimpeza());
			ps.setBoolean(3, end.isServicoQuarto());

			retorno = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return retorno;
	}

	public int removerQuarto(Quarto end) {
		String SQL = "DELETE FROM quarto WHERE tipo_id = ?";

		Conexao con = Conexao.getConexao();

		Connection conBD = con.conectar();

		int retorno = 0;

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setInt(1, end.getNumQuarto());
			retorno = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return retorno;
	}

	public Quarto buscarQuartoPorNúmero(int numQuarto) {
		// TODO Auto-generated method stub
		return null;
	}

	public static QuartoDAO getInstancia() {
		return instancia;
	}

	public static void setInstancia(QuartoDAO instancia) {
		QuartoDAO.instancia = instancia;
	}

}
