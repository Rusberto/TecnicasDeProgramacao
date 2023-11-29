package bancoDeDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sistema.Relatorio;

public class RelatorioDAO {
	public ArrayList<Relatorio> ler(){
		ArrayList<Relatorio> relatorios = new ArrayList<>();
		
		try {
			Connection conexao = new Conexao().getConexao();
			
			String query = "select * from javalar order by id asc";
			ResultSet dados = conexao.prepareStatement(query).executeQuery();
			
			while(dados.next()) {
				String nome = dados.getString("nome");
				String matricula = dados.getString("matricula");
				String arquivo = dados.getString("nome_arquivo");
				int[] bugs = {dados.getInt("bug_python"), dados.getInt("bug_javascript"), dados.getInt("bug_ruby"), dados.getInt("bug_php"), dados.getInt("bug_csharp"),dados.getInt("bug_cmais"), dados.getInt("bug_c")};
				int[] devs = {dados.getInt("dev_python"), dados.getInt("dev_javascript"), dados.getInt("dev_ruby"), dados.getInt("dev_php"), dados.getInt("dev_csharp"),dados.getInt("dev_cmais"), dados.getInt("dev_c")};
				int[] velocidade = {dados.getInt("v_python"), dados.getInt("v_javascript"), dados.getInt("v_ruby"), dados.getInt("v_php"), dados.getInt("v_csharp"),dados.getInt("v_cmais"), dados.getInt("v_c")};
				int[] dias = {dados.getInt("d_python"), dados.getInt("d_javascript"), dados.getInt("d_ruby"), dados.getInt("d_php"), dados.getInt("d_csharp"),dados.getInt("d_cmais"), dados.getInt("d_c")};
				int[] anos       = {dados.getInt("a_python"), dados.getInt("a_javascript"), dados.getInt("a_ruby"), dados.getInt("a_php"), dados.getInt("a_csharp"),dados.getInt("a_cmais"), dados.getInt("a_c")};
				int[] bugQ = {dados.getInt("bug_q1"),dados.getInt("bug_q2"),dados.getInt("bug_q3"),dados.getInt("bug_q4")};
				int[] devQ = {dados.getInt("dev_q1"),dados.getInt("dev_q2"),dados.getInt("dev_q3"),dados.getInt("dev_q4")};

				relatorios.add(new Relatorio(nome, matricula, arquivo, bugs, devs, velocidade, dias, anos, bugQ, devQ));
			}
			conexao.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return relatorios;
	}
	
	public void inserir(Relatorio relatorio) {
		try {
			Connection conexao = new Conexao().getConexao();
			
			PreparedStatement inserir = conexao.prepareStatement("insert into javalar (nome,matricula,nome_arquivo,"
					+ "bug_python,bug_javascript,bug_ruby,bug_php,bug_csharp,bug_cmais,bug_c,"
					+ "dev_python,dev_javascript,dev_ruby,dev_php,dev_csharp,dev_cmais,dev_c,"
					+ "v_python,v_javascript,v_ruby,v_php,v_csharp,v_cmais,v_c,"
					+ "d_python,d_javascript,d_ruby,d_php,d_csharp,d_cmais,d_c,"
					+ "a_python,a_javascript,a_ruby,a_php,a_csharp,a_cmais,a_c,"
					+ "bug_q1,bug_q2,bug_q3,bug_q4,"
					+ "dev_q1,dev_q2,dev_q3,dev_q4) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			inserir.setString(1, relatorio.getNome());
			inserir.setString(2, relatorio.getMatricula());
			inserir.setString(3, relatorio.getArquivo());
			for (int i = 0; i < relatorio.getQuantidadeBugs().size(); i++) {
				inserir.setInt(i+4, relatorio.getQuantidadeBugs().get(i));
			}
			for (int i = 0; i < relatorio.getQuantidadeDevs().size(); i++) {
				inserir.setInt(i+11, relatorio.getQuantidadeDevs().get(i));
			}
			for (int i = 0; i < relatorio.getVelocidades().size(); i++) {
				inserir.setInt(i+18, relatorio.getVelocidades().get(i));
			}
			for (int i = 0; i < relatorio.getDias().size(); i++) {
				inserir.setInt(i+25, relatorio.getDias().get(i));
			}
			for (int i = 0; i < relatorio.getAnos().size(); i++) {
				inserir.setInt(i+32, relatorio.getAnos().get(i));
			}
			for (int i = 0; i < relatorio.getQuadrantesBugs().length; i++) {
				inserir.setInt(i+39, relatorio.getQuadrantesBugs()[i]);
			}
			for (int i = 0; i < relatorio.getQuadrantesDevs().length; i++) {
				inserir.setInt(i+43, relatorio.getQuadrantesDevs()[i]);
			}
			inserir.executeUpdate();
			
			conexao.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
