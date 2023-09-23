package lista02;

import java.util.Random;

public class Questao01 {
	public static void main(String[] args) {
		int vetor[] = new int[10];
		Random numero = new Random();
		Utilidades utilidades = new Utilidades();
		
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = numero.nextInt(11);
			System.out.print( " " + vetor[i] + " ");
		}
		
		System.out.println("\n" + "A soma do 3º ao " + (vetor.length-2) + "º termo é igual a " + utilidades.somatorio(vetor));
		

	}

}
