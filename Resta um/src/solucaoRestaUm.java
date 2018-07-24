import java.util.Scanner;

public class solucaoRestaUm {

	static void imprimaTabuleiro(int[][] tab) {

		String tabuleiro_grafico = "";
		String peca = "";
		for (int i = 0; i < tab.length; i++) {
			tabuleiro_grafico += "\n";
			for (int j = 0; j < tab.length; j++) {
				switch (tab[j][i]) {
				case 0:
					peca = " ";
					break;
				case 1:
					peca = "X";
					break;
				case 2:
					peca = "O";
					break;
				}
				tabuleiro_grafico += "   " + peca;
			}
		}

		System.out.println(tabuleiro_grafico);

	}

	static void jogar(int[][] tab) {
		Scanner scan = new Scanner(System.in);

		int Linha1, Coluna1, Linha2, Coluna2;
		System.out.println("Insira a posição inicial (LINHA X COLUNA):");
		Linha1 = scan.nextInt();
		Coluna1 = scan.nextInt();
		System.out.println("Insira a posição final (LINHA X COLUNA):");
		Linha2 = scan.nextInt();
		Coluna2 = scan.nextInt();

		int deltaX = 0;
		int deltaY = 0;

		// REFLETIR AQUI. PENSAR UM POUCO MAIS COMO RESOLVER E TESTAR A EXECUÇÃO DESSE
		// IF. A PERGUNTA É: ESTÁ CORRETA?

		if (tab[Linha1][Coluna1] == 2) {
			if (tab[Linha2][Coluna2] == 1) {
				if (((Math.abs(Linha1 - Linha2) == 2) && ((Coluna1 - Coluna2) == 0))
						|| ((Math.abs(Linha1 - Linha2) == 0) && ((Coluna1 - Coluna2) == 2))) {

					tab[Linha2][Coluna2] = 2;
					tab[Linha1][Coluna1] = 1;
					if (Linha2 > Linha1)
						deltaX = -1;
					if (Linha1 < Linha2)
						deltaX = 1;
					if (Coluna2 > Coluna1)
						deltaY = -1;
					if (Coluna1 < Coluna2)
						deltaY = 1;

					tab[Linha2 - deltaX][Coluna2 - deltaY] = 1;

				}

			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] tabuleiro = new int[7][7];
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro.length; j++) {
				tabuleiro[i][j] = 2;
			}
		}

		tabuleiro[3][3] = 1;

		// _ _ * * * _ _
		// _ _ * * * _ _
		// * * * * * * *
		// * * * . * * *
		// * * * * * * *
		// _ _ * * * _ _
		// _ _ * * * _ _

		// 0 - BLOQUEIO -> "_"
		// 1 - VAZIO -> "."
		// 2 - PEÇA -> "*"

		tabuleiro[0][0] = 0;
		tabuleiro[0][1] = 0;
		tabuleiro[1][0] = 0;
		tabuleiro[1][1] = 0; // primeiro canto

		tabuleiro[0][5] = 0;
		tabuleiro[0][6] = 0;
		tabuleiro[1][5] = 0;
		tabuleiro[1][6] = 0; // segundo canto

		tabuleiro[5][0] = 0;
		tabuleiro[6][0] = 0;
		tabuleiro[5][1] = 0;
		tabuleiro[6][1] = 0; // terceiro canto

		tabuleiro[5][5] = 0;
		tabuleiro[5][6] = 0;
		tabuleiro[6][5] = 0;
		tabuleiro[6][6] = 0; // quarto canto

		imprimaTabuleiro(tabuleiro);

		jogar(tabuleiro);

		imprimaTabuleiro(tabuleiro);

	}

}