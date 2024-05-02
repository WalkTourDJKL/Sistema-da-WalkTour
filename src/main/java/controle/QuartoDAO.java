package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

import modelo.Endereco;
import modelo.Quarto;

public class QuartoDAO implements IQuartoDAO {

	private static QuartoDAO instancia;

	private QuartoDAO() {

	}

	public static QuartoDAO getInstancia() {
		if (instancia == null) {
			instancia = new QuartoDAO();
		}
		return instancia;
	}

	public int inserirQuarto(Quarto end) {
		String SQL = "INSERT INTO quarto(hora_limpeza,tipo_id) VALUES (?,?)";

		Conexao con = Conexao.getConexao();
		Connection conDB = con.conectar();
		int chavePrimariaGerada = Integer.MIN_VALUE;

		try {
			PreparedStatement ps = conDB.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

			ps.setTime(1, end.getHoraLimpeza());
			ps.setInt(2, end.getTipoId());

			int affectedRows = ps.executeUpdate();
			if (affectedRows > 0) {
				try (ResultSet rs = ps.getGeneratedKeys()) {
					if (rs.next()) {
						chavePrimariaGerada = rs.getInt(1);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return chavePrimariaGerada;

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

				Integer numQuarto = rs.getInt("num_quarto");
				Time horaLimpeza = rs.getTime("hora_limpeza");
				Integer tipoId = rs.getInt("tipo_id");

				end.setNumQuarto(numQuarto);
				end.setHoraLimpeza(horaLimpeza);
				end.setTipoId(tipoId);
				quarto.add(end);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();

		}
		return quarto;

	}

	public int atualizarQuarto(Quarto end) {
		String SQL = "UPDATE quarto SET hora_limpeza = ?, tipo_id = ?  WHERE num_quarto = ?  ";

		Conexao con = Conexao.getConexao();

		Connection conBD = con.conectar();

		int retorno = 0;

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setTime(1, end.getHoraLimpeza());
			ps.setInt(2, end.getTipoId());
			ps.setInt(3, end.getNumQuarto());

			retorno = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return retorno;
	}

	public int removerQuarto(Quarto end) {
		String SQL = "DELETE FROM quarto WHERE num_quarto = ?";

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


	public static void setInstancia(QuartoDAO instancia) {
		QuartoDAO.instancia = instancia;
	}

}
