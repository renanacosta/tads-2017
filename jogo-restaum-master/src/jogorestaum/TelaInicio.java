package jogorestaum;

import java.awt.Color;
import java.awt.event.*;
import java.security.Principal;

import javax.swing.*;

public class TelaInicio extends JFrame implements ActionListener {

	private JButton btJogar;
	private JButton btRank;
	private JButton btRegras;
	private JButton fundo;

	jogorestaum.Principal pr = new jogorestaum.Principal();

	public TelaInicio() {

		setTitle("Jogo Resta Um"); // seta um título para a janela
		setSize(500, 480); // seta uma dimensão
		Color corBg = new Color(153, 204, 255);
		getContentPane().setBackground(corBg);
		setLocationRelativeTo(null); // seta a posição
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // define que a execução será finalizada quando a janela for
														// fechada
		setResizable(false); // seta para não ser possível redimensionar a janela
		// pack();
		setVisible(true);

		getContentPane().setLayout(null);

		// instancia os botões e atribuindo os seus nomes
		btJogar = new ImagemBotao("jogar.png"); // JButton("Jogar");
		btJogar.setName("jogar");
		btRank = new ImagemBotao("resultados.png"); // JButton("Resultados");
		btRegras = new ImagemBotao("regras.png"); // JButton("Regras");
		fundo = new ImagemBotao("fundo.png");
		fundo.setSize(100, 100);

		// objeto.setBounds
		// (posicaoColuna,posicaoLinha,comprimentodalinha,alturadalinha);
		btJogar.setBounds(175, 205, 100, 100);
		btRank.setBounds(270, 180, 210, 150);
		btRegras.setBounds(5, 180, 150, 150);
		fundo.setBounds(0, 0, 500, 500);

		getContentPane().repaint();

		getContentPane().add(btJogar);
		getContentPane().add(btRank);
		getContentPane().add(btRegras);
		getContentPane().add(fundo);

		// registra os botões ao Listener

		btJogar.addActionListener(this);
		btRank.addActionListener(this);
		btRegras.addActionListener(this);
	}

	private class ImagemBotao extends JButton {
		ImagemBotao(String icon) {

			Icon ico = new ImageIcon("src/img/" + icon);
			this.setText(icon);
			this.setOpaque(false);
			this.setContentAreaFilled(false);
			this.setBorderPainted(false);
			this.setIcon(ico);
		}
	}

	@Override
	public void actionPerformed(ActionEvent acao) {

		if ((acao.getActionCommand()).contains("jogar")) {
			System.out.println("Troca janela para a jogar");
			setVisible(false);
			pr.escolherTela(1);

		} else if ((acao.getActionCommand()).contains("regras")) {
			System.out.println("Troca janela para a regras");
			setVisible(false);
			pr.escolherTela(4);

		} else if ((acao.getActionCommand()).contains("resultados")) {
			System.out.println("Troca janela para a resultados");
			setVisible(false);
			pr.escolherTela(3);

		}

	}

}
