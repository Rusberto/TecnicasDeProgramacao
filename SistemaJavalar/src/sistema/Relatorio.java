package sistema;

public class Relatorio {
	
	private String resumo[] = {"\nÉ uma linguagem de programação de alto nível, interpretada de script, imperativa,\norientada a objetos, funcional, de tipagem dinâmica e forte. Foi lançada por Guido \nvan Rossum em 1991.",
							   "\nÉ uma linguagem de programação interpretada estruturada, de script em alto nível \ncom tipagem dinâmica fraca e multiparadigma. Juntamente com HTML e CSS, o JavaScript\né uma das três principais tecnologias da World Wide Web.",
							   "\nÉ um framework livre que promete aumentar velocidade e facilidade no desenvolvi-\nmento de sites orientados a banco de dados (database-driven web sites), uma vez que é\npossível criar aplicações com base em estruturas pré-definidas.",
							   "\nÉ uma linguagem interpretada livre, usada originalmente apenas para o desenvolvi-\nmento de aplicações presentes e atuantes no lado do servidor, capazes de gerar conte-\núdo dinâmico na World Wide Web.",
							   "\nÉ uma linguagem de programação, multiparadigma, de tipagem forte, desenvolvida pe-\nla Microsoft como parte da plataforma .NET. A sua sintaxe orientada a objetos foi ba-\nseada no C++ mas inclui muitas influências de outras linguagens de programação, como\nObject Pascal e, principalmente, Java.",
							   "\nÉ uma linguagem de programação de alto nível, orientada a objetos e compilada. Ela\nfoi criada por Bjarne Stroustrup em 1983 como uma extensão da linguagem C. A lingua-\ngem C++ é usada para desenvolver aplicativos de software, sistemas operacionais, dri-\nvers de dispositivos, jogos e muito mais.",
							   "\nÉ uma linguagem de programação compilada de propósito geral, estruturada, imperati-\nva, procedural, padronizada pela Organização Internacional para Padronização (ISO),\ncriada em 1972 por Dennis Ritchie na empresa AT&T Bell Labs para desenvolvimento do \nsistema operacional Unix (originalmente escrito em Assembly)."};
	
	public void relatorio(SistemaJavalar sistema) {
		System.out.println("\n=RELATORIO FINAL ================================\n");
		
		for (int i = 0; i < sistema.sistemaReserva.size(); i++) {
			System.out.println("\n" + sistema.sistemaReserva.get(i).getNome() + "=========================");
			System.out.println("quantidade de bugs: " + sistema.sistemaReserva.get(i).colisoes[0]);
			System.out.println("quantidade de devs: " + sistema.sistemaReserva.get(i).colisoes[1]);
			System.out.println("quantidade de anos: " + sistema.sistemaReserva.get(i).getAnos());
			System.out.printf("velocidade media: %.2f quadros por periodo\n", sistema.sistemaReserva.get(i).calcularVelocidadeMedia());
			double dias = (sistema.sistemaReserva.get(i).rotacao()/2);
			if (dias >= 24)
				System.out.printf("quantidade de dias: %.0f (%.2f horas) \n", (dias / 24),dias);
			else
				System.out.printf("quantidade de horas: %.2f \n", sistema.sistemaReserva.get(i).rotacao());
			
			System.out.println(resumo[i]);
			
		}		
		System.out.println("\n============================================================================\n");
		System.out.println("planetas que explodiram:" + sistema.planetasExplodidos);
		System.out.println("passaram-se " + sistema.totalPeriodos + " periodos");
	}
	
}
