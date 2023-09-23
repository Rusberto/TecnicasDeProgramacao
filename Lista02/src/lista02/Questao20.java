package lista02;

import java.util.Scanner;

public class Questao20 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Utilidades utilidades = new Utilidades();
		
		System.out.println("digite um número:");
		int numero = entrada.nextInt();
		
		entrada.close();
		if(utilidades.numeroPerfeito(numero) == true)
			System.out.println(numero + " é um número perfeito");
		else
			System.out.println(numero + " não é um número perfeito");
	}

}
