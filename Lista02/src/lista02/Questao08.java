package lista02;

import java.util.Scanner;

public class Questao08 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Utilidades utilidades = new Utilidades();
		int vetor[] = new int[5];

		System.out.println("defina o vetor:");
		utilidades.povoarVetor(vetor, entrada);
		
		entrada.close();
		if (utilidades.verificarVetor(vetor) == true)
			System.out.println("o vetor está em ordem crescente");
		else
			System.out.println("o vetor não está em ordem crescente");

	}

}
