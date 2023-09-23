package lista02;

import java.util.Scanner;

public class Questao21 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Utilidades utilidades = new Utilidades();
		
		System.out.println("digite um numero:");
		int numero = entrada.nextInt();
		
		entrada.close();
		System.out.println(utilidades.diminuirVetor(numero));
	}

}
