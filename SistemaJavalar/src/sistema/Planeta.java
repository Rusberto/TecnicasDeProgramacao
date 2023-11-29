package sistema;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

public class Planeta extends Corpo {

	public  int periodo = 0;
	private int deslocamento;
	private int distanciaDeJava;
	private int deslocamentoTotal = 0;
	private int anos = 0;
	private double horas;
	private double horasTotais = 0;
	Color cor;
	BufferedImage image;
	
	private int posicaoMaxima[] = new int[2];
	protected int colisoes[] = new int[2];
	ArrayList<Integer> velocidades = new ArrayList<>();

	
	public Planeta(String nome, int y, int x, int deslocamento, double horas, Color cor) {
		super(nome, y, x);
		this.distanciaDeJava = (x - 10);
		this.deslocamento = deslocamento;
		this.horas = horas;
		this.velocidades.add(deslocamento);
		this.cor = cor;
		try {
			this.image = ImageIO.read(new File("Sprites/" + nome + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deslocamentoMaximo() {
		int centro = 9;

		this.posicaoMaxima[0] = getPosicao()[0] + (getPosicao()[1] - centro);
		this.posicaoMaxima[1] = getPosicao()[0] - (getPosicao()[1] - centro);
	}

	public double rotacao() {
		horasTotais += horas * periodo;
		return horasTotais;
	}

	public void translacao() {
		final Timer timer = new Timer();
		deslocamentoTotal += deslocamento * periodo;
		for (int i = 0; i < deslocamento * periodo; i++) {
			if      (getPosicao()[0] == posicaoMaxima[1] && getPosicao()[1] > posicaoMaxima[0])
				getPosicao()[1]--;
			else if (getPosicao()[0] == posicaoMaxima[0] && getPosicao()[1] < posicaoMaxima[1])
				getPosicao()[1]++;
			else if (getPosicao()[1] == posicaoMaxima[1] && getPosicao()[0] < posicaoMaxima[1])
				getPosicao()[0]++;
			else if (getPosicao()[1] == posicaoMaxima[0] && getPosicao()[0] > posicaoMaxima[0])
				getPosicao()[0]--;
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
	
	public Color getCor() {
		return this.cor;
	}
	public BufferedImage getimage() {
		return this.image;
	}
	public int getPeriodo() {
		return this.periodo;
	}
	public double getHoras() {
		return this.horasTotais;
	}
	
	public void setDeslocamento(int deslocamento) {
		this.deslocamento = deslocamento;
	}
	
	public void setPeriodo (int periodo) {
		this.periodo = periodo;
	}

}
