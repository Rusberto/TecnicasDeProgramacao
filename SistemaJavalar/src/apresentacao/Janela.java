package apresentacao;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import sistema.Relatorio;
import sistema.SistemaJavalar;

public class Janela extends JFrame implements ActionListener {

	private SistemaJavalar sistema;
	private PainelPlanetas painelPlanetas;
	private escolherArquivo escolherArquivos;
	private Relatorio relatorio;

	public Janela() {
		escolherArquivos = new escolherArquivo();
		sistema = escolherArquivos.getSistema();
		this.setLayout(new BorderLayout());

		this.add(painel());

		this.setBackground(Color.black);
		this.setTitle("SISTEMA JAVALAR");
		this.setSize(720, 540);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public JPanel painel() {
		JPanel painel = new JPanel();
		painel.setBackground(Color.black);
		painel.setLayout(new BorderLayout());
		painel.add(BorderLayout.WEST, acoes());
		painel.add(BorderLayout.EAST, new PainelBotoes(this));
		painel.setFocusable(true);
		return painel;
	}

	public JPanel acoes() {
		JPanel acoes = new JPanel();
		acoes.setBackground(Color.black);
		acoes.setLayout(new CardLayout());

		acoes.add(painelPlanetas = new PainelPlanetas(sistema));
		acoes.add(escolherArquivos);
		return acoes;
	}

	public void actionPerformed(ActionEvent e) {
		JButton botao = (JButton) e.getSource();
		final Timer timer = new Timer();
		
		if (botao.getText() == "processar proximo instante") {
			if (sistema.getNomeArquivo() != null) {
				escolherArquivos.setVisible(false);
				if (painelPlanetas.getSistema() != escolherArquivos.getSistema()) {
					painelPlanetas.setSistema(escolherArquivos.getSistema());
				} else
					timer.scheduleAtFixedRate(new TimerTask() {
						public void run() {
							painelPlanetas.movePlanets(timer);
							repaint();
						}
					}, 0, 1000);
			}else {
				new JOptionPane().showMessageDialog(this,"escolha um arquivo");
			}
		}
		if (botao.getText() == "ler novo arquivo de entrada") {
			painelPlanetas.setVisible(false);
			escolherArquivos.setVisible(true);
		}
		if (botao.getText() == "gravar relatorio") {
			this.relatorio = new Relatorio(painelPlanetas.getSistema());
			relatorio.inserirRelatorio(relatorio);
		}
		if (botao.getText() == "ler dados de outros paticipantes") {
			sistema.criarArquivoSaida();
		}
		if (botao.getText() == "gravar arquivo de saida" && sistema.getArquivoSaida() != null) {
			sistema.escreverArquivoSaida();
		}else if(botao.getText() == "gravar arquivo de saida" && sistema.getArquivoSaida() == null){
			new JOptionPane().showMessageDialog(this,"leia os dados antes");
		}
	}

	public void visibilidade() {
		painelPlanetas.setVisible(false);
		escolherArquivos.setVisible(false);
	}

	public SistemaJavalar getSistema() {
		return this.sistema;
	}
}
