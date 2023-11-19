package apresentacao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import bancoDeDados.VendaDAO;
import sistema.Aluno;
import sistema.CachorroQuente;
import sistema.TipoEnumBebida;
import sistema.TipoEnumProteina;
import sistema.TipoEnumQueijo;
import sistema.Venda;

public class RealizarVenda extends JPanel implements ActionListener {

	private String nome;
	private int matricula = 0;

	private int queijo;
	private int proteina;
	private String adicionais = "";
	private int bebida;

	private JTextField nomeCliente, matriculaCliente;
	private JComboBox<?> opcoesQueijo, opcoesProteina, opcoesBebida;
	private ArrayList<JCheckBox> adds;
	private JCheckBox ketchup, maionese, ovo, batata;

	public RealizarVenda() {
		setLayout(new GridLayout(7, 2));

		this.setName("Realizar Venda");

		this.add(new JLabel(" Nome do Cliente: ", SwingConstants.CENTER));
		this.add(nomeCliente = new JTextField());
		nomeCliente.addActionListener(this);

		this.add(new JLabel(" Matricula: ", SwingConstants.CENTER));
		this.add(matriculaCliente = new JTextField());
		matriculaCliente.addActionListener(this);

		this.add(new JLabel(" Opcao de queijo: ", SwingConstants.CENTER));
		this.add(opcoesQueijo = new JComboBox<>(TipoEnumQueijo.values()));

		this.add(new JLabel(" Opcao de proteina", SwingConstants.CENTER));
		this.add(opcoesProteina = new JComboBox<>(TipoEnumProteina.values()));

		this.add(new JLabel(" Adicionais: ", SwingConstants.CENTER));
		this.add(adicionais()).setBackground(Color.lightGray);

		this.add(new JLabel(" Bebida: ", SwingConstants.CENTER));
		this.add(opcoesBebida = new JComboBox<>(TipoEnumBebida.values()));

		this.add(new JPanel());
		this.add(new Botao("Realizar venda", this));

	}

	public JPanel adicionais() {
		JPanel opcoes = new JPanel();
		opcoes.setLayout(new GridLayout(2, 2));

		adds = new ArrayList<>();
		adds.add(maionese = new JCheckBox("maionese"));
		adds.add(ketchup = new JCheckBox("ketchup"));
		adds.add(ovo = new JCheckBox("ovo"));
		adds.add(batata = new JCheckBox("batata palha"));

		for (int i = 0; i < adds.size(); i++) {
			opcoes.add(adds.get(i));
		}
		return opcoes;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Botao botao = (Botao) e.getSource();

		Venda venda = null;

		if (botao.getText() == "Realizar venda") {

			this.nome = nomeCliente.getText();
			this.matricula = Integer.parseInt(matriculaCliente.getText());

			this.proteina = opcoesProteina.getSelectedIndex();
			this.queijo = opcoesQueijo.getSelectedIndex();
			this.bebida = opcoesBebida.getSelectedIndex();

			for (int i = 0; i < adds.size(); i++) {
				if (adds.get(i).isSelected()) {
					if (adicionais == "") {
						adicionais += adds.get(i).getText();
					} else
						adicionais += ", " + adds.get(i).getText();
				}
			}

			venda = new Venda(new Aluno(nome, matricula), new CachorroQuente(proteina, queijo, bebida, adicionais));
			venda.preco(opcoesProteina.getSelectedItem().toString());
			venda.inserirVenda(venda);
		}
		adicionais = "";
	}

}
