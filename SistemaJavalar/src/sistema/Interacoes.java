package sistema;

import java.util.ArrayList;
import java.util.Random;

public class Interacoes {
	
	public void criarBugs( ArrayList<Bug> bugs, int quantidade, ArrayList<Planeta> sistema) {
		Random numero = new Random();
		System.out.println("bugs: ");
		for (int i = bugs.size(), j = 0; j < quantidade; j++, i++) {
			bugs.add(new Bug("bug" + (i + 1), numero.nextInt(16), numero.nextInt(16), sistema));
		}
	}
	public void criarDesenvolvedores( ArrayList<Desenvolvedor> devs ,int quantidade, ArrayList<Planeta> sistema) {
		Random numero = new Random();
		System.out.println("desenvolvedores:");
		for (int i = devs.size(), j = 0; j < quantidade; j++, i++) {
			devs.add(new Desenvolvedor("dev" + (i + 1), numero.nextInt(16), numero.nextInt(16), sistema));
		}
	}
	
	public void colisoes(Planeta planeta, ArrayList<Bug> bugs, ArrayList<Desenvolvedor> devs) {
		int contadorBugs = 0;
		int contadorDevs = 0;
		for (int i = 0; i < bugs.size(); i++) {
			if (bugs.get(i).diminuirVelocidade(planeta)) {
				bugs.remove(i);
				planeta.colisoes[0]+=1;
				contadorBugs++;
			}
		}
		for (int i = 0; i < devs.size(); i++) {
			if (devs.get(i).aumentarVelocidade(planeta)) {
				devs.remove(i);
				planeta.colisoes[1]+=1;
				contadorDevs++;
			}
		}
		condicoes(contadorBugs, contadorDevs, planeta);
	}
	
	public void condicoes(int contBugs, int contDevs, Planeta planeta) {
			imprimirQuantidadeDeBug(contBugs, planeta);
			imprimirQuantidadeDeDevs(contDevs, planeta);
			if (contBugs > contDevs && contDevs != 0)
				System.out.println("os bugs mataram os devs!");
			else if (contDevs > contBugs && contBugs != 0 || contDevs == contBugs && contBugs != 0)
				System.out.println("os devs destruiram os bugs!");
	}
	
	public void imprimirQuantidadeDeBug(int cont, Planeta planeta) {
		if (cont == 1)
			System.out.println("essa não! " + planeta.getNome() + " acaba de ser atingido por um bug!");
		else if (cont > 1)
			System.out.println("essa não! " + planeta.getNome() + " acaba de ser atingido por " + cont + " bugs!");
	}
	public void imprimirQuantidadeDeDevs(int cont, Planeta planeta) {
		if (cont == 1)
			System.out.println("eba! um dev acaba de chegar em " + planeta.getNome() + "!");
		else if (cont > 1)
			System.out.println("eba! " + cont + " devs acabam de chegar em " + planeta.getNome() + "!");
	}
}
