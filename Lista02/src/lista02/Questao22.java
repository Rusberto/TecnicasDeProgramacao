package lista02;

import java.util.Scanner;

public class Questao22 {
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Utilidades utilidades = new Utilidades();

		System.out.println("defina o tamanho da matriz quadrada:");
		int tamanho = entrada.nextInt();

		entrada.close();
		utilidades.imprimirA(tamanho);
		utilidades.imprimirB1(tamanho);
		utilidades.imprimirB2(tamanho);
		utilidades.imprimirC(tamanho);
		utilidades.imprimirD(tamanho);
		utilidades.imprimirE(tamanho);
	}

}
