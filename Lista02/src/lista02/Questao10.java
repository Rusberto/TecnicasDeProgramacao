package lista02;

import java.util.Random;
import java.util.Scanner;

public class Questao10 {

	public static void main(String[] args) {
		int vetor[] = new int[10];

		Utilidades utilidades = new Utilidades();
		Random numero = new Random();
		Scanner entrada = new Scanner(System.in);

		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = numero.nextInt(11);
		}

		System.out.println("defina a colocação:");
		int k = entrada.nextInt();

		utilidades.imprimirVetores(vetor);
		System.out.println("\n o " + k + "º menor valor é " + utilidades.menorValor(vetor, k));
		entrada.close();
	}

}