package sistema;

import java.util.ArrayList;

public class Desenvolvedor extends Corpo {

	public Desenvolvedor(String nome, int y, int x, ArrayList<Planeta> planetas) {
		super(nome, y, x);
		checarPosicoes(planetas);
	}

	public boolean aumentarVelocidade(Planeta planeta) {
		if (planeta.getPosicao()[0] == this.getPosicao()[0] && planeta.getPosicao()[1] == this.getPosicao()[1]) {
			planeta.setDeslocamento(planeta.getDeslocamento() + 1);
			return true;
		}
		else
			return false;
	}

}
