package lista02;

import java.util.Scanner;

public class Questao15 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		Utilidades utilidades = new Utilidades();

		int vetor[] = new int[5];

		System.out.println("defina o vetor 1:");
		utilidades.povoarVetor(vetor, entrada);
		System.out.println("defina o elemento a ser excluido:");
		int elemento = entrada.nextInt();
		
		entrada.close();
		for (int i = 0; i < utilidades.excluirElemento(vetor, elemento).length; i++) {
			if (utilidades.excluirElemento(vetor, elemento)[i] != 0)
				System.out.println(utilidades.excluirElemento(vetor, elemento)[i]);
		}

	}

}
