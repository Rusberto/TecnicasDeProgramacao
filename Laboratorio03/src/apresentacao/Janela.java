package apresentacao;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Janela extends JFrame implements ActionListener {

	private Menu menu = new Menu(new Botao("Realizar Venda", this), new Botao("Listar Vendas", this),
			new Botao("Mostrar Relatorio", this));

	private RealizarVenda realizarVenda = new RealizarVenda();
	private ListarVendas listaVendas = new ListarVendas();
	private Relatorio relatorio = new Relatorio();

	public Janela() {

		setLayout(new BorderLayout());
		JPanel telas = new JPanel();
		telas.setLayout(new CardLayout());
		telas.add(realizarVenda);
		telas.add(listaVendas);
		telas.add(relatorio);

		add(BorderLayout.NORTH, menu);
		add(BorderLayout.CENTER,telas);

		setSize(600, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		Botao botao = (Botao) e.getSource();
		if (botao.getText() == realizarVenda.getName()) {
			visibilidade();
			realizarVenda.setVisible(true);
		} else if (botao.getText() == listaVendas.getName()) {
			visibilidade();
			listaVendas.setVisible(true);
		} else if (botao.getText() == relatorio.getName()) {
			visibilidade();
			relatorio.setVisible(true);
		}
	}
	public void visibilidade() {
		realizarVenda.setVisible(false);
		listaVendas.setVisible(false);
	}

}