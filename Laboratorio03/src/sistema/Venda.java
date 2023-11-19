package sistema;
import java.util.ArrayList;

import bancoDeDados.VendaDAO;

public class Venda {

	private Aluno aluno;
	private CachorroQuente pedido;
	private VendaDAO vendaDAO;
	
	
	public Venda(Aluno aluno, CachorroQuente cachorroQuente) {
		vendaDAO = new VendaDAO();
		this.aluno= aluno;
		pedido = cachorroQuente;
	}
	
	public void inserirVenda(Venda venda) {
		vendaDAO.inserir(venda);
	}

	public Aluno getAluno() {
		return aluno;
	}
	
	public void preco(String proteina) {
		pedido.setValor(TipoEnumProteina.valueOf(proteina).getPreco());
	}

	public CachorroQuente getCachorrosQuentes() {
		return pedido;
	}
	
	
}
