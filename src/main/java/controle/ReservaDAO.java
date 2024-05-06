package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.time.LocalDate;
import java.sql.Date;
import modelo.Reserva;

public class ReservaDAO implements IReservaDAO {

	private static ReservaDAO instancia;

	private ReservaDAO() {

	}

	public static ReservaDAO getInstancia() {
		if (instancia == null) {
			instancia = new ReservaDAO();
		}
		return instancia;
	}

	public int inserirReserva(Reserva end) {
		String SQL = "INSERT INTO hospedagens(forma_pag, data_in, data_out, preco) VALUES (?,?,?,?)";

		Conexao con = Conexao.getConexao();
		Connection conDB = con.conectar();
		int chavePrimariaGerada = Integer.MIN_VALUE;

		try {
			PreparedStatement ps = conDB.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, end.getFormaPag());
			ps.setDate(2, Date.valueOf(end.getDataIn()));
			ps.setDate(3, Date.valueOf(end.getDataOut()));
			ps.setInt(4, end.getPreco());

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

	public ArrayList<Reserva> listarReservas() {

		Conexao con = Conexao.getConexao();
		Connection conDB = con.conectar();

		ArrayList<Reserva> reserva = new ArrayList<Reserva>();

		String SQL = "SELECT * FROM hospedagens";

		try {
			PreparedStatement ps = conDB.prepareStatement(SQL);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Reserva end = new Reserva();

				Integer idHospedagem = rs.getInt("id_hospedagem");
				String formaPag = rs.getString("forma_pag");
				LocalDate dataIn = rs.getDate("data_in").toLocalDate();
				LocalDate dataOut = rs.getDate("data_out").toLocalDate();
				Integer preco = rs.getInt("preco");

				end.setIdHospedagem(idHospedagem);
				end.setFormaPag(formaPag);
				end.setDataIn(dataIn);
				end.setDataOut(dataOut);
				end.setPreco(preco);

				reserva.add(end);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();

		}
		return reserva;

	}

	public int atualizarReserva(Reserva end) {
		String SQL = "UPDATE hospedagens SET forma_pag = ?, data_in = ?, data_out = ? WHERE id_hospedagem = ?";

		Conexao con = Conexao.getConexao();

		Connection conBD = con.conectar();

		int retorno = 0;

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setString(1, end.getFormaPag());
			ps.setDate(2, Date.valueOf(end.getDataIn()));
			ps.setDate(3, Date.valueOf(end.getDataOut()));
			ps.setInt(4, end.getIdHospedagem());

			retorno = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return retorno;
	}

	public int removerReserva(Reserva end) {
		String SQL = "DELETE FROM hospedagens WHERE id_hospedagem = ?";
		Conexao con = Conexao.getConexao();

		Connection conBD = con.conectar();

		int retorno = 0;

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setInt(1, end.getIdHospedagem());
			retorno = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return retorno;
	}

	public Reserva buscarReservaPorIdHospedagem(int idHospedagem) {
		// TODO Auto-generated method stub
		return null;
	}

}