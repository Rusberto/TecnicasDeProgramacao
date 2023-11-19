package sistema;

public enum TipoEnumBebida {
	COCA_COLA("1"),
	DEL_RIO("2"),
	SUCO_DO_CHAVES("3");
	
	TipoEnumBebida(String cod) {
		this.codigo = cod;
	}
	
	private String codigo;
	
	public String getCodigo() {
		return this.codigo;
	}
}
