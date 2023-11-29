package apresentacao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;


public class PainelBotoes extends JPanel {
	private final int WIDTH = 200;
	private final int HEIGHT = 500;
	
	public PainelBotoes(ActionListener janela){
		this.setLayout(new GridLayout(5, 1, 3, 3));
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT ));
		this.setBackground(Color.black);
		this.add(new Botao("processar proximo instante", janela));
		this.add(new Botao("ler novo arquivo de entrada", janela));
		this.add(new Botao("gravar relatorio", janela));
		this.add(new Botao("ler dados de outros paticipantes", janela));
		this.add(new Botao("gravar arquivo de saida", janela));
	}
}
