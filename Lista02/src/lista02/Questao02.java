package lista02;

import java.util.Scanner;

public class Questao02 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Utilidades utilidades = new Utilidades();
		
		System.out.println("imprima os numeros pares de ");
		int minimo = entrada.nextInt();
		System.out.println("ate");
		int maximo = entrada.nextInt();
		
		entrada.close();
		
		utilidades.numerosPares(minimo, maximo);

	}

}
