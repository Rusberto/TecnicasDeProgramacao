package sistema;

import java.util.ArrayList;

public class SistemaJavalar {
	ArrayList<Planeta> sistema = new ArrayList<>();
	ArrayList<Planeta> sistemaReserva = new ArrayList<>();
	ArrayList<Bug> bugs = new ArrayList<>();
	ArrayList<Desenvolvedor> devs = new ArrayList<>();
	ArrayList<String> planetasExplodidos = new ArrayList<>();

	Sol sol = new Sol("java", 8, 8);
	Interacoes interacoes = new Interacoes();
	Imprimir imprimir = new Imprimir();
	
	protected int totalPeriodos = 0;

	public SistemaJavalar() {
		sistema.add(new Planeta("Python", 8, 9, 4, 24));
		sistema.add(new Planeta("Javascript", 8, 10, 3, 10));
		sistema.add(new Planeta("Ruby on Rails", 8, 11, 2, 48));
		sistema.add(new Planeta("Php", 8, 12, 2, 60));
		sistema.add(new Planeta("C#", 8, 13, 1, 4));
		sistema.add(new Planeta("C++", 8, 14, 2, 0.5));
		sistema.add(new Planeta("C", 8, 15, 10, 0.1));

		sistemaReserva.addAll(sistema);
		for (int i = 0; i < sistema.size(); i++) {
			sistema.get(i).deslocamentoMaximo();
		}
	}

	public void bugs(int quantidade) {
		interacoes.criarBugs(bugs, quantidade, sistema);
		for (int i = 0; i < bugs.size(); i++) {
			System.out.println(bugs.get(i).getNome() + "(" + bugs.get(i).getPosicao()[0] + "," + bugs.get(i).getPosicao()[1] + ")");			
		}
		System.out.println();
	}

	public void desenvolvedores(int quantidade) {
		interacoes.criarDesenvolvedores(devs, quantidade, sistema);
		for (int i = 0; i < devs.size(); i++) {
			System.out.println(devs.get(i).getNome() + "(" + devs.get(i).getPosicao()[0] + "," + devs.get(i).getPosicao()[1] + ")");				
		}
		System.out.println();
	}

	public void translacoes() {
		for (int i = 0; i < sistema.size(); i++) {
			sistema.get(i).translacao();
			sistema.get(i).calcularAnos();
			interacoes.colisoes(sistema.get(i), bugs, devs);
			sistema.get(i).velocidades.add(sistema.get(i).getDeslocamento());
			explodirPlanetas();
		}
		System.out.println();
		System.out.println("distancias entre cada planeta:");
		for (int j = 0; j < sistema.size(); j++) {
			calcularArea(sistema, sistema.get(j));
		}
		
		norteSul();
		
		imprimir.imprimirVelocidades(sistema);
		imprimir.imprimirDias(sistema);
		imprimir.imprimirAnos(sistema);
	}

	public void explodirPlanetas() {
		for (int i = 0; i < sistema.size(); i++) {
			if (sistema.get(i).getDeslocamento() <= 0) {
				System.out.println(sistema.get(i).getNome() + " acaba de explodir!");
				planetasExplodidos.add(sistema.get(i).getNome());
				sistema.remove(i);
			}
		}
	}

	public void norteSul() {
		int norte = 0;
		int sul = 0;
		for (int i = 0; i < sistema.size(); i++) {
			if (sistema.get(i).getPosicao()[1] > sol.getPosicao()[1])
				norte++;
			else
				sul++;
		}
		System.out.println();
		if (norte != 0)
			System.out.println("há " + norte + " planetas ao norte de java");
		if (sul != 0)
			System.out.println("há " + sul + " planetas ao sul de java");
		System.out.println();
	}

	public void calcularArea(ArrayList<Planeta> sistema, Planeta planeta) {
		ArrayList<Integer> areas = new ArrayList<>();
		for (int i = 0; i < sistema.size(); i++) {
			int largura = 0;
			int altura = 0;
			if (planeta.getPosicao()[0] > sistema.get(i).getPosicao()[0])
				largura = planeta.getPosicao()[0] - sistema.get(i).getPosicao()[0];
			else
				largura = sistema.get(i).getPosicao()[0] - planeta.getPosicao()[0];
			if (planeta.getPosicao()[1] > sistema.get(i).getPosicao()[1])
				altura = planeta.getPosicao()[1] - sistema.get(i).getPosicao()[1];
			else
				altura = sistema.get(i).getPosicao()[1] - planeta.getPosicao()[1];
			altura++; largura++;
			areas.add(altura * largura);
		}
		imprimir.imprimirDistancias(sistema, planeta, areas);
	}
	
	public void setPeriodos(int periodo) {
		totalPeriodos += periodo;
		for (int i = 0; i < sistema.size(); i++) {
			sistema.get(i).setPeriodo(periodo);
		}
	}
}
