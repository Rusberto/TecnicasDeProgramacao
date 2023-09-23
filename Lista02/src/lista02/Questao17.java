package lista02;

import java.util.Scanner;

public class Questao17 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Utilidades utilidades = new Utilidades();

		System.out.println("digite um numero:");
		int numero = entrada.nextInt();

		entrada.close();
		
		if (utilidades.verificarNumeroPrimo(numero) == true)
			System.out.println("o número " + numero + " é primo");
		else
			System.out.println("o número " + numero + " não é primo");
	}

}
