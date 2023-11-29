package sistema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import bancoDeDados.RelatorioDAO;

public class Relatorio {
	
	private RelatorioDAO relatorioDAO;
	
	private String nome;

	private String matricula;
	private String arquivo;
	private ArrayList<Integer> quantidadeBugs;
	private ArrayList<Integer> quantidadeDevs;
	private ArrayList<Integer> velocidades;
	private ArrayList<Integer> dias;
	private ArrayList<Integer> anos;
	int[] quadrantesBugs = {0,0,0,0};
	int[] quadrantesDevs = {0,0,0,0};
	
	public Relatorio(SistemaJavalar sistema) {
		relatorioDAO = new RelatorioDAO();
		
		nome = "Antonio Roberto";
		matricula = "537837";
		arquivo = sistema.getNomeArquivo();
		quantidadeBugs = new ArrayList<>();
		quantidadeDevs = new ArrayList<>();
		velocidades = new ArrayList<>();
		dias = new ArrayList<>();
		anos = new ArrayList<>();
		
		for (int i = 0; i < sistema.sistemaReserva.size(); i++) {
			quantidadeBugs.add(sistema.sistemaReserva.get(i).colisoes[0]);
			quantidadeDevs.add(sistema.sistemaReserva.get(i).colisoes[1]);
			velocidades.add((int) sistema.sistemaReserva.get(i).calcularVelocidadeMedia());
			dias.add((int) sistema.sistemaReserva.get(i).getHoras());
			anos.add(sistema.sistemaReserva.get(i).getAnos());
		}
	}
	
	public Relatorio(String nome, String matricula, String arquivo, int[] bugs, int[] devs, int[] velocidade, int[] dias, int[] anos, int[] bugQ, int[] devQ) {
		
		this.nome = nome;
		this.matricula = matricula;
		this.arquivo = arquivo;
		this.quantidadeBugs = new ArrayList<>();
		this.quantidadeDevs = new ArrayList<>();
		this.velocidades    = new ArrayList<>();
		this.dias           = new ArrayList<>();
		this.anos           = new ArrayList<>();
		
		for (int i = 0; i < bugs.length; i++) {
			quantidadeBugs.add(bugs[i]);
			quantidadeDevs.add(devs[i]);
			velocidades.add(velocidade[i]);
			this.dias.add(dias[i]);
			this.anos.add(anos[i]);
		}
		quadrantesBugs = bugQ;
		quadrantesDevs = devQ;
		}
	
	public void inserirRelatorio(Relatorio relatorio) {
		relatorioDAO.inserir(relatorio);
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public String getArquivo() {
		return arquivo;
	}
	
	public ArrayList<Integer> getQuantidadeBugs() {
		return quantidadeBugs;
	}
	
	public ArrayList<Integer> getQuantidadeDevs() {
		return quantidadeDevs;
	}
	
	public ArrayList<Integer> getVelocidades() {
		return velocidades;
	}
	
	public ArrayList<Integer> getDias(){
		return dias;
	}
	
	public ArrayList<Integer> getAnos() {
		return anos;
	}
	
	public int[] getQuadrantesBugs() {
		return quadrantesBugs;
	}
	
	public int[] getQuadrantesDevs() {
		return quadrantesDevs;
	}
	
	public SistemaJavalar getSistema() {
		return new SistemaJavalar(arquivo);
	}
}
