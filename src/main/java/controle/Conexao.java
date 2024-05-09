package controle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao { // Connection

	private static String USERNAME;
	private static String SENHA;
	private static String BD;
	private Connection con; // jdbc
	private static Conexao instancia; // singleton

	private Conexao() {
	} // construtor privado

	/**
	 * Metodo singleton
	 * 
	 * @return conexao
	 */
	public static Conexao getConexao() {
		if (instancia == null) {
			instancia = new Conexao();
			lerArquivoDB();
		}

		return instancia;
	}

	/**
	 * Metodo que faz a conexao com o MySQL
	 * 
	 * @return con
	 */
	public Connection conectar() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/" + BD + "?serverTimezone=UTC", USERNAME, SENHA);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;
	}

	public static void lerArquivoDB() {
		FileReader arquivo;
		try {
			arquivo = new FileReader("credenciais.txt");
			if(arquivo!=null) {
				BufferedReader reader = new BufferedReader(arquivo);
				
				USERNAME = reader.readLine();
				SENHA=reader.readLine();
				BD=reader.readLine();
				
				reader.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Fecha a conexao com o MySQL
	 * 
	 * @return true ou false; dependendo do resultado
	 */
	public boolean fecharConexao() {
		try {
			con.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}