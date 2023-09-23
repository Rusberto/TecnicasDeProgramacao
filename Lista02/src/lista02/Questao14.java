package lista02;

import java.util.Scanner;

public class Questao14 {
	
	public static void main(String[] args) {
		int vetor1[] = new int[5];
		int vetor2[] = new int[5];
		
		Scanner entrada = new Scanner(System.in);
		Utilidades utilidades = new Utilidades();
		
		System.out.println("defina vetor 1:");
		utilidades.povoarVetor(vetor1, entrada);
		System.out.println("defina vetor 2:");
		utilidades.povoarVetor(vetor2, entrada);
		
		entrada.close();
		for (int i = 0; i < vetor2.length; i++) {
			if(utilidades.ocorrencia(vetor1, vetor2)[i] != 0)
				System.out.print(utilidades.ocorrencia(vetor1, vetor2)[i] + " ");
		}
	}

}
