package sistema;

import java.util.ArrayList;

public class Planeta extends Corpo {

	public  int periodo = 1;
	private int deslocamento;
	private int distanciaDeJava;
	private int deslocamentoTotal = 0;
	private int anos = 0;
	private double horas;
	private double horasTotais = 0;
	
	private int posicaoMaxima[] = new int[2];
	protected int colisoes[] = new int[2];
	ArrayList<Integer> velocidades = new ArrayList<>();

	
	public Planeta(String nome, int y, int x, int deslocamento, double horas) {
		super(nome, y, x);
		this.distanciaDeJava = (x - 8);
		this.deslocamento = deslocamento;
		this.horas = horas;
		this.velocidades.add(deslocamento);
	}

	public void deslocamentoMaximo() {
		int centro = 8;

		this.posicaoMaxima[0] = getPosicao()[0] + (getPosicao()[1] - centro);
		this.posicaoMaxima[1] = getPosicao()[0] - (getPosicao()[1] - centro);
	}

	public double rotacao() {
		horasTotais += horas * periodo;
		return horasTotais;
	}

	public void translacao() {
		deslocamentoTotal += deslocamento * periodo;
		for (int i = 0; i < deslocamento * periodo; i++) {
			if      (getPosicao()[1] == posicaoMaxima[0] && getPosicao()[0] > posicaoMaxima[1])
				getPosicao()[0]--;
			else if (getPosicao()[1] == posicaoMaxima[1] && getPosicao()[0] < posicaoMaxima[0])
				getPosicao()[0]++;
			else if (getPosicao()[0] == posicaoMaxima[1] && getPosicao()[1] > posicaoMaxima[1])
				getPosicao()[1]--;
			else if (getPosicao()[0] == posicaoMaxima[0] && getPosicao()[1] < posicaoMaxima[0])
				getPosicao()[1]++;
		}
	}
	
	public void calcularAnos() {
		int total = this.deslocamentoTotal;
		this.anos = 0;
		while (total >= distanciaDeJava * 8) {
			anos++;
			total -= distanciaDeJava * 8;
		}
	}
	
	public double calcularVelocidadeMedia() {
		double soma = 0;
		for (int i = 0; i < velocidades.size()-1; i++) {
			soma += velocidades.get(i);
		}
		return soma/velocidades.size();
	}
	
	public int getDeslocamento() {
		return this.deslocamento;
	}
	
	public int getAnos() {
		return this.anos;
	}
	
	public void setDeslocamento(int deslocamento) {
		this.deslocamento = deslocamento;
	}
	
	public void setPeriodo (int periodo) {
		this.periodo = periodo;
	}

}
