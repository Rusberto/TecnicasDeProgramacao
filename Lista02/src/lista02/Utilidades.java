package lista02;

import java.util.Scanner;

public class Utilidades {

	// questao 01
	public int somatorio(int vet[]) {

		int soma = 0;

		for (int i = 2; i < (vet.length - 2); i++) {
			soma += vet[i];
		}
		return soma;
	}

	// questao 02
	public void numerosPares(int min, int max) {
		for (int i = min; i <= max; i++) {
			if (i % 2 == 0)
				System.out.println(i);
		}
	}

	// questao 03
	public double media(int vet1[], int vet2[]) {
		double media = 0;
		for (int i = 0; i < vet1.length; i++) {
			media += (vet1[i] + vet2[i]);
		}
		return media / (vet1.length + vet2.length);
	}

	// questao 04
	public double mediaPonderada(int vet1[], int vet2[]) {
		double mediaPonderada = 0;
		double divisor = 0;
		for (int i = 0; i < vet1.length; i++) {
			mediaPonderada += vet1[i] * vet2[i];
			divisor += vet2[i];
		}
		return mediaPonderada / divisor;
	}

	// questao 05
	public int contagem(int vet1[], int vet2[], int elemento) {
		int contador = 0;
		for (int i = 0; i < vet1.length; i++) {
			System.out.print(vet1[i] + " ");
			if (vet1[i] == elemento)
				contador++;
		}
		System.out.println();
		for (int i = 0; i < vet2.length; i++) {
			System.out.print(vet2[i] + " ");
			if (vet2[i] == elemento)
				contador++;
		}
		return contador;
	}

	// questao 06
	public int[] copiarVetor(int vet1[]) {
		int vetorCopia[] = new int[vet1.length];
		System.out.println(" vetor original");
		imprimirVetores(vet1);
		System.out.println("\n copia do vetor");
		for (int i = 0; i < vetorCopia.length; i++) {
			vetorCopia[i] = vet1[i];
		}
		return vetorCopia;
	}

	// questao 07
	public int[] ordenarCrescente(int vet[]) {

		imprimirVetores(vet);
		for (int i = 0; i < vet.length; i++) {
			for (int j = 0; j < i; j++) {
				if (vet[i] < vet[j]) {
					int auxiliar = vet[i];
					vet[i] = vet[j];
					vet[j] = auxiliar;
				}
			}
		}
		System.out.println("\nvetor ordenado:");
		return vet;
	}

	// questao 08
	public boolean verificarVetor(int vet[]) {
		int contador = 0;

		for (int i = 0; i < vet.length - 1; i++) {
			if (vet[i] < vet[i + 1])
				contador++;
		}
		if (contador == vet.length - 1)
			return true;
		else
			return false;
	}

	// questao 09
	public int maiorValor(int vet[], int k) {
		for (int i = 0; i < vet.length; i++) {
			for (int j = 0; j < i; j++) {
				if (vet[i] > vet[j]) {
					int auxiliar = vet[i];
					vet[i] = vet[j];
					vet[j] = auxiliar;
				}
			}
		}
		return vet[k - 1];
	}

	// questao 10
	public int menorValor(int vet[], int k) {
		for (int i = 0; i < vet.length; i++) {
			for (int j = 0; j < i; j++) {
				if (vet[i] < vet[j]) {
					int auxiliar = vet[i];
					vet[i] = vet[j];
					vet[j] = auxiliar;
				}
			}
		}
		return vet[k - 1];
	}

	// questao 11
	public boolean compararVetores(int vet1[], int vet2[]) {
		int contador = 0;
		for (int i = 0; i < vet2.length; i++) {
			if (vet1[i] == vet2[i])
				contador++;
		}
		if (contador == vet1.length)
			return true;
		else
			return false;
	}

	// questao 12
	public int potencia(int base, int expoente) {
		int auxiliar = base;
		for (int i = 0; i < expoente - 1; i++) {
			base = auxiliar * base;
		}
		return base;
	}

	// questao 13
	public String numeroPrimo(int numero) {

		for (int i = 2; i < numero; i++) {
			if (numero % i == 0)
				return " não é primo";

		}
		return " é primo";

	}

	// questao 14
	public int[] ocorrencia(int vet1[], int vet2[]) {
		int vetor[] = new int[vet1.length];

		for (int i = 0; i < vetor.length; i++) {
			for (int j = 0; j < vetor.length; j++) {
				if (vet1[i] == vet2[j])
					vetor[i] = vet1[i];
			}
		}
		return vetor;
	}

	// questao 15
	public int[] excluirElemento(int vet[], int elemento) {

		int vetor[] = new int[vet.length];
		int auxiliar = 0;

		for (int i = 0; i < vet.length; i++) {
			if (vet[i] != elemento) {
				vetor[auxiliar] = vet[i];
				auxiliar++;
			}
		}
		return vetor;
	}

	// questao 16
	public String palindromo(String palavra) {

		int j = palavra.length() - 1;

		for (int i = 0; i < j; i++) {
			if (palavra.charAt(i) == palavra.charAt(j))
				j--;
			else
				return "não é palindromo";
		}
		return "é palindromo";
	}
	
	//questao 17
	public boolean verificarNumeroPrimo(int numero) {

		for (int i = 2; i < numero; i++) {
			if (numero % i == 0)
				return false;

		}
		return true;

	}

	// questao 18
	public String inverterString(String frase) {
		String fraseInvertida = new StringBuilder(frase).reverse().toString();
		return fraseInvertida;
	}

	// questao 19
	public double jurosCompostos(double valor, double taxa, int periodo) {
		double taxaDeJuros = taxa + 1;
		for (int i = 0; i < periodo - 1; i++) {
			taxaDeJuros = taxaDeJuros * (taxa + 1);
		}
		double juros = valor * taxaDeJuros;
		return juros;
	}

	// questao 20
	public boolean numeroPerfeito(int numero) {
		int contador = 0;
		for (int i = numero - 1; i > 0; i--) {
			if (numero % i == 0)
				contador += i;
		}
		if (contador == numero)
			return true;
		else
			return false;
	}

	// questao 21
	public int diminuirVetor(int numero) {
		int vetor[] = null;
		int tamanho = numero;
		for (int i = 0; i < numero - 1; i++) {
			vetor = new int[tamanho - 1];
			tamanho--;
		}
		return vetor.length;
	}

	// questao 22
	public void imprimirA(int tamanho) {
		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++) {
				if (j <= i)
					System.out.print(j);
				else
					System.out.print(" ");
			}
			System.out.print("\n");
		}
		System.out.println();
	}

	public void imprimirB1(int tamanho) {
		for (int i = 0; i < tamanho; i++) {
			int j;
			for (j = i; j < tamanho + i; j++) {
				if (j % 2 == 0)
					System.out.print(" @ ");
				else
					System.out.print(" * ");
			}
			System.out.print("\n");
		}
		System.out.println();
	}

	public void imprimirB2(int tamanho) {
		for (int i = 0; i < tamanho; i++) {
			if (i == tamanho / 2)
				for (int j = 0; j < tamanho; j++) {
					System.out.print("@");
				}
			else if (i % 2 == 0) {
				for (int j = 0; j < tamanho; j++) {
					if (j == tamanho/2)
						System.out.print("@");
					else
						System.out.print(j);
				}
			} else {
				for (int j = tamanho - 1; j >= 0; j--) {
					if (j == tamanho/2)
						System.out.print("@");
					else
						System.out.print(j);
				}
			}
			System.out.print("\n");
		}
		System.out.println();
	}

	public void imprimirC(int tamanho) {
		int linha = tamanho - 2;
		for (int i = 0; i < tamanho; i++) {
			System.out.print(i);
			for (int j = 1; j < tamanho - 1; j++) {
				if (j == i + j)
					System.out.print(j);
				else if (i == tamanho - 1)
					System.out.print(linha--);
				else
					System.out.print("*");
			}
			System.out.print(tamanho - 1 - i);
			System.out.print("\n");
		}
		System.out.println();
	}

	public void imprimirD(int tamanho) {
		for (int i = 0; i < tamanho; i++) {
			if (i < tamanho / 2) {
				for (int j = 0; j < tamanho; j++) {
					if (j < tamanho / 2)
						System.out.print("# ");
					else if (j == tamanho / 2)
						System.out.print("| ");
					else
						System.out.print("! ");
				}
			} else if (i == tamanho / 2) {
				for (int j = 0; j < tamanho; j++) {
					System.out.print("= ");
				}
			} else {
				for (int j = 0; j < tamanho; j++) {
					if (j < tamanho / 2)
						System.out.print("* ");
					else if (j == tamanho / 2)
						System.out.print("| ");
					else
						System.out.print("% ");
				}
			}
			System.out.print("\n");
		}
		System.out.println();
	}

	public void imprimirE(int tamanho) {
		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++) {
				if (j == i || j == tamanho - 1 - i)
					System.out.print(j);
				else
					System.out.print("*");
			}
			System.out.print("\n");
		}
		System.out.println();
	}

	// funcionalidades gerais
	public void imprimirVetores(int vet1[]) {
		for (int i = 0; i < vet1.length; i++) {
			System.out.print(" " + vet1[i] + " ");
		}
		System.out.println();
	}

	public void povoarVetor(int vet[], Scanner entrada) {
		for (int i = 0; i < vet.length; i++) {
			vet[i] = entrada.nextInt();
		}
	}
}
