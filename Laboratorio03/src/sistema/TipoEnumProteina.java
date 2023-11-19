package sistema;

public enum TipoEnumProteina {
	
	BACON("1", 3.5),
	FRANGO("2", 2.5),
	LINGUICA("3", 3),
	SALSICHA("4", 2);
	
	TipoEnumProteina(String cod, double preco) {
		this.codigo = cod;
		this.preco = preco;
	}
	
	private String codigo;
	private double preco;
	
	public String getCodigo() {
		return this.codigo;
	}
	public double getPreco() {
		return this.preco;
	}
}
