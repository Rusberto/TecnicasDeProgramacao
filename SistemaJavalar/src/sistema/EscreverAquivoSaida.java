package sistema;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import bancoDeDados.RelatorioDAO;

public class EscreverAquivoSaida {

	private ArrayList<Planeta> planetas;
	private String nome = "";
	private String matricula = "";
	private String[] sobrevivenciaPlanetas = { "", "" };
	private int[] quadrantes = { 0, 0};
	private int totalInstantes = 0;
	private double[] velocidades = {0,0,0,0,0,0,0};
	private int totalBugs = 0;
	private int totalDevs = 0;
	private int totalTempo = 0;
	private int totalAnos = 0;

	final int FATOR= 20000;
	
	public EscreverAquivoSaida(SistemaJavalar sistema) {
		ArrayList<Relatorio> relatorios = new RelatorioDAO().ler();
		planetas = new SistemaJavalar(relatorios.get(0).getArquivo()).getPlanetas();
		int count = 0;

		for (int i = 0; i < relatorios.size()/FATOR; i++) {
			int cont = 0;
			alunoQueMaisApareceu(relatorios, count, cont, i);
			planetaQueMaisExplodiu(relatorios, i);
			planetaQueMaisVive(relatorios, i);
		}
		calcularVelocidade(relatorios);
		calcularDias(relatorios);
		calcularAnos(relatorios);
		
		System.out.println(nome);
		System.out.println(matricula);
		
		quadrantes(relatorios);
		totalInstantes = relatorios.size();
	}
	
	public void escrever() {
		File novoArquivo = new File("arquivosSaida/arquivoDeSaida.txt");
		try {
			novoArquivo.createNewFile();
			FileWriter escrever = new FileWriter(novoArquivo, true);
			escrever.write("\n" + nome + "; ");
			escrever.write(matricula + "; ");
			escrever.write(sobrevivenciaPlanetas[0] + "; "); escrever.write(sobrevivenciaPlanetas[1] + "; ");
			escrever.write(quadrantes[0] + "; "); escrever.write(quadrantes[1] + "; ");
			escrever.write(totalInstantes + "; ");
			for (int i = 0; i < velocidades.length; i++) {
				escrever.write(planetas.get(i).getNome() + ":" + velocidades[i] + "; ");
			}
			escrever.write(totalBugs + "; "); escrever.write(totalDevs + "; ");
			escrever.write(totalTempo + "; "); escrever.write(totalAnos + "; ");
			escrever.close();
			
		} catch (Exception e) {
			System.out.println("erro");
			e.printStackTrace();
		}
	}

	public void alunoQueMaisApareceu(ArrayList<Relatorio> relatorios, int count, int cont, int i) {
		for (int j = 0; j < relatorios.size()/FATOR; j++) {
			if (relatorios.get(i).getNome() == relatorios.get(j).getNome()) {
				cont++;
				}
			if (count < cont) {
				this.nome = relatorios.get(i).getNome();
				this.matricula = relatorios.get(i).getMatricula();
				count = cont;
			}
		}
	}

	public void planetaQueMaisExplodiu(ArrayList<Relatorio> relatorios, int i) {
		for (int j = 0; j < relatorios.get(i).getVelocidades().size(); j++) {
			if (relatorios.get(i).getVelocidades().get(j) == 0) {
				int posicao = j;
				if (relatorios.get(j).getVelocidades().get(posicao) == 0) {
					sobrevivenciaPlanetas[0] = planetas.get(posicao).getNome();
				}
			}
		}
	}

	public void planetaQueMaisVive(ArrayList<Relatorio> relatorios, int i) {
		for (int j = 0; j < planetas.size(); j++) {
			if (relatorios.get(i).getVelocidades().get(j) != 0) {
				int posicao = j;
				if (relatorios.get(j).getVelocidades().get(posicao) != 0) {
					sobrevivenciaPlanetas[1] = planetas.get(posicao).getNome();
				} else {
					posicao++;
				}

			}
		}
	}

	public void quadrantes(ArrayList<Relatorio> relatorios) {
		int[] quantidadeBugs = { 0, 0, 0, 0 };
		for (int j = 0; j < relatorios.get(0).getQuadrantesBugs().length; j++) {
			int k = 0;
			while(k<relatorios.size()/FATOR) {
				quantidadeBugs[j] += relatorios.get(k).getQuadrantesBugs()[j];
				k++;
			}
			
		}
		for (int i = 0; i < quantidadeBugs.length; i++) {
			totalBugs += quantidadeBugs[i];
		}
		
		int[] quantidadeDevs = {0,0,0,0};
		for (int j = 0; j < relatorios.get(0).getQuadrantesDevs().length; j++) {
			int k = 0;
			while(k<relatorios.size()/FATOR) {
				quantidadeDevs[j] += relatorios.get(k).getQuadrantesDevs()[j];
				k++;
			}	
		}
		for (int i = 0; i < quantidadeDevs.length; i++) {
			totalDevs += quantidadeDevs[i];
		}
		
		contarElementos(quantidadeBugs, 0);
		contarElementos(quantidadeDevs, 1);
	}
	
	public void contarElementos(int[] vetor, int num) {

		int max = vetor[0];
		for (int i = 0; i < vetor.length; i++) {
			if(max<vetor[i]) {
				max = vetor[i];
				quadrantes[num] = i;
			}
		}
	}
	
	public void calcularVelocidade(ArrayList<Relatorio> relatorio) {
		for (int i = 0; i < velocidades.length; i++) {
			for (int j = 0; j < relatorio.size()/FATOR; j++) {
				velocidades[i] += (double)relatorio.get(j).getVelocidades().get(i);
			}
			velocidades[i] = velocidades[i]/relatorio.size();
		}
	}
	
	public void calcularDias(ArrayList<Relatorio> relatorio) {
		for (int i = 0; i < relatorio.size()/FATOR; i++) {
				for (int j = 0; j < relatorio.get(i).getDias().size(); j++) {
					totalTempo += relatorio.get(i).getDias().get(j);
				}
		}
	}
	
	public void calcularAnos(ArrayList<Relatorio> relatorio) {
		for (int i = 0; i < relatorio.size()/FATOR; i++) {
			for (int j = 0; j < relatorio.get(i).getAnos().size(); j++) {
				totalAnos += relatorio.get(i).getAnos().get(j);
			}
		}
	}
}
