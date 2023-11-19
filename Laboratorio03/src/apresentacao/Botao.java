package apresentacao;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Botao extends JButton{
	public Botao(String nome, ActionListener janela) {
		this.setText(nome);
		this.addActionListener(janela);
	}
	
	public Botao(String nome) {
		this.setText(nome);
		}

}
