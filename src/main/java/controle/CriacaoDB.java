package controle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

public class CriacaoDB {
	public static void main(String[] args) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "aluno");
			Statement statement = connection.createStatement();

			String filePath = "./WalkTourDB/scripts_WalkTourDB.sql";
			BufferedReader br = new BufferedReader(new FileReader(filePath));

			StringBuilder query = new StringBuilder();
			String line;

			while ((line = br.readLine()) != null) {

				if (line.trim().startsWith("-- ")) {
					continue;
				}

				query.append(line).append(" ");

				if (line.trim().endsWith(";")) {
					statement.execute(query.toString().trim());
					query = new StringBuilder();
				}
			}

			System.out.println("Script File executed");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
