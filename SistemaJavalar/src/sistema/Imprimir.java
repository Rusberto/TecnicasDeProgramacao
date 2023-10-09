package sistema;

import java.util.ArrayList;

public class Imprimir {

	public void imprimirDias(ArrayList<Planeta> sistema) {
		System.out.println("quantidade de dias em cada planeta:");
		for (int i = 0; i < sistema.size(); i++) {
			double dias = sistema.get(i).rotacao();
			if (dias >= 24)
				System.out.printf("passaram-se %.0f dias (%.2f horas) em %s\n", (dias / 24),
						dias, sistema.get(i).getNome());
			else
				System.out.printf("passaram-se %.2f horas em %s\n", sistema.get(i).rotacao(), sistema.get(i).getNome());
		}
		System.out.println();
	}

	public void imprimirAnos(ArrayList<Planeta> sistema) {
		System.out.println("quantidade de anos em cada planeta: ");
		for (int i = 0; i < sistema.size(); i++) {
			if (sistema.get(i).getAnos() > 0)
				System.out.println(
						"passaram-se " + sistema.get(i).getAnos() + " anos em " + sistema.get(i).getNome());
		}
		System.out.println();
	}

	public void imprimirVelocidades(ArrayList<Planeta> sistema) {
		System.out.println("velocidade de cada planeta (em quadros por periodo): ");
		for (int i = 0; i < sistema.size(); i++) {
			System.out.println("velocidade de " + sistema.get(i).getNome() + ": " + sistema.get(i).getDeslocamento() + " q/p");
		}
		System.out.println();
	}

	public void imprimirDistancias(ArrayList<Planeta> sistema, Planeta planeta, ArrayList<Integer> areas) {
		for (int i = sistema.indexOf(planeta); i < sistema.size(); i++) {
			if (planeta.getNome() != sistema.get(i).getNome())
				System.out.println(
						"distancia de " + planeta.getNome() + " e " + sistema.get(i).getNome() + ": " + areas.get(i));
		}
	}
}
