package lista02;

import java.util.Random;

public class Questao03 {
	
	public static void main(String[] args) {
		int vetor1[] = new int [10];
		int vetor2[] = new int [10];
		
		Random numero = new Random();
		Utilidades utilidades = new Utilidades();
		
		for (int i = 0; i < vetor1.length; i++) {
			vetor1[i] = numero.nextInt(11);
			vetor2[i] = numero.nextInt(11);
		}
		utilidades.imprimirVetores(vetor1);
		utilidades.imprimirVetores(vetor2);
		System.out.println("\na média dos dois vetores é " + utilidades.media(vetor1, vetor2));
		
	}
}
