package apresentacao;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Botao extends JButton{

	public Botao(String texto, ActionListener janela) {
		this.setText(texto);
		this.addActionListener(janela);
	}
}
