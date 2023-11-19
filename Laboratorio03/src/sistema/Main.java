package sistema;

import java.sql.Connection;

import apresentacao.Janela;
import bancoDeDados.Conexao;

public class Main {

	public static void main(String[] args){
		new Janela();
		Connection conexao = new Conexao().getConexao();
		
	}

}
