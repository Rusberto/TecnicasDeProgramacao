package sistema;

import java.util.Scanner;

public class Menu {

	public void menu(SistemaJavalar sistema, Scanner entrada) {

		Relatorio relatorio = new Relatorio();

		int opcao;
		do {
		System.out.println("BEM VINDO AO SISTEMA JAVALAR");
		System.out.println("determine um periodo de tempo:");
		sistema.setPeriodos(entrada.nextInt());
		System.out.println("determine a quantidade de bugs no sistema:");
		sistema.bugs(entrada.nextInt());
		System.out.println("determine a quantidade de desenvolvedores no sistema:");
		sistema.desenvolvedores(entrada.nextInt());

		sistema.translacoes();

		System.out.println("escolha uma opcao:\n1-continuar\n2-terminar");
		opcao = entrada.nextInt();

		}while (opcao == 1);
		if (opcao != 1)
			relatorio.relatorio(sistema);
}
}