package bancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private String host;
	private String usuario;
	private String senha;
	private String banco;

	public Conexao() {

		this.host = "da_java.mysql.dbaas.com.br";
		this.banco = "da_java";
		this.usuario = "da_java";
		this.senha = "Tecnicas*2023@";
	}

	public Connection getConexao() {
		String url = "jdbc:mysql://" + host + ":3306/" + banco;

		try {
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException ex) {
			System.out.println("Conexão com MYSQL não realizada");
			ex.printStackTrace();
		}

		return null;
	}

}
