package jogorestaum;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Jogo extends JFrame implements ActionListener {

	ArrayList<String> valores = new ArrayList<String>();
	ArrayList<String> posicoesJogadas = new ArrayList<String>();
	ArrayList<String> posicoesJogadasEntre = new ArrayList<String>();
	HashMap<String, String> resultadojogador = new HashMap<String, String>();

	ArrayList<Pinos> pinosOrganizacao = new ArrayList<Pinos>();
	String pinosValidos[];
	String[][] pinosorg = new String[7][7];

	Pontos pontos = new Pontos();
	String pinoSelecionado = null;
	boolean possoRelizarJogada = false;
	int normalizar = 0;
	String posicaoPinoNormaliza;
	String nomeJogador;

	JPanel painelTelaJogo = new JPanel();
	JPanel content = new JPanel();

	public Jogo(String o) {

		try {
			Dados da = new Dados();
			da.lerPontos();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Jogo() {

		super("Jogo Resta Um");
		System.out.println("Abriu o principal!");

		nomeJogador = (String) JOptionPane.showInputDialog(null, "Jogador!", "Informe seu nome para começar: ",
				JOptionPane.INFORMATION_MESSAGE, null, null, null);

		this.content.setLayout(new GridLayout(7, 7));
		Color corBg = new Color(153, 204, 255);
		this.content.setBackground(corBg);

		// this.content.add(new ImagemBotao("fundo.png"));
		this.content.setPreferredSize(new Dimension(500, 500));

		valoresIniciais();
		telaJogo();

		this.add(this.content);

		listagemPinoOrganizacao();

		try {
			Dados da = new Dados();
			da.lerPontos();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("verifica pos: " + verificarPosicoesJogadasValidas(1, 3));

		// setarPainelInicial

		// Preferencias da Janela do Jogo
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200, 100);
		super.setPreferredSize(new Dimension(530, 520));
		super.setResizable(false);
		super.pack();
		super.setVisible(true);

	}

	public ArrayList<String> valoresIniciais() {

		// linha 0
		valores.add("0,0;n"); // col0
		valores.add("0,1;n"); // col1
		valores.add("0,2;b"); // col2
		valores.add("0,3;b"); // col3
		valores.add("0,4;b"); // col4
		valores.add("0,5;n"); // col5
		valores.add("0,6;n"); // col6

		// linha 1
		valores.add("1,0;n"); // col0
		valores.add("1,1;n"); // col1
		valores.add("1,2;b"); // col2
		valores.add("1,3;b"); // col3
		valores.add("1,4;b"); // col4
		valores.add("1,5;n"); // col5
		valores.add("1,6;n"); // col6

		// linha 2
		valores.add("2,0;b"); // col0
		valores.add("2,1;b"); // col1
		valores.add("2,2;b"); // col2
		valores.add("2,3;b"); // col3
		valores.add("2,4;b"); // col4
		valores.add("2,5;b"); // col5
		valores.add("2,6;b"); // col6

		// linha 3
		valores.add("3,0;b"); // col0
		valores.add("3,1;b"); // col1
		valores.add("3,2;b"); // col2
		valores.add("3,3;c"); // col3
		valores.add("3,4;b"); // col4
		valores.add("3,5;b"); // col5
		valores.add("3,6;b"); // col6

		// linha 4
		valores.add("4,0;b"); // col0
		valores.add("4,1;b"); // col1
		valores.add("4,2;b"); // col2
		valores.add("4,3;b"); // col3
		valores.add("4,4;b"); // col4
		valores.add("4,5;b"); // col5
		valores.add("4,6;b"); // col6

		// linha 5----
		valores.add("5,0;n"); // col0
		valores.add("5,1;n"); // col1
		valores.add("5,2;b"); // col2
		valores.add("5,3;b"); // col3
		valores.add("5,4;b"); // col4
		valores.add("5,5;n"); // col5
		valores.add("5,6;n"); // col6

		// linha 6
		valores.add("6,0;n"); // col0
		valores.add("6,1;n"); // col1
		valores.add("6,2;b"); // col2
		valores.add("6,3;b"); // col3
		valores.add("6,4;b"); // col4
		valores.add("6,5;n"); // col5
		valores.add("6,6;n"); // col6

		return valores;
	}

	public void imprimeValores() {
		int index = valores.size();

		while (0 < index--) {
			System.out.println(valores.get(index));
		}
	}

	private class ImagemBotao extends JButton {
		ImagemBotao(String icon) {
			Icon ico = new ImageIcon("src/img/" + icon);
			this.setOpaque(false);
			this.setContentAreaFilled(false);
			this.setBorderPainted(false);
			this.setIcon(ico);
		}
	}

	private void telaJogo() {

		this.painelTelaJogo = new JPanel();
		this.painelTelaJogo.setLayout(new GridLayout(7, 7));
		this.painelTelaJogo.setBackground(Color.WHITE);

		// Criando os Botoes
		int total = 7;
		String nome;
		String val;
		String valoresSplit[];
		int posx = 0, posy = 0;

		for (int i = 0; i < valores.size(); i++) {
			valoresSplit = valores.get(i).split(";");
			String coordenadas[] = valoresSplit[0].split(",");
			System.out.println(valoresSplit[0]);
			System.out.println("vetoressplit1: " + valoresSplit[1]);
			nome = valoresSplit[1];

			posx = Integer.parseInt(coordenadas[0]);
			posy = Integer.parseInt(coordenadas[1]);

			// System.out.println("Testando pos x "+ posx );
			// System.out.println("Testando pos y "+ posy );

			pinosorg[posx][posy] = nome;

			Pinos pino;
			pino = new Pinos(valoresSplit[0], nome);
			pinosOrganizacao.add(pino);
			pino.addActionListener(this);
			// pino.addActionListener(this);
			this.content.add(pino);
		}
	}

	private boolean pinoMesaExiste(int x, int y) {
		int min = 0, max = 6;

		// testa se [][x] é invalido
		if ((x > max || x < min) || (y > max || y < min)) { // testa se [][][x] é invalido
			return false;
		}
		return true;
	}

	// Organização
	public void listagemPinoOrganizacao() {
		// pinosOrganizacao.size();
		System.out.println("Você esta imprindo a listagem de pinos");
		;
		for (int i = 0; i < pinosOrganizacao.size(); i++) {
			// System.out.println(pinosOrganizacao.get(i).getText());

			if (pinosOrganizacao.get(i).getText().equals("5,5")) {
				// pinosOrganizacao.get(i).setIconBoxSpecial();

				System.out.println("Essa é minha posição: " + pinosOrganizacao.get(i).getText());

			}

			// Pinos pino = pinosOrganizacao.get(i);
			// pino.setIconBoxClean();
		}
	}

	// Engine
	private void selecionarPino(String posicao) {

		int[] posicaoint;
		int x, y;
		posicaoint = converterPosicaoStringInt(posicao);

		x = posicaoint[0];
		y = posicaoint[1];

		if (getValorDaPosicao(posicao).equals("b")) {

			if (pinoSelecionado != null) {

				int a, b;
				String[] pselcoordenadas;
				posicaoint = converterPosicaoStringInt(pinoSelecionado);
				a = posicaoint[0];
				b = posicaoint[1];

				pinosorg[a][b] = "b";
				setValorDaPosicao(pinoSelecionado, 'b');
				pinoSelecionado = null;
			}

			if (pinoSelecionado == null) {

				// pinosorg[a][b]="b";
				if (verificarPosicoesJogadasValidas(x, y) == true) {
					System.out.println("Verdadeiro");

					// se todas os testes for verdade
					pinoSelecionado = posicao;
					setValorDaPosicao(posicao, 's');

					String nomeTeste;
					for (int i = 0; i < pinosOrganizacao.size(); i++) {
						nomeTeste = "" + pinosOrganizacao.get(i).getIcon();

						if (nomeTeste.contains("box-special")) {
							System.out.println("testamos o contais special");
							System.out.println("nome da posicao é: " + pinosOrganizacao.get(i).getName());
							posicaoPinoNormaliza = posicao;
							System.out.println("posicao pinoNormaliza agora é: " + posicaoPinoNormaliza);
						}

					}

					pinosorg[x][y] = "s";
					possoRelizarJogada = true;

					normalizar++;
					System.out.println("incrementou na função selecionar pino");
				}

			}

		}
	}

	// descobre o valor do pino
	public String getValorDaPosicao(String pos) {
		int x, y;
		String[] coord;
		coord = pos.split(",");
		x = Integer.parseInt(coord[0]);
		y = Integer.parseInt(coord[1]);

		if (this.pinosorg[x][y] == null) {
			return "";
		}
		return this.pinosorg[x][y];
	}

	public void setValorDaPosicao(String pos, char icon) {

		for (int i = 0; i < pinosOrganizacao.size(); i++) {
			if (pinosOrganizacao.get(i).getText().equals(pos)) {

				switch (icon) {
				case 'b':
					pinosOrganizacao.get(i).setIconBox();
					break;
				case 'c':
					pinosOrganizacao.get(i).setIconBoxClean();
					break;
				case 's':
					pinosOrganizacao.get(i).setIconBoxSpecial();
					break;
				}

				break;
			}
		}
	}

	// Conversões = exemplo: "1,5" > [1][5] e vice versa
	private int[] converterPosicaoStringInt(String pos) {
		int x, y;
		int[] valor = new int[2];
		String coord[];
		coord = pos.split(",");

		if (coord.length == 2) {
			x = Integer.parseInt(coord[0]);
			y = Integer.parseInt(coord[1]);
		} else {
			return null;
		}
		valor[0] = x;
		valor[1] = y;

		return valor;
	}
	/*
	 * Exemplo de uso da função acima! valor = converterPosicaoStringInt("5,2");
	 * System.out.println("valor convertido! valor[0] = "+valor[0]);
	 * System.out.println("valor convertido! valor[1] = "+valor[1]);
	 */

	private String converterPosicaoIntString(int x, int y) {
		String coordenada;
		coordenada = x + "," + y;
		return coordenada;
	}

	// verificarPosicoesJogadasValidas
	public boolean verificarPosicoesJogadasValidas(int x, int y) {

		posicoesJogadas.clear();
		posicoesJogadasEntre.clear();

		if (pinoMesaExiste(x - 1, y) && pinoMesaExiste(x - 2, y)) {
			if ((pinosorg[x - 1][y].equals("b")) && (pinosorg[x - 2][y].equals("c"))) {
				posicoesJogadas.add((x - 2) + "," + y); // validar top
				posicoesJogadasEntre.add((x - 1) + "," + y);
			}
		}

		if (pinoMesaExiste(x, y + 1) && pinoMesaExiste(x, y + 2)) {
			if ((pinosorg[x][y + 1].equals("b")) && (pinosorg[x][y + 2].equals("c"))) {
				posicoesJogadas.add(x + "," + (y + 2)); // validar direita
				posicoesJogadasEntre.add(x + "," + (y + 1));
			}
		}
		if (pinoMesaExiste(x + 1, y) && pinoMesaExiste(x + 2, y)) {
			if ((pinosorg[x + 1][y].equals("b")) && (pinosorg[x + 2][y].equals("c"))) {
				posicoesJogadas.add((x + 2) + "," + y); // validar baixo
				posicoesJogadasEntre.add((x + 1) + "," + y);
			}
		}

		if (pinoMesaExiste(x, y - 1) && pinoMesaExiste(x, y - 2)) {
			if ((pinosorg[x][y - 1].equals("b")) && (pinosorg[x][y - 2].equals("c"))) {
				posicoesJogadas.add(x + "," + (y - 2)); // validar esquerda
				posicoesJogadasEntre.add(x + "," + (y - 1));
			}
		}

		return posicoesJogadas.size() > 0 ? true : false;
	}

	public void realizarJogada(String pos) {
		System.out.println("Sua pontuação é: " + pontos.numero);

		for (int i = 0; i < posicoesJogadas.size(); i++) {
			if (posicoesJogadas.get(i).equals(pos)) {
				System.out.println("Aqui vai acontecer uma mágica => " + posicoesJogadas.get(i));
				System.out.println("Aqui vai acontecer a entrepeça => " + posicoesJogadasEntre.get(i));
				System.out.println("Pino selecionado no momento => " + pinoSelecionado);

				// se todas os testes for verdade
				int[] posJogada = converterPosicaoStringInt(posicoesJogadas.get(i));
				// posJogada[0]; //x
				// posJogada[1]; //y

				int[] posAtualPinoSelecionado = converterPosicaoStringInt(pinoSelecionado);
				// posAtualPinoSelecionado[0]; //x
				// posAtualPinoSelecionado[1]; //y

				int[] posEntrepacas = converterPosicaoStringInt(posicoesJogadasEntre.get(i));
				// posEntrepacas[0]; //x
				// posEntrepacas[1]; //y

				setValorDaPosicao(posicoesJogadas.get(i), 'b'); // valorposicao
				pinosorg[posJogada[0]][posJogada[1]] = "b";

				setValorDaPosicao(posEntrepacas[0] + "," + posEntrepacas[1], 'c'); // entrepecas
				pinosorg[posEntrepacas[0]][posEntrepacas[1]] = "c";

				setValorDaPosicao(pinoSelecionado, 'c'); // pinoselecionado
				pinosorg[posAtualPinoSelecionado[0]][posAtualPinoSelecionado[1]] = "c";

				possoRelizarJogada = false;
				pinoSelecionado = null;
				pontos.numero++;

				if (normalizar > 1) {
					normaliza();
				} else {
					normalizar++;
				}

			}
		}
	}

	public void normaliza() {

		if (normalizar > 1) {
			System.out.println("listando todas os pinos button");
			for (int i = 0; i < pinosOrganizacao.size(); i++) {
				String nomeTeste = "" + pinosOrganizacao.get(i).getIcon();
				if (nomeTeste.contains("box-special")) {
					System.out.println("testamos o contais special DENTRO DO NORMALIZA");
					System.out.println("nome da posicao é: " + pinosOrganizacao.get(i).getName());
					setValorDaPosicao(posicaoPinoNormaliza, 'b'); // valorposicao fisica
					pinoSelecionado = null;
					possoRelizarJogada = false;

					int[] posJogada = new int[2];
					posJogada = converterPosicaoStringInt(posicaoPinoNormaliza);
					pinosorg[posJogada[0]][posJogada[1]] = "b"; // valorposicao pinos

					System.out.println("Posição pinoNormaliza agora é: " + posicaoPinoNormaliza);
				}
			}

			normalizar = 0;
		}
	}

	public boolean gameOver() {

		int max = 7;

		for (int x = 0; x < max; x++) {
			for (int y = 0; y < max; y++) {
				if (verificarPosicoesValAux(x, y) == true) {
					// System.out.println("verificarPosicoesValAux(x, y)"+x+","+y+" RETORNOU JOGADA
					// VALIDA"); //testes
					return false;
				}
			}
		}

		System.out.println("=====================================\nGame Over!\n=====================================");
		System.out.println("Sua pontuação é: " + pontos.numero);
		JOptionPane mensagemFinal;
		// mensagemFinal.setBorder(border);
		pontos.gerarPontos();
		String pontosnumS;
		pontosnumS = Integer.toString(pontos.gerarPontos());

		Dados dado;
		try {
			dado = new Dados(nomeJogador, pontos.numero);
			dado.addPontos(nomeJogador, pontosnumS);
			dado.gravar();

		} catch (IOException e1) {

			e1.printStackTrace();
		}

		JOptionPane.showMessageDialog(null, "Fim do Jogo!\n\n"+"Sua pontuação foi: " + pontos.numero,
				"Fim do Jogo", JOptionPane.INFORMATION_MESSAGE);
		
		setVisible(false);
		Principal p = new Principal();
		p.escolherTela(2);

		return true;
	}

	public boolean verificarPosicoesValAux(int x, int y) {

		if ((pinoMesaExiste(x, y) == false)) {
			return false;
		} else {
			if ((pinosorg[x][y].equals("n")) || (pinosorg[x][y].equals("c"))) {
				return false;
			}
		}

		if (pinoMesaExiste(x - 1, y) && pinoMesaExiste(x - 2, y)) {
			if ((pinosorg[x - 1][y].equals("b")) && (pinosorg[x - 2][y].equals("c"))) {
				// System.out.println("if1");
				return true;
			}
		}

		if (pinoMesaExiste(x, y + 1) && pinoMesaExiste(x, y + 2)) {
			if ((pinosorg[x][y + 1].equals("b")) && (pinosorg[x][y + 2].equals("c"))) {
				// System.out.println("if2");
				return true;
			}
		}
		if (pinoMesaExiste(x + 1, y) && pinoMesaExiste(x + 2, y)) {
			if ((pinosorg[x + 1][y].equals("b")) && (pinosorg[x + 2][y].equals("c"))) {
				// System.out.println("if3");
				return true;
			}
		}

		if (pinoMesaExiste(x, y - 1) && pinoMesaExiste(x, y - 2)) {
			if ((pinosorg[x][y - 1].equals("b")) && (pinosorg[x][y - 2].equals("c"))) {
				// System.out.println("if4");
				return true;
			}
		}

		return false;

	}

	@Override
	public void actionPerformed(ActionEvent a) {

		System.out.println(a.getActionCommand()); // descobre a posicao do pino

		System.out.println(getValorDaPosicao(a.getActionCommand())); // descobre o valor do pino

		if (possoRelizarJogada == true) {
			realizarJogada(a.getActionCommand());
		}

		selecionarPino(a.getActionCommand());

		System.out.println("Observando normalizar... " + normalizar);
		if (normalizar >= 2) {
			normaliza();

			System.out.println("Sua posição agora é");
		}

		normaliza();
		gameOver();
	}

	public void actionJanelaPrincipal(ActionEvent a) {
		System.out.println("Voce clicou no botão: " + a);
	}

	public class Dados {

		List<Pontos> pontos = new ArrayList();
		int escLinha = 0;

		public Dados(String nomeJogador, int pontosJogador) throws IOException {

			String pontoS = Integer.toString(pontosJogador);
			lerPontos();

			addPontos(nomeJogador, pontoS);

		}

		public Dados() {

		}

		public void addPontos(String nomeJogador, String pontosJogador) {

			if (!nomeJogador.isEmpty() && (!pontosJogador.isEmpty())) {
				resultadojogador.put(nomeJogador, pontosJogador);
			}

		}

		private void gravar() throws IOException {
			OutputStream out = new FileOutputStream("src/rank.txt");
			Writer w = new OutputStreamWriter(out);
			String s;
			for (String key : resultadojogador.keySet()) {
				s = key + ";" + resultadojogador.get(key);
				w.write(s + "\n");
			}
			w.close();
		}

		/*
		 * private void salvar() throws IOException { OutputStream out = new
		 * FileOutputStream("src/rank.txt"); Writer w = new OutputStreamWriter(out);
		 * String s; for (int i = 0; i < resultadojogador.size(); i++) { s =
		 * resultadojogador.get(i).getNome()+";"+resultadojogador.get(i).getPontos();
		 * w.write( s + "\n"); } w.close(); }
		 */

		private int lerPontos() throws IOException {

			String nomeJogador;
			String pontosJogador;
			int qtdLinhasArq = 0;

			InputStream in = new FileInputStream("src/rank.txt");
			Reader r = new InputStreamReader(in);
			int i;
			String c = "";
			while ((i = r.read()) != -1) {
				c += (char) i;
			}
			String[] lines = c.split("\n");

			for (String s : lines) {
				String[] val = { "", "" };
				val = s.split(";");

				nomeJogador = val[0];
				nomeJogador = nomeJogador.trim();

				pontosJogador = val[1];
				pontosJogador = pontosJogador.trim();

				if (!nomeJogador.isEmpty() && (!pontosJogador.isEmpty())) {
					resultadojogador.put(nomeJogador, pontosJogador);
					qtdLinhasArq++;
				}
			}
			/*
			 * System.out.println("Imprimindo nosso hasmap resultadojogador"); String
			 * chave="",valor=""; for (String key : resultadojogador.keySet()) { //if( false
			 * == Arrays.asList(rank).contains(key) ) { if (
			 * resultadojogador.get(key).isEmpty() == false ) { chave =
			 * resultadojogador.get(key); valor = key;
			 * 
			 * 
			 * } System.out.println("chave: "+chave +" e valor:"+valor);
			 * 
			 * }
			 */
			return qtdLinhasArq;
		}

	}

}
