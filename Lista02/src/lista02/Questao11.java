package lista02;

import java.util.Scanner;

public class Questao11 {

	public static void main(String[] args) {
		int vetor1[] = new int[5];
		int vetor2[] = new int[5];
		
		Scanner entrada = new Scanner(System.in);
		Utilidades utilidades = new Utilidades();
		
		System.out.println("defina o vetor 1:");
		utilidades.povoarVetor(vetor1, entrada);
		System.out.println("defina o vetor 2:");
		utilidades.povoarVetor(vetor2, entrada);
		
		entrada.close();
		if(utilidades.compararVetores(vetor1, vetor2) == true)
			System.out.println("os vetores são iguais");
		else
			System.out.println("os vetores não são iguais");

	}

}
