package cachorroQuenteGeraArvore;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Aluno alunos[] = new Aluno[2];
		
		Scanner entrada1 = new Scanner(System.in);
		Scanner entrada2 = new Scanner(System.in);
		Scanner entrada3 = new Scanner(System.in);
		
		
		for (int i = 0; i < alunos.length; i++) {
			System.out.println("\ndigite o nome:");
			String nome = entrada1.nextLine();
			
			System.out.println("matricula:");
			int matricula = entrada2.nextInt();
			
			System.out.println("quantidade de pedidos:");
			int quantidade = entrada3.nextInt();
			
			alunos[i] = new Aluno(nome, matricula, quantidade);
			alunos[i].setPedido(quantidade);
		}
		entrada1.close();
		entrada2.close();
		entrada3.close();
		for (int i = 0; i < alunos.length; i++) {
			System.out.println("\nnome: " + alunos[i].getNome() + 
					"\nmatricula: " + alunos[i].getMatricula() + 
					"\npedido:" + alunos[i].getPedido());
		}
	}

}
