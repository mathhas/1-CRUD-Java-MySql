package mySql;

import java.sql.DriverManager;
import java.sql.Connection;

public class ConnectionFactory {
	// Atributos
	private static final String USERNAME = "root"; // nome do servidor
	private static final String PASSWORD = ""; // senha do servidor
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mamiferos";

	// M�todos
	public static Connection criarConexaoComServidorMySql() throws Exception {
		// carrega classe pela maquina virtual JVM
		Class.forName("com.mysql.jdbc.Driver");

		// cria a conex�o com o DB
		Connection conexao = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

		return conexao;
	}
}
