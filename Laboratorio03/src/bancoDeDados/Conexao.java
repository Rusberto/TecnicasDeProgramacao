package bancoDeDados;

import java.sql.*;

public class Conexao {
	private String host;
	private String usuario;
	private String senha;
	private String banco;

	public Conexao()
	{

		this.host = "test_db.mysql.dbaas.com.br";
		this.banco = "test_db";
		this.usuario = "test_db";
		this.senha = "TecProg23-2!@";
	}

	public Connection getConexao(){
		String url = "jdbc:mysql://test_db.mysql.dbaas.com.br:3306/test_db";
		
		try {
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException ex) {
			System.out.println("Conexão com MYSQL não realizada");
			ex.printStackTrace();
		}
		
		return null;
	}

}
