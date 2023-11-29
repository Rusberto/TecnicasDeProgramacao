package apresentacao;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import sistema.SistemaJavalar;

public class escolherArquivo extends JPanel implements ActionListener{
	
	JComboBox<String> arquivos;
	SistemaJavalar sistema = new SistemaJavalar("AE_10.csv");
	
	public escolherArquivo() {
		this.setLayout(new GridLayout(4,1));
		
		String[] nomeArquivos = {"AE_10.csv", "AE_50.csv", "AE_100.csv", "AE_500.csv", "AE_1000.csv", "AE_1500.csv", "AE_2000.csv"};
		
		arquivos = new JComboBox<>(nomeArquivos);
//		arquivos.addActionListener(this);
		
		this.add(new JLabel("Selecione o arquivo de entrada", SwingConstants.CENTER));
		this.add(arquivos);
		this.add(new JPanel());
		this.add(new Botao("escolher", this));
		
	}
	
	public SistemaJavalar getSistema() {
		return this.sistema;
	}

	public void actionPerformed(ActionEvent e) {
		JButton botao = (JButton) e.getSource();
		
		if (botao.getText() == "escolher") {
			this.sistema = new SistemaJavalar(String.valueOf(arquivos.getSelectedItem()));
			}
	}
	
}
