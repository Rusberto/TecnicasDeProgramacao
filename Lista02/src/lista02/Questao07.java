package lista02;

import java.util.Random;

public class Questao07 {

	public static void main(String[] args) {
		int vetor[] = new int[10];

		Random numero = new Random();
		Utilidades utilidades = new Utilidades();

		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = numero.nextInt(11);
		}
		
		utilidades.imprimirVetores(utilidades.ordenarCrescente(vetor));
	}

}
