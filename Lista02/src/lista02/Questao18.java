package lista02;

import java.util.Scanner;

public class Questao18 {
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		Utilidades utilidades = new Utilidades();

		System.out.println("digite o texto a ser invertido:");
		String frase = entrada.nextLine();
		
		entrada.close();
		System.out.println(utilidades.inverterString(frase));
	}

}
