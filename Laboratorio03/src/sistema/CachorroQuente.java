package sistema;

import java.util.ArrayList;

public class CachorroQuente {

	protected int queijo;
	protected int proteina;
	protected int bebida;
	protected String ingredientes;
	protected double valor;
	
	public CachorroQuente(int proteina, int queijo, int bebida, String adicionais) {
		this.proteina = proteina;
		this.queijo = queijo;
		this.bebida = bebida;
		this.ingredientes = adicionais;
	}
	
	public int getProteina(){
		return this.proteina;
	}
	
	public int getQueijo(){
		return this.queijo;
	}
	
	public int getBebida(){
		return this.bebida;
	}
	
	public String getAdicionais() {
		return this.ingredientes;
	}
	
	public double getValor() {
		return this.valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
}
