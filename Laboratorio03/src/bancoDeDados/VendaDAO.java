package bancoDeDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sistema.Aluno;
import sistema.CachorroQuente;
import sistema.Venda;

public class VendaDAO {
	
	public ArrayList<Venda> ler() {
		ArrayList<Venda> vendas = new ArrayList<>();
		
		try {
			Connection conexao = new Conexao().getConexao();
			
			String query = "select * from cachorro_quente order by id_cachorro_quente asc";
			ResultSet dados = conexao.prepareStatement(query).executeQuery();
			
			while (dados.next()) {
				String nome = dados.getString("nome");
				int matricula = dados.getInt("matricula");
				int queijo = dados.getInt("op_queijo");
				int proteina = dados.getInt("op_proteina");
				String adicionais = dados.getString("ingredientes");
				int bebida = dados.getInt("bebida");
				double valor = dados.getDouble("valor");
				
				Venda v = new Venda(new Aluno(nome, matricula), new CachorroQuente(proteina, queijo, bebida, adicionais));
				v.getCachorrosQuentes().setValor(valor);
				
				vendas.add(v);
			}
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vendas;
	}
	
	public void inserir(Venda venda) {
		try {
			Connection conexao = new Conexao().getConexao();
			
			PreparedStatement inserir = conexao.prepareStatement("insert into cachorro_quente (nome,matricula,op_queijo,op_proteina,ingredientes,bebida,valor) values(?,?,?,?,?,?,?)");
			inserir.setString(1, venda.getAluno().getNome());
			inserir.setInt(2, venda.getAluno().getMatricula());
			inserir.setInt(3, venda.getCachorrosQuentes().getQueijo());
			inserir.setInt(4, venda.getCachorrosQuentes().getProteina());
			inserir.setString(5, venda.getCachorrosQuentes().getAdicionais());
			inserir.setInt(6, venda.getCachorrosQuentes().getBebida());
			inserir.setDouble(7, venda.getCachorrosQuentes().getValor());
			inserir.executeUpdate();
			
			conexao.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
