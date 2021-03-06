import java.util.Scanner;

public class gambiarra {
	static int t = 7; // variavel que determinal o tamanho do tabuleiro
	static int[][] tabuleiro = new int[t][t];
	static int pecas; // indica contador

	public static void main(String[] args) {
		pecas = 32;
		System.out.println("*****************************");
		System.out.println("* BEM VINDO AO RESTA UM !!! *");
		System.out.println("*****************************");
		System.out.println(
				"Resta um é um quebra-cabeça cujo objetivo é, por meio de movimentos válidos, deixar apenas uma peça no tabuleiro.");
		System.out.println();
		System.out.println("AUTOR: Renan Acosta - Todos os direitos reservados.");
		System.out.println();
		System.out.println();

		inicializar();
		do {
			mostraDados();
			resta1();
			jogada();

		} while (resta1() >= 1);
		System.out.println("***************");
		System.out.println("* FIM DE JOGO *");
		System.out.println("***************");
		System.out.println();
		System.out.println("===================");
		System.out.println();
		mostraDados();
		System.out.println();
		System.out.println("===================");
		System.out.println();
		System.out.println("OBRIGADO POR JOGAR!");
		System.out.println();

		if (pecas > 1) {												// CONDIÇÃO DE VENCEDOR OU PERDEDOR
			System.out.println("#################################");
			System.out.println("# VOCÊ PERDEU! TENTE NOVAMENTE. #");
			System.out.println("#################################");
		} else {
			System.out.println("##########################");
			System.out.println("# PARABÉNS! VOCÊ GANHOU. #");
			System.out.println("##########################");
		}

	}

	private static void inicializar() {
		for (int i = 0; i < t; i++) {
			for (int j = 0; j < t; j++) {

				tabuleiro[i][j] = 1;

				tabuleiro[0][0] = 3;
				tabuleiro[0][1] = 3;
				tabuleiro[1][0] = 3;
				tabuleiro[1][1] = 3; // Canto superior esquerdo

				tabuleiro[0][5] = 3;
				tabuleiro[0][6] = 3;
				tabuleiro[1][5] = 3;
				tabuleiro[1][6] = 3; // Canto superior direito

				tabuleiro[5][0] = 3;
				tabuleiro[6][0] = 3;
				tabuleiro[5][1] = 3;
				tabuleiro[6][1] = 3; // Canto inferior esquerdo

				tabuleiro[5][5] = 3;
				tabuleiro[5][6] = 3;
				tabuleiro[6][5] = 3;
				tabuleiro[6][6] = 3; // Canto inferior direito
			}
		}

		int meio;
		meio = (t / 2);
		tabuleiro[meio][meio] = 0;
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
				if (tabuleiro[i][j] == 3) {
					System.out.print(" " + " ");
				} else {
					char p = ' ';
					switch (tabuleiro[i][j]) {
					case 1:
						p = 'O';
						break;
					case 0:
						p = 'X';
						break;
					case 3:
						p = ' ';
						break;
					}
					System.out.print(p + " ");
				}
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
		do {

			System.out.println();
			do {
				System.out.println("==>> INFORME A POSIÇÃO DE ORIGEM DA PEÇA (LINHA x COLUNA):");
				lin1 = scan.nextInt();
				col1 = scan.nextInt();
				System.out.println();
				if (tabuleiro[lin1][col1] == 3) {
					System.out.println("================================================================");
					System.out.println("| O VALOR DIGITADO NÃO É UM ESPAÇO VÁLIDO. DIGITE NOVAMENTE!!! |");
					System.out.println("================================================================");
					System.out.println();
				}
			} while ((tabuleiro[lin1][col1] == 3));
			do {
				System.out.println("==>> INFORME A POSIÇÃO DE DESTINO DA PEÇA (LINHA x COLUNA):");
				lin2 = scan.nextInt();
				col2 = scan.nextInt();
				System.out.println();
				if (tabuleiro[lin2][col2] == 3) {
					System.out.println("================================================================");
					System.out.println("| O VALOR DIGITADO NÃO É UM ESPAÇO VÁLIDO. DIGITE NOVAMENTE!!! |");
					System.out.println("================================================================");
					System.out.println();
				}
			} while ((tabuleiro[lin2][col2] == 3));

			if (valida(lin1, lin2, col1, col2) == false) {
				// ANULA OS CANTOS DO TABULEIRO, INFORMANDO QUE NÃO É UMA JOGADA VÁLIDA

				System.out.println();
				System.out.println("=========================================");
				System.out.println("| JOGADA INVALIDA!! DIGITE NOVAMENTE!!! |");
				System.out.println("=========================================");
				System.out.println();
				System.out.println("Existe ainda " + pecas + " peças:");
				System.out.println();
				mostraDados();
				System.out.println();
			}
		} while (valida(lin1, lin2, col1, col2) == false);
		trocavalores(lin1, lin2, col1, col2);
		System.out.println("======================================");
		System.out.println("| PERFEITO! INFORME A PRÓXIMA JOGADA |");
		System.out.println("======================================");

		pecas--;
		System.out.println();
		System.out.println("Existe ainda " + pecas + " peças:");

		// final do metodo jogada.
	}

	private static void trocavalores(int lin1, int lin2, int col1, int col2) {
		if (((lin2 - lin1) == 2 || (lin1 - lin2) == 2) && col1 == col2) {
			if (lin2 - lin1 == 2) {
				tabuleiro[lin1][col1] = 0;
				tabuleiro[lin2][col2] = 1;
				tabuleiro[lin1 + 1][col1] = 0;
			} else {
				tabuleiro[lin1][col1] = 0;
				tabuleiro[lin2][col2] = 1;
				tabuleiro[lin1 - 1][col1] = 0;
			}
		} else if ((col1 - col2 == 2 || col2 - col1 == 2) && lin1 == lin2) {
			if (col2 - col1 == 2) {
				tabuleiro[lin1][col1] = 0;
				tabuleiro[lin2][col2] = 1;
				tabuleiro[lin1][col1 + 1] = 0;
			} else {
				tabuleiro[lin1][col1] = 0;
				tabuleiro[lin2][col2] = 1;
				tabuleiro[lin1][col1 - 1] = 0;
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
