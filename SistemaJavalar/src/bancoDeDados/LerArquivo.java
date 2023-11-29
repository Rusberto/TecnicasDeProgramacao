package bancoDeDados;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LerArquivo {
	File arquivo;
	String nome;
	ArrayList<Integer> python = new ArrayList<>();
	ArrayList<Integer> javaScript = new ArrayList<>();
	ArrayList<Integer> ruby = new ArrayList<>();
	ArrayList<Integer> php = new ArrayList<>();
	ArrayList<Integer> cs = new ArrayList<>();
	ArrayList<Integer> cpp = new ArrayList<>();
	ArrayList<Integer> c = new ArrayList<>();

	ArrayList<Integer> bug = new ArrayList<>();
	ArrayList<Integer> dev = new ArrayList<>();

	public LerArquivo(String nome) {
		this.nome = nome;
		resetPlanetas();
		String[] dados = {};
		try {
			if (nome.endsWith(".csv")) {
				arquivo = new File("arquivos/" + nome);
			}
			else {
				arquivo = new File("arquivos/" + nome + ".csv");
			}
			FileReader ler = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(ler);
			br.readLine();
			while (br.ready()) {
				dados = br.readLine().split(",");
				python.add(Integer.parseInt(dados[1]));
				javaScript.add(Integer.parseInt(dados[2]));
				ruby.add(Integer.parseInt(dados[3]));
				php.add(Integer.parseInt(dados[4]));
				cs.add(Integer.parseInt(dados[5]));
				cpp.add(Integer.parseInt(dados[6]));
				c.add(Integer.parseInt(dados[7]));
				bug.add(Integer.parseInt(dados[8]));
				dev.add(Integer.parseInt(dados[9]));
			}

			br.close();
			ler.close();

		} catch (IOException e) {
//			e.printStackTrace();
		}

	}

	public String getNome() {
		return this.nome;
	}

	public ArrayList<ArrayList<Integer>> getPlanetas() {
		ArrayList<ArrayList<Integer>> planetas = new ArrayList<>();
		planetas.add(python);
		planetas.add(javaScript);
		planetas.add(ruby);
		planetas.add(php);
		planetas.add(cs);
		planetas.add(cpp);
		planetas.add(c);
		return planetas;
	}

	public void resetPlanetas() {
		for (int i = 0; i < getPlanetas().size(); i++) {
			getPlanetas().get(i).clear();
		}
	}

	public ArrayList<Integer> getBug() {
		return bug;
	}

	public ArrayList<Integer> getdev() {
		return dev;
	}

}
