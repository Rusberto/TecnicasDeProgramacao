package cachorroQuenteGeraArvore;

public class Aluno {
	private String nome;
	private int matricula;
	private CachorroQuente[] pedidos;
	
	public Aluno (String nome, int matricula, int quantidade) {
		this.nome = nome;
		this.matricula = matricula;
		this.pedidos = new CachorroQuente[quantidade];
	}
	
	public String getNome(){
		return nome;
	}
	public int getMatricula(){
		return matricula;
	}
	public String getPedido() {
		String pedido = "";
		for (int i = 0; i < this.pedidos.length; i++) {
			pedido += "\nproteina:" + pedidos[i].proteina;
			pedido += "\nqueijo:" + pedidos[i].queijo;
			pedido += "\nadicionais:" + pedidos[i].adicionais;
			pedido += "\nbebida:" + pedidos[i].bebida;
		}
		return pedido;
	}
	public void setPedido(int quantidade) {
		for (int i = 0; i < quantidade; i++) {
			String[] pedido = compra.cardapio();
			pedidos[i] = new CachorroQuente(pedido[0], pedido[1], pedido[2], pedido[3]);
		}
	}
}
