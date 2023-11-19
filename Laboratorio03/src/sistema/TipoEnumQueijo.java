package sistema;

public enum TipoEnumQueijo {

	
	MUSSARELA("1"),
	PRATO("2"),
	PARMESAO("3"),
	COALHO("4");
	
	TipoEnumQueijo(String cod) {
		this.codigo = cod;
	}
	
	private String codigo;
	
	public String getCodigo() {
		return this.codigo;
	}
}
