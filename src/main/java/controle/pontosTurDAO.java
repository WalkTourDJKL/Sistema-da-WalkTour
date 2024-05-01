package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import modelo.PontosTur;

public class pontosTurDAO implements IpontosTurDAO {

	private static pontosTurDAO instancia;

	private pontosTurDAO() {

	}

	public static pontosTurDAO getInstancia() {
		if (instancia == null) {
			instancia = new pontosTurDAO();
		}
		return instancia;
	}

	public int inserirPontoTur(PontosTur end) {
		String SQL = "INSERT INTO pontos_tur(ponto_id,horaabre,horafecha,preco VALUES (?,?,?,?)";

		Conexao con = Conexao.getConexao();
		Connection conDB = con.conectar();

		try {
			PreparedStatement ps = conDB.prepareStatement(SQL);

			ps.setInt(1, end.getPontoId());
			ps.setTime(2, end.getHoraAbre());
			ps.setTime(3, end.getHoraFecha());
			ps.setFloat(4, end.getPreco());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return 0;

	}

	public ArrayList<PontosTur> listarPontoTur() {
		ArrayList<PontosTur> pontosTur = new ArrayList<PontosTur>();

		String SQL = "SELECT * FROM pontos_tur";

		Conexao con = Conexao.getConexao();
		Connection conDB = con.conectar();

		try {
			PreparedStatement ps = conDB.prepareStatement(SQL);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				PontosTur end = new PontosTur();

				Integer pontoId = rs.getInt("ponto_id");
				Time horaAbre = rs.getTime("hora_abre");
				Time horaFecha = rs.getTime("hora_fecha");
				Float preco = rs.getFloat("preco");

				end.setPontoId(pontoId);
				end.setHoraAbre(horaAbre);
				end.setHoraFecha(horaFecha);
				end.setPreco(preco);
				pontosTur.add(end);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();

		}
		return pontosTur;

	}

	public int atualizarPontosTur(PontosTur end) {
	    String SQL = "UPDATE pontos_tur SET hora_abre = ?, hora_fecha = ?, preco = ? WHERE ponto_id = ?";
	    Conexao con = Conexao.getConexao();
	    Connection conBD = con.conectar();
	    int retorno = 0;

	    try {
	        PreparedStatement ps = conBD.prepareStatement(SQL);
	        ps.setTime(1, end.getHoraAbre());
	        ps.setTime(2, end.getHoraFecha());
	        ps.setFloat(3, end.getPreco());
	        ps.setInt(4, end.getPontoId());

	        retorno = ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        con.fecharConexao();
	    }
	    return retorno;
	}


	public int removerPontosTur(PontosTur end) {
		String SQL = "DELETE FROM pontos_tur WHERE ponto_id = ?";
		Conexao con = Conexao.getConexao();

		Connection conBD = con.conectar();

		int retorno = 0;

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setInt(1, end.getPontoId());
			retorno = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return retorno;
	}

	public PontosTur buscarPontoTurPorNome(String nomePontoTur) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void setInstancia(pontosTurDAO instancia) {
		pontosTurDAO.instancia = instancia;
	}

}
