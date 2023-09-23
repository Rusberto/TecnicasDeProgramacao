package lista02;

import java.util.Scanner;

public class Questao05 {

	public static void main(String[] args) {
		Utilidades utilidades = new Utilidades();
		Scanner entrada = new Scanner(System.in);
		
		int vetor1[] = new int [5];
		int vetor2[] = new int [5];
		
		System.out.println("defina o vetor 1:");
		utilidades.povoarVetor(vetor1, entrada);
		System.out.println("defina o vetor 2:");
		utilidades.povoarVetor(vetor2, entrada);
		System.out.println("defina o elemento:");
		int elemento = entrada.nextInt();
		
		entrada.close();
		System.out.println("\no elemento " + elemento +
				" aparece "+ utilidades.contagem(vetor1, vetor2, elemento)+
				" vezes nos vetores");
		
	}

}
