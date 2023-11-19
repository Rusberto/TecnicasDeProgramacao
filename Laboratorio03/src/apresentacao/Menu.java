package apresentacao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu extends JPanel{
	public Menu(JButton botao1, JButton botao2, JButton botao3) {
		
		this.add(botao1);
		this.add(botao2);
		this.add(botao3);
		
		this.setBackground(Color.BLUE);
		
		this.setVisible(true);
	}
}
