package sistema;

import java.util.ArrayList;
import java.util.Random;

public class Interacoes {
	
	public void criarBugs( ArrayList<Bug> bugs, int quantidade, ArrayList<Planeta> sistema) {
		Random numero = new Random();
		for (int i = bugs.size(), j = 0; j < quantidade; j++, i++) {
			bugs.add(new Bug("bug" + (i + 1), numero.nextInt(20), numero.nextInt(20), sistema));
		}
	}
	public void criarDesenvolvedores( ArrayList<Desenvolvedor> devs ,int quantidade, ArrayList<Planeta> sistema) {
		Random numero = new Random();
		for (int i = devs.size(), j = 0; j < quantidade; j++, i++) {
			devs.add(new Desenvolvedor("dev" + (i + 1), numero.nextInt(20), numero.nextInt(20), sistema));
		}
	}
	
	public void colisoes(Planeta planeta, ArrayList<Bug> bugs, ArrayList<Desenvolvedor> devs) {
		for (int i = 0; i < bugs.size(); i++) {
			if (bugs.get(i).diminuirVelocidade(planeta)) {
				bugs.remove(i);
				planeta.colisoes[0]+=1;
			}
		}
		for (int i = 0; i < devs.size(); i++) {
			if (devs.get(i).aumentarVelocidade(planeta)) {
				devs.remove(i);
				planeta.colisoes[1]+=1;
			}
		}
	}
}
