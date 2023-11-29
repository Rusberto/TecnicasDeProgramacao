package apresentacao;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;

import sistema.SistemaJavalar;

public class PainelPlanetas extends JPanel {

	static final int HEIGHT = 500;
	static final int WIDTH = 500;
	static final int UNIT_SIZE = 25;

	private SistemaJavalar sistema;

	public PainelPlanetas(SistemaJavalar system) {
		sistema = system;
		this.setBackground(Color.BLACK);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		draw(g);
	}

	public void movePlanets(Timer timer) {

		if (sistema.getArquivoLido() == true) {
			new JOptionPane();
			JOptionPane.showMessageDialog(this, "Arquivo lido completamente");
			if (JOptionPane.CLOSED_OPTION == -1) {
				timer.cancel();
			}
		} else if (sistema.getPlanetasExplodidos().size() == 7) {
			JOptionPane.showMessageDialog(this, "Todos os planetas explodiram");
			if (JOptionPane.CLOSED_OPTION == -1) {
				timer.cancel();
			}
		} else {
			sistema.translacoes();
			if (sistema.getExplosao()) {
				ImageIcon icon = new ImageIcon("Sprites/explosao.gif");
				JOptionPane.showMessageDialog(this,
						sistema.getPlanetasExplodidos().get(sistema.getPlanetasExplodidos().size() - 1)
								+ " acabou de explodir",
						"oh não", JOptionPane.INFORMATION_MESSAGE, icon);
				sistema.setExplosao(false);
			}
		}
	}

	public void draw(Graphics g) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("Sprites/java.png"));

			g.setColor(Color.YELLOW);
			g.fillOval(UNIT_SIZE * 8, UNIT_SIZE * 8, UNIT_SIZE * 3, UNIT_SIZE * 3);
			g.drawImage(image, UNIT_SIZE * 8, UNIT_SIZE * 8, UNIT_SIZE * 3, UNIT_SIZE * 3, null);
			for (int i = 0; i < sistema.getPlanetas().size(); i++) {
				g.setColor(sistema.getPlanetas().get(i).getCor());
				g.fillOval(sistema.getPlanetas().get(i).getPosicao()[0] * UNIT_SIZE,
						sistema.getPlanetas().get(i).getPosicao()[1] * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
				g.drawImage(sistema.getPlanetas().get(i).getimage(),
						UNIT_SIZE * sistema.getPlanetas().get(i).getPosicao()[0],
						UNIT_SIZE * sistema.getPlanetas().get(i).getPosicao()[1], UNIT_SIZE, UNIT_SIZE, null);
			}
			for (int i = 0; i < sistema.getBugs().size(); i++) {
				image = ImageIO.read(new File("Sprites/Bug.png"));
				g.drawImage(image, UNIT_SIZE * sistema.getBugs().get(i).getPosicao()[0],
						UNIT_SIZE * sistema.getBugs().get(i).getPosicao()[1], UNIT_SIZE / 2, UNIT_SIZE / 2, null);
			}
			for (int i = 0; i < sistema.getDevs().size(); i++) {
				image = ImageIO.read(new File("Sprites/Dev.png"));
				g.drawImage(image, UNIT_SIZE * sistema.getDevs().get(i).getPosicao()[0],
						UNIT_SIZE * sistema.getDevs().get(i).getPosicao()[1], UNIT_SIZE / 2, UNIT_SIZE / 2, null);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setSistema(SistemaJavalar sistema) {
		this.sistema = sistema;
	}

	public SistemaJavalar getSistema() {
		return this.sistema;
	}

}
