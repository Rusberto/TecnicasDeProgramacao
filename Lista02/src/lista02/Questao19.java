package lista02;

import java.util.Scanner;

public class Questao19 {
 
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Utilidades utilidades = new Utilidades();
		
		System.out.println("determine o valor inicial:");
		double valorInicial = entrada.nextDouble();
		System.out.println("determine a taxa de juros:");
		double taxaDeJuros = entrada.nextDouble();
		System.out.println("determine o periodo:");
		int periodo = entrada.nextInt();
		
		entrada.close();
		System.out.print(String.format("%.2f", utilidades.jurosCompostos(valorInicial, taxaDeJuros, periodo)));
		
	}

}
