package controle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

public class CriacaoDB {
	public static void main(String[] args) {
		try {
			// Creating a connection between Java class and Database instance
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "aluno");
			Statement statement = connection.createStatement();

			// path to our SQL Script file
			String filePath = "./WalkTourDB/scripts_WalkTourDB.sql";
			BufferedReader br = new BufferedReader(new FileReader(filePath));

			// String Builder to build the query line by line.
			StringBuilder query = new StringBuilder();
			String line;

			while ((line = br.readLine()) != null) {

				if (line.trim().startsWith("-- ")) {
					continue;
				}

				// Append the line into the query string and add a space after that
				query.append(line).append(" ");

				if (line.trim().endsWith(";")) {
					// Execute the Query
					statement.execute(query.toString().trim());
					// Empty the Query string to add new query from the file
					query = new StringBuilder();
				}
			}

			System.out.println("Script File executed");
		} catch (Exception e) {
			// Error handling Statements
			System.out.println(e.toString());
		}
	}
}
