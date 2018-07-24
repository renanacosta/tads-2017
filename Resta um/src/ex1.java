import java.util.Scanner;

public class ex1 {
	static int t = 7; // variavel que determinal o tamanho do tabuleiro
	static char tabuleiro[][] = new char[t][t];

	public static void main(String[] args) {
		System.out.println("==============================");
		System.out.println("   BEM VINDO AO RESTA UM!!!   ");
		System.out.println("==============================");
		System.out.println();
		inicializar();
		do {
			mostraDados();
			resta1();
			jogada();

		} while (resta1() > 0);
		System.out.println("FIM DO JOGO");
		System.out.println("===============");
		mostraDados();
		System.out.println("===============");
		System.out.println("VOCÊ VENCEU!!!");
	}

	private static void inicializar() {
		for (int i = 0; i < t; i++) {
			for (int j = 0; j < t; j++) {
				tabuleiro[i][j] = 'O';

				tabuleiro[0][0] = ' ';
				tabuleiro[0][1] = ' ';
				tabuleiro[1][0] = ' ';
				tabuleiro[1][1] = ' '; // Canto superior esquerdo

				tabuleiro[0][5] = ' ';
				tabuleiro[0][6] = ' ';
				tabuleiro[1][5] = ' ';
				tabuleiro[1][6] = ' '; // Canto superior direito

				tabuleiro[5][0] = ' ';
				tabuleiro[6][0] = ' ';
				tabuleiro[5][1] = ' ';
				tabuleiro[6][1] = ' '; // Canto inferior esquerdo

				tabuleiro[5][5] = ' ';
				tabuleiro[5][6] = ' ';
				tabuleiro[6][5] = ' ';
				tabuleiro[6][6] = ' '; // Canto inferior direito
			}
		}

		char meio;
		meio = (char) (t / 2);
		tabuleiro[meio][meio] = 'X';
		// final do metodo inicializar.
	}

	private static void mostraDados() {
		// for (int i = 0; i < 250; ++i) System.out.println();
		System.out.print("   ");
		for (int i = 0; i < t; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i = 0; i < t; i++) {
			System.out.println();
			for (int j = 0; j < t; j++) {
				if (j == 0) {
					System.out.print(i + "  ");
				}
				System.out.print(tabuleiro[i][j] + " ");
			}
		}
		// final do metodo mostraDados.
	}

	private static int resta1() {
		// check de jogadas possiveis
		int jogValida = 0;
		System.out.println();
		System.out.println();
		// check horizontal dir-esq
		for (int i = 0; i < t - 2; i++) {
			for (int j = 0; j < t; j++) {
				if (tabuleiro[i][j] == 1 && tabuleiro[i + 2][j] == 0 && tabuleiro[i + 1][j] == 1) {
					jogValida = jogValida + 1;
					jogValida = 'O';
					// System.out.println("Jogada valida vertical de cima para baixo: " + (i + 1) +
					// "," + (j + 1) + " - "
					// + (i + 3) + "," + (j + 1));
				}
			}
		}
		// check horizontal esq-dir
		for (int i = t - 1; i >= 2; i--) {
			for (int j = t - 1; j >= 0; j--) {
				if (tabuleiro[i][j] == 1 && tabuleiro[i - 2][j] == 0 && tabuleiro[i - 1][j] == 1) {
					jogValida = jogValida + 1;
					jogValida = 'O';
					// System.out.println("Jogada valida vertical de baixo para cima: " + (i + 1) +
					// "," + (j + 1) + " - "
					// + (i - 1) + "," + (j + 1));
				}
			}
		}
		// check vertical cima-baixo
		for (int i = 0; i < t; i++) {
			for (int j = 0; j < t - 2; j++) {
				if (tabuleiro[i][j] == 1 && tabuleiro[i][j + 2] == 0 && tabuleiro[i][j + 1] == 1) {
					jogValida = jogValida + 1;
					jogValida = 'O';
					// System.out.println("Jogada valida horizontal da esquerda para direita: " + (i
					// + 1) + "," + (j + 1)
					// + " - " + (i + 1) + "," + (j + 3));
				}
			}
		} // check vertical baixo-cima
		for (int i = t - 1; i > 0; i--) {
			for (int j = t - 1; j > 2; j--) {
				if (tabuleiro[i][j] == 1 && tabuleiro[i][j - 2] == 0 && tabuleiro[i][j - 1] == 1) {
					jogValida = jogValida + 1;
					jogValida = 'O';
					// System.out.println("Jogada valida horizontal da direita para esquerda: " + (i
					// + 1) + "," + (j + 1)
					// + " - " + (i + 1) + "," + (j - 1));
				}
			}
		}
		// final do metodo resta1
		return jogValida;
	}

	private static void jogada() {
		Scanner scan = new Scanner(System.in);
		int lin1, lin2;
		int col1, col2;
		int pecas = 32;
		do {
			System.out.println();
			System.out.println("DIGITE A PRIMEIRA POSIÇÃO (LINHA x COLUNA):");
			lin1 = scan.nextInt();
			col1 = scan.nextInt();
			System.out.println("DIGITE A SEGUNDA POSIÇÃO (LINHA x COLUNA):");
			lin2 = scan.nextInt();
			col2 = scan.nextInt();
			if (valida(lin1, lin2, col1, col2) == false) {

				System.out.println();
				System.out.println("JOGADA INVALIDA!! DIGITE NOVAMENTE!!");
				System.out.println();
				mostraDados();
				System.out.println();
			}
		} while (valida(lin1, lin2, col1, col2) == false);
		trocavalores(lin1, lin2, col1, col2);
		System.out.println("PERFEITO! INFORME A PRÓXIMA JOGADA");
	
		//System.out.println("Existe ainda " + (pecas-1) + " Peças"); // imprimi informando quantas peças ainda existem
		//pecas--;
		// final do metodo jogada.
	}

	private static void trocavalores(int lin1, int lin2, int col1, int col2) {
		if (((lin2 - lin1) == 2 || (lin1 - lin2) == 2) && col1 == col2) {
			if (lin2 - lin1 == 2) {
				tabuleiro[lin1][col1] = 'X';
				tabuleiro[lin2][col2] = 'O';
				tabuleiro[lin1 + 1][col1] = 'X';
			} else {
				tabuleiro[lin1][col1] = 'X';
				tabuleiro[lin2][col2] = 'O';
				tabuleiro[lin1 - 1][col1] = 'X';
			}
		} else if ((col1 - col2 == 2 || col2 - col1 == 2) && lin1 == lin2) {
			if (col2 - col1 == 2) {
				tabuleiro[lin1][col1] = 'X';
				tabuleiro[lin2][col2] = 'O';
				tabuleiro[lin1][col1 + 1] = 'X';
			} else {
				tabuleiro[lin1][col1] = 'X';
				tabuleiro[lin2][col2] = 'O';
				tabuleiro[lin1][col1 - 1] = 'X';
			}
		}
	}

	private static boolean valida(int lin1, int lin2, int col1, int col2) {
		if (((lin2 - lin1) == 2 || (lin1 - lin2) == 2) && col1 == col2) {
			if ((lin2 - lin1) == 2 && tabuleiro[lin1][col1] == 1 && tabuleiro[lin2][col2] == 0
					&& tabuleiro[lin1 + 1][col1] == 1) {
				return true;
			} else if ((lin1 - lin2) == 2 && tabuleiro[lin1][col1] == 1 && tabuleiro[lin2][col2] == 0
					&& tabuleiro[lin1 - 1][col1] == 1) {
				return true;
			} else {
				return false;
			}
		} else if ((col1 - col2) == 2 || (col2 - col1) == 2 && lin1 == lin2) {
			if ((col2 - col1) == 2 && tabuleiro[lin1][col1] == 1 && tabuleiro[lin2][col2] == 0
					&& tabuleiro[lin1][col1 + 1] == 1) {
				return true;
			} else if ((col1 - col2) == 2 && tabuleiro[lin1][col1] == 1 && tabuleiro[lin2][col2] == 0
					&& tabuleiro[lin1][col1 - 1] == 1) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
		// final do metodo valida.
	}
	// final do código
}
