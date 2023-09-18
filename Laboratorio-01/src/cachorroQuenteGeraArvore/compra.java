package cachorroQuenteGeraArvore;

import java.util.Scanner;

public class compra {

	public static void imprimirOpcoes(String vet[]) {
		for (int i = 0; i < vet.length; i++) {
			System.out.println(i + 1 + "-" + vet[i]);
		}
	}

	public static void imprimirPedido(String vet[]) {
		System.out.println("proteina: " + vet[0]);
		System.out.println("queijo: " + vet[1]);
		System.out.println("adicionais: " + vet[2]);
		System.out.println("bebida: " + vet[3]);
	}

	public static String escolhaAdicionais(String adicionais[], Scanner entrada) {
		String escolhas[] = new String[adicionais.length];
		String pedido = "";
		for (int i = 0; i < escolhas.length - 1; i++) {
			entrada = new Scanner(System.in);
			escolhas[i] = adicionais[entrada.nextInt() - 1];
		}
		for (int i = 0; i < escolhas.length - 1; i++) {
			if (escolhas[i] != "nenhum" && escolhas[i] != escolhas[i + 1])
				pedido += escolhas[i] + " ";
			else
				pedido = "nenhum";
		}

		return pedido;
	}

	public static String[] cardapio() {
		String proteina[] = { "salsicha", "linguiça", "frango", "bacon" };
		String queijo[] = { "mussarela", "prato", "parmesão", "coalho" };
		String adicionais[] = { "nenhum", "maionese", "ketchup", "ovo", "batata palha" };
		String bebida[] = { "coca-cola", "del rio", "suco do chaves" };

		Scanner entrada = new Scanner(System.in);

		String pedido[] = new String[4];

		System.out.println("escolha a opção de proteina:");
		imprimirOpcoes(proteina);
		pedido[0] = proteina[entrada.nextInt() - 1];

		System.out.println("escolha a opção de queijo:");
		imprimirOpcoes(queijo);
		pedido[1] = queijo[entrada.nextInt() - 1];

		System.out.println("escolha as opções de adicionais:");
		imprimirOpcoes(adicionais);
		pedido[2] = escolhaAdicionais(adicionais, entrada);

		System.out.println("escolha a opção de bebida:");
		imprimirOpcoes(bebida);
		pedido[3] = bebida[entrada.nextInt() - 1];

		imprimirPedido(pedido);
		return pedido;
	}
}
