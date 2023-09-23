package lista02;

import java.util.Scanner;

public class Questao12 {
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		Utilidades utilidades = new Utilidades();
		
		System.out.println("defina a base:");
		int base = entrada.nextInt();
		System.out.println("defina o expoente:");
		int expoente = entrada.nextInt();
		
		entrada.close();
		System.out.println(base + " elevado a " + expoente + " é igual a "+ utilidades.potencia(base, expoente));
		
	}
}
