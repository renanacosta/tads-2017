package jogorestaum;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class TelaPontos extends JFrame {

	private JButton btJogar;
	private JButton btRank;
	private JButton btRegras;
	private JButton fundo;
	String msg;
	private JTextArea caixaTextoPontos;

	jogorestaum.Principal pr = new jogorestaum.Principal();
	Jogo j = new Jogo("o");

	public TelaPontos() {

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
		msg = "Este Jogo Resta um é o mais legal de todos!";
		// formatando caixa de texto
		caixaTextoPontos = new JTextArea("   Resultado dos Jogadores: \n");
		caixaTextoPontos.setSize(360, 250);
		caixaTextoPontos.setWrapStyleWord(true);
		caixaTextoPontos.setLineWrap(true);
		caixaTextoPontos.setEditable(false);
		caixaTextoPontos.setFocusable(false);

		/*
		 * //scroll caixaTextoPontos.setEditable(false); // set textArea non-editable
		 * JScrollPane scroll = new JScrollPane(caixaTextoPontos);
		 * scroll.setPreferredSize(getMinimumSize());
		 * scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.
		 * VERTICAL_SCROLLBAR_ALWAYS);
		 */

		// caixaTextoPontos.setForeground(Color.blue); // ERA WHITE
		caixaTextoPontos.setFont(new Font("Tahoma", Font.BOLD, 14));
		caixaTextoPontos.setBackground(corBg);

		fundo.setSize(100, 100);

		// objeto.setBounds
		// (posicaoColuna,posicaoLinha,comprimentodalinha,alturadalinha);
		btJogar.setBounds(175, 270, 100, 100);
		btRegras.setBounds(120, 315, 210, 150);
		// btRegras.setBounds(5, 180, 150, 150);
		fundo.setBounds(0, 0, 500, 500);
		caixaTextoPontos.setBounds(70, 35, 360, 250);
		// scroll.setBounds(60, 30, 300, 200);

		getContentPane().repaint();

		getContentPane().add(btJogar);
		// getContentPane().add(scroll);
		getContentPane().add(caixaTextoPontos);
		// getContentPane().add(btRank);
		getContentPane().add(btRegras);
		getContentPane().add(fundo);

		// registra os botões ao Listener

		btJogar.addActionListener(new Acoes());
		btRank.addActionListener(new Acoes());
		btRegras.addActionListener(new Acoes());

		String chave = "", valor = "";
		String resultados = "";
		for (String key : j.resultadojogador.keySet()) {
			// if( false == Arrays.asList(rank).contains(key) ) {
			if (j.resultadojogador.get(key).isEmpty() == false) {
				chave = j.resultadojogador.get(key);
				valor = key;

			}
			resultados += "Jogador: " + valor + " - Pontos: " + chave + "\n";
			// System.out.println("chave: "+chave +" e valor:"+valor);

		}
		caixaTextoPontos.append(resultados);

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

	public class Acoes implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());

			if ((e.getActionCommand()).contains("jogar")) {
				System.out.println("Troca janela para a jogar");
				setVisible(false);
				pr.escolherTela(1);

			} else if ((e.getActionCommand()).contains("regras")) {
				System.out.println("Troca janela para a regras");
				setVisible(false);
				pr.escolherTela(4);

			} else if ((e.getActionCommand()).contains("resultados")) {
				System.out.println("Troca janela para a resultados");
				setVisible(false);
				pr.escolherTela(3);

			}

		}

	}

}

// APPEND

// .append(\n); //nova linha
