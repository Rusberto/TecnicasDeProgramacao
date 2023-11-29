package sistema;

import java.awt.Color;
import java.util.ArrayList;

import bancoDeDados.LerArquivo;

public class SistemaJavalar {
	ArrayList<Planeta> sistema = new ArrayList<>();
	ArrayList<Planeta> sistemaReserva = new ArrayList<>();
	ArrayList<Bug> bugs = new ArrayList<>();
	ArrayList<Desenvolvedor> devs = new ArrayList<>();
	ArrayList<String> planetasExplodidos = new ArrayList<>();

	Sol sol = new Sol("java", 10, 10);
	Interacoes interacoes = new Interacoes();

	LerArquivo arquivo;
	String nomeArquivo;
	int arquivoIndex = 0;
	boolean arquivoLido = false;
	boolean explosao = false;
	ArrayList<ArrayList<Integer>> planetas;

	EscreverAquivoSaida arquivoSaida;
	
	protected int totalPeriodos = 0;

	public SistemaJavalar(String nome) {
		nomeArquivo = nome;
		arquivo = new LerArquivo(nome);
		planetas = arquivo.getPlanetas();

		sistema.add(new Planeta("Python", 9, 7, 4, 24, Color.blue));
		sistema.add(new Planeta("Javascript", 9, 6, 3, 10, Color.yellow));
		sistema.add(new Planeta("Ruby on Rails", 9, 5, 2, 48, Color.white));
		sistema.add(new Planeta("Php", 9, 4, 2, 60, Color.darkGray));
		sistema.add(new Planeta("C#", 9, 3, 1, 4, Color.magenta));
		sistema.add(new Planeta("C++", 9, 2, 2, 0.5, Color.gray));
		sistema.add(new Planeta("C", 9, 1, 10, 0.1, Color.blue));

		sistemaReserva.addAll(sistema);
		for (int i = 0; i < sistema.size(); i++) {
			sistema.get(i).deslocamentoMaximo();
		}
	}
	
	public void criarArquivoSaida() {
		arquivoSaida = new EscreverAquivoSaida(this);
	}
	public void escreverArquivoSaida() {
		arquivoSaida.escrever();
	}

	public void bugs(int quantidade) {
		interacoes.criarBugs(bugs, quantidade, sistema);
	}

	public void desenvolvedores(int quantidade) {
		interacoes.criarDesenvolvedores(devs, quantidade, sistema);
	}

	public void translacoes() {

		setValores();
		for (int i = 0; i < sistema.size(); i++) {
			sistema.get(i).translacao();
			sistema.get(i).calcularAnos();
			interacoes.colisoes(sistema.get(i), bugs, devs);
			sistema.get(i).velocidades.add(sistema.get(i).getDeslocamento());
			explodirPlanetas();
		}
		for (int j = 0; j < sistema.size(); j++) {
			calcularArea(sistema, sistema.get(j));
		}

		quadrantesBugs();
		quadrantesDevs();
	}

	public void explodirPlanetas() {
		for (int i = 0; i < sistema.size(); i++) {
			if (sistema.get(i).getDeslocamento() <= 0) {
				planetasExplodidos.add(sistema.get(i).getNome());
				sistema.remove(i);
				planetas.remove(i);
				explosao = true;
			}
		}
	}

	public int[] quadrantesBugs() {
		int q1 = 0, q2 = 0, q3 = 0, q4 = 0;

		for (int i = 0; i < bugs.size(); i++) {
			if (bugs.get(i).getPosicao()[1] < sol.getPosicao()[1] && bugs.get(i).getPosicao()[0] < sol.getPosicao()[0])
				q1++;
			else if (bugs.get(i).getPosicao()[1] < sol.getPosicao()[1]
					&& bugs.get(i).getPosicao()[0] > sol.getPosicao()[0])
				q2++;
			else if (bugs.get(i).getPosicao()[1] > sol.getPosicao()[1]
					&& bugs.get(i).getPosicao()[0] < sol.getPosicao()[0])
				q3++;
			else if (bugs.get(i).getPosicao()[1] > sol.getPosicao()[1]
					&& bugs.get(i).getPosicao()[0] > sol.getPosicao()[0])
				q4++;
		}

		int[] quadrantes = { q1, q2, q3, q4 };

		return quadrantes;
	}

	public int[] quadrantesDevs() {
		int q1 = 0, q2 = 0, q3 = 0, q4 = 0;

		for (int i = 0; i < devs.size(); i++) {
			if (devs.get(i).getPosicao()[1] < sol.getPosicao()[1] && devs.get(i).getPosicao()[0] < sol.getPosicao()[0])
				q1++;
			else if (devs.get(i).getPosicao()[1] < sol.getPosicao()[1]
					&& devs.get(i).getPosicao()[0] > sol.getPosicao()[0])
				q2++;
			else if (devs.get(i).getPosicao()[1] > sol.getPosicao()[1]
					&& devs.get(i).getPosicao()[0] < sol.getPosicao()[0])
				q3++;
			else if (devs.get(i).getPosicao()[1] > sol.getPosicao()[1]
					&& devs.get(i).getPosicao()[0] > sol.getPosicao()[0])
				q4++;
		}

		int[] quadrantes = { q1, q2, q3, q4 };

		return quadrantes;
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
			altura++;
			largura++;
			areas.add(altura * largura);
		}
	}

	public void setValores() {
		try {
			for (int i = 0; i < sistema.size(); i++) {
				sistema.get(i).setPeriodo(planetas.get(i).get(arquivoIndex));
			}
			bugs(arquivo.getBug().get(arquivoIndex));
			desenvolvedores(arquivo.getdev().get(arquivoIndex));
			arquivoIndex++;
		} catch (IndexOutOfBoundsException e) {
			arquivoLido = true;
		}

	}

	public boolean novoArquivo(String nome) {
		this.arquivoLido = false;
		this.arquivo = new LerArquivo(nome);
		return true;
	}

	public boolean reset() {
		if (arquivoLido == true && this.nomeArquivo != arquivo.getNome()) {
			arquivo = new LerArquivo(nomeArquivo);
			return true;
		} else
			return false;
	}

	public void setArquivoLido(boolean condicao) {
		this.arquivoLido = condicao;
	}

	public void setNomeArquivo(String nome) {
		this.nomeArquivo = nome;
		System.out.println(this.nomeArquivo);
	}

	public void setExplosao(boolean condicao) {
		this.explosao = condicao;
	}

	public boolean getExplosao() {
		return this.explosao;
	}

	public ArrayList<Planeta> getPlanetas() {
		return sistema;
	}
	public ArrayList<String> getPlanetasExplodidos(){
		return planetasExplodidos;
	}

	public ArrayList<Bug> getBugs() {
		return bugs;
	}

	public ArrayList<Desenvolvedor> getDevs() {
		return devs;
	}

	public boolean getArquivoLido() {
		return arquivoLido;
	}
	
	public String getNomeArquivo() {
		return this.nomeArquivo;
	}
	
	public EscreverAquivoSaida getArquivoSaida() {
		return this.arquivoSaida;
	}
}
