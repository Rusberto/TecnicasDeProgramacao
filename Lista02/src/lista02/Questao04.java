package lista02;

import java.util.Random;

public class Questao04 {
	
	public static void main(String[] args) {
		int notas[] = new int [5];
		int pesos[] = new int [5];
		
		Random numero = new Random();
		Utilidades utilidades = new Utilidades();
		
		for (int i = 0; i < notas.length; i++) {
			notas[i] = numero.nextInt(11);
			pesos[i] = numero.nextInt(10 - 1 + 1);
		}
		
		System.out.println("notas:");
		utilidades.imprimirVetores(notas);
		System.out.println("pesos:");
		utilidades.imprimirVetores(pesos);
		System.out.println("a média ponderada é " + String.format("%.2f", utilidades.mediaPonderada(notas, pesos)));

	}

}
