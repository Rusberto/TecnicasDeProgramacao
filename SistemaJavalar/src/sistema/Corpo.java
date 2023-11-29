package sistema;

import java.util.ArrayList;
import java.util.Random;

public abstract class Corpo {
	private String nome;
	private int posicao[] = new int[2];
	
	public Corpo(String nome, int y, int x) {
		this.setNome(nome);
		this.posicao[0] = y;
		this.posicao[1] = x;
	}
	
	public void checarPosicoes(ArrayList<Planeta> planetas) {
		for (int i = 0; i < planetas.size(); i++) {
			if( this.posicao[0] == planetas.get(i).getPosicao()[0]&& this.posicao[1] == planetas.get(i).getPosicao()[1]
					|| this.posicao[1] == 8  && this.posicao[0] == 8 || this.posicao[1] == 8  && this.posicao[0] == 9 || this.posicao[1] == 8  && this.posicao[0] == 10
					|| this.posicao[1] == 9  && this.posicao[0] == 8 || this.posicao[1] == 9  && this.posicao[0] == 9 || this.posicao[1] == 9  && this.posicao[0] == 10
					|| this.posicao[1] == 10 && this.posicao[0] == 8 || this.posicao[1] == 10 && this.posicao[0] == 9 || this.posicao[1] == 10 && this.posicao[0] == 10) {
				Random numero = new Random();
				this.posicao[0] = numero.nextInt(16);
				this.posicao[1] = numero.nextInt(16);
			}
		}
	}

	public String getNome() {
		return nome;
	}
	public int[] getPosicao() {
		return posicao;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setPosicao(int i, int j) {
		this.posicao[0] = i;
		this.posicao[1] = j;
	}
}
