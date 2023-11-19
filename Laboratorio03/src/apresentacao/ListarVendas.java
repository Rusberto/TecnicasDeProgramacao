package apresentacao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import bancoDeDados.VendaDAO;
import sistema.TipoEnumProteina;
import sistema.Venda;

public class ListarVendas extends JPanel{
	public ListarVendas() {
		this.setName("Listar Vendas");
		this.setBackground(Color.BLACK);
		this.setLayout(new BorderLayout());
		
		this.add(BorderLayout.NORTH, topoTabela());
		this.add(BorderLayout.CENTER, tabela());
		
	}
	
	public JPanel topoTabela() {
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(1, 7, 5, 0));
		p.setBackground(Color.gray);
		p.add(new JLabel("nome", SwingConstants.CENTER));
		p.add(new JLabel("matricula", SwingConstants.CENTER));
		p.add(new JLabel("proteina", SwingConstants.CENTER));
		p.add(new JLabel("queijo", SwingConstants.CENTER));
		p.add(new JLabel("adicionais", SwingConstants.CENTER));
		p.add(new JLabel("bebida", SwingConstants.CENTER));
		p.add(new JLabel("valor", SwingConstants.CENTER));
		
		return p;
	}

	public JPanel tabela() {
		ArrayList<Venda> dados = new VendaDAO().ler();
		JPanel tabela = new JPanel();
		int quantidadeLinhas = 0;
		
		JPanel linhas;
		
		for (int i = 0; i < dados.size(); i++) {
			linhas = new JPanel();
			linhas.setLayout(new GridLayout(1,7,5,5));
			linhas.setBackground(Color.lightGray);
			
			linhas.add(new JLabel(dados.get(i).getAluno().getNome()));
			linhas.add(new JLabel(String.valueOf(dados.get(i).getAluno().getMatricula()), SwingConstants.CENTER));
			linhas.add(new JLabel(String.valueOf(dados.get(i).getCachorrosQuentes().getProteina()), SwingConstants.CENTER));
			linhas.add(new JLabel(String.valueOf(dados.get(i).getCachorrosQuentes().getQueijo()), SwingConstants.CENTER));
			linhas.add(new JLabel(dados.get(i).getCachorrosQuentes().getAdicionais(), SwingConstants.CENTER));
			linhas.add(new JLabel(String.valueOf(dados.get(i).getCachorrosQuentes().getBebida()), SwingConstants.CENTER));
			linhas.add(new JLabel(String.valueOf(dados.get(i).getCachorrosQuentes().getValor()), SwingConstants.CENTER));
			
			tabela.add(linhas);
			quantidadeLinhas++;
		}
		
		tabela.setLayout(new GridLayout(quantidadeLinhas, 1));
		return tabela;
	}
}
