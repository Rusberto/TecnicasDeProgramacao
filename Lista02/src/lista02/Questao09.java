package lista02;

import java.util.Random;
import java.util.Scanner;

public class Questao09 {

	public static void main(String[] args) {
		int vetor[] = new int[10];
		
		Random numero = new Random();
		Scanner entrada = new Scanner(System.in);
		Utilidades utilidades = new Utilidades();
		
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = numero.nextInt(11);
		}
		
		System.out.println("defina a colocação:");
		int k = entrada.nextInt();
		
		utilidades.imprimirVetores(vetor);
		System.out.println("\n o " + k + "º maior valor é " + utilidades.maiorValor(vetor, k));
		entrada.close();
	}

}
