import java.util.Scanner;

public class teste {

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
					peca = "*";
					break;
				}
				tabuleiro_grafico += "   " + peca;
			}
		}
		System.out.println(tabuleiro_grafico);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

		int jogador = 1; // jogador 1 começa jogando
		int posx1;
		int posy1;
		int posx2;
		int posy2;
		int pecas = 32; // quantidade de peças = 15
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
		// * * * X * * *
		// * * * * * * *
		// _ _ * * * _ _
		// _ _ * * * _ _

		// 0 - BLOQUEIO -> "_"
		// 1 - VAZIO -> "X"
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
		do {
			System.out.println("Jogador: " + jogador + ". Insira as duas posições iniciais: ");
			posx1 = scan.nextInt(); // LER POSI. x INICIAL
			posy1 = scan.nextInt(); // LER POSI. y INICIAL
			System.out.println("Ok, " + jogador + " Agora insira as duas posições finais: ");
			posx2 = scan.nextInt(); // LER POSI. x FINAL
			posy2 = scan.nextInt(); // LER POSI. y FINAL
			boolean jogadaValida = jogar(posx1, posx2, posy1, posy2, tabuleiro, jogador, pecas);
			if (jogadaValida) // se jogada válida...
			{
				pecas--; // diminui uma peça
				System.out.println("Existe ainda " + pecas + " Peças"); // imprimi informando quantas peças exixtem
				if (pecas == 1) // se peças ==1....
					System.out.println("Jogador  " + jogador + "  venceu!"); // mostra vencedor
				// troca jogador
				if (jogador == 1) {
					jogador = 2;
				} else {
					jogador = 1;
				}
			} else {
				System.out.println("Jogada Inválida!!");
				System.out.println("Tente Novamente!!");
				imprimaTabuleiro(tabuleiro);
			}
		} while (pecas > 1);
	}

	static boolean jogar(int posx1, int posx2, int posy1, int posy2, int[][] tabuleiro, int j, int pecas) {
		// teste se posy1 != posy2 na vertical
		if (posy1 < posy2 && posx1 != posx2 || posy1 > posy2 && posx1 > posx2 || posy1 < posy2 && posx1 < posx2
				|| posy1 > posy2 && posx1 < posx2) {
			return false;
		}
		// verifica -- Na horizontal
		if (posx1 == 1 && posy1 == 0 && posx2 == 1 && posy2 == 1 // nao existe 1,0 e 1,1
				|| posx1 == 1 && posy1 == 1 && posx2 == 1 && posy2 == 2 // nao existe 1,1 e 1,2
				|| posx1 == 1 && posy1 == 2 && posx2 == 1 && posy2 == 3 // nao existe 1,2 e 1,3
				|| posx1 == 1 && posy1 == 3 && posx2 == 1 && posy2 == 2 // nao existe 1,3 e 1,2
				|| posx1 == 1 && posy1 == 2 && posx2 == 1 && posy2 == 1 // nao existe 1,2 e 1,1
				|| posx1 == 1 && posy1 == 0 && posx2 == 1 && posy2 == 0 // nao existe 1,1 e 1,0
				|| posx1 == 1 && posy1 == 1 && posx2 == 1 && posy2 == 1
				|| posx1 == 0 && posy1 == 2 && posx2 == 0 && posy2 == 2 // 0,0 e 0,1
				|| posx1 == 0 && posy1 == 3 && posx2 == 0 && posy2 == 3 // 0,1 e 0,2
				|| posx1 == 0 && posy1 == 2 && posx2 == 0 && posy2 == 2 // 0,2 e 0,3
				|| posx1 == 0 && posy1 == 1 && posx2 == 0 && posy2 == 1 // 0,3 e 0,2
				|| posx1 == 0 && posy1 == 0 && posx2 == 0 && posy2 == 0 // 0,2 e 0,1
				|| posx1 == 0 && posy1 == 1 && posx2 == 0 && posy2 == 1 // 0,1 e 0,0
				|| posx1 == 2 && posy1 == 2 && posx2 == 2 && posy2 == 2
				|| posx1 == 2 && posy1 == 3 && posx2 == 2 && posy2 == 3
				|| posx1 == 2 && posy1 == 2 && posx2 == 2 && posy2 == 2
				|| posx1 == 2 && posy1 == 1 && posx2 == 2 && posy2 == 1
				|| posx1 == 2 && posy1 == 0 && posx2 == 2 && posy2 == 0
				|| posx1 == 2 && posy1 == 1 && posx2 == 2 && posy2 == 1
				|| posx1 == 3 && posy1 == 2 && posx2 == 3 && posy2 == 2
				|| posx1 == 3 && posy1 == 3 && posx2 == 3 && posy2 == 3
				|| posx1 == 3 && posy1 == 2 && posx2 == 3 && posy2 == 2
				|| posx1 == 3 && posy1 == 1 && posx2 == 3 && posy2 == 1
				|| posx1 == 3 && posy1 == 0 && posx2 == 3 && posy2 == 0
				|| posx1 == 3 && posy1 == 1 && posx2 == 3 && posy2 == 1
				|| posx1 == 4 && posy1 == 2 && posx2 == 4 && posy2 == 2
				|| posx1 == 4 && posy1 == 3 && posx2 == 4 && posy2 == 3
				|| posx1 == 4 && posy1 == 2 && posx2 == 4 && posy2 == 2
				|| posx1 == 4 && posy1 == 1 && posx2 == 4 && posy2 == 1
				|| posx1 == 4 && posy1 == 0 && posx2 == 4 && posy2 == 0
				|| posx1 == 4 && posy1 == 1 && posx2 == 4 && posy2 == 1
				|| posx1 == 5 && posy1 == 2 && posx2 == 5 && posy2 == 2
				|| posx1 == 5 && posy1 == 3 && posx2 == 5 && posy2 == 3
				|| posx1 == 5 && posy1 == 2 && posx2 == 5 && posy2 == 2
				|| posx1 == 5 && posy1 == 1 && posx2 == 5 && posy2 == 1
				|| posx1 == 5 && posy1 == 0 && posx2 == 5 && posy2 == 0
				|| posx1 == 5 && posy1 == 1 && posx2 == 5 && posy2 == 1
				|| posx1 == 6 && posy1 == 2 && posx2 == 6 && posy2 == 2
				|| posx1 == 6 && posy1 == 3 && posx2 == 6 && posy2 == 3
				|| posx1 == 6 && posy1 == 2 && posx2 == 6 && posy2 == 2
				|| posx1 == 6 && posy1 == 1 && posx2 == 6 && posy2 == 1
				|| posx1 == 6 && posy1 == 0 && posx2 == 6 && posy2 == 0
				|| posx1 == 6 && posy1 == 1 && posx2 == 6 && posy2 == 1) {
			return false;
		}
		// verifica -- Na vertical
		if (posx1 == 0 && posy1 == 0 && posx2 == 1 && posy2 == 0 // nao existe 0,0 e 1,0
				|| posx1 == 1 && posy1 == 0 && posx2 == 2 && posy2 == 0 // nao existe 1,0 e 2,0
				|| posx1 == 2 && posy1 == 0 && posx2 == 3 && posy2 == 0 // nao existe 2,0 e 3,0
				|| posx1 == 3 && posy1 == 0 && posx2 == 2 && posy2 == 0 // nao existe 3,0 e 2,0
				|| posx1 == 2 && posy1 == 0 && posx2 == 1 && posy2 == 0 // nao existe 2,0 e 1,0
				|| posx1 == 1 && posy1 == 0 && posx2 == 0 && posy2 == 0 // nao existe 1,0 e 0,0
				|| posx1 == 0 && posy1 == 0 && posx2 == 2 && posy2 == 0
				|| posx1 == 1 && posy1 == 1 && posx2 == 1 && posy2 == 1 //
				|| posx1 == 2 && posy1 == 1 && posx2 == 2 && posy2 == 1 //
				|| posx1 == 3 && posy1 == 1 && posx2 == 3 && posy2 == 1 //
				|| posx1 == 2 && posy1 == 1 && posx2 == 2 && posy2 == 1 //
				|| posx1 == 1 && posy1 == 1 && posx2 == 1 && posy2 == 1 //
				|| posx1 == 0 && posy1 == 1 && posx2 == 0 && posy2 == 1 //
				|| posx1 == 1 && posy1 == 2 && posx2 == 1 && posy2 == 2
				|| posx1 == 2 && posy1 == 2 && posx2 == 2 && posy2 == 2
				|| posx1 == 3 && posy1 == 2 && posx2 == 3 && posy2 == 2
				|| posx1 == 2 && posy1 == 2 && posx2 == 2 && posy2 == 2
				|| posx1 == 1 && posy1 == 2 && posx2 == 1 && posy2 == 2
				|| posx1 == 0 && posy1 == 2 && posx2 == 0 && posy2 == 2
				|| posx1 == 1 && posy1 == 3 && posx2 == 1 && posy2 == 3
				|| posx1 == 2 && posy1 == 3 && posx2 == 2 && posy2 == 3
				|| posx1 == 3 && posy1 == 3 && posx2 == 3 && posy2 == 3
				|| posx1 == 2 && posy1 == 3 && posx2 == 2 && posy2 == 3
				|| posx1 == 1 && posy1 == 3 && posx2 == 1 && posy2 == 3
				|| posx1 == 0 && posy1 == 3 && posx2 == 0 && posy2 == 3
				|| posx1 == 1 && posy1 == 4 && posx2 == 1 && posy2 == 4
				|| posx1 == 2 && posy1 == 4 && posx2 == 2 && posy2 == 4
				|| posx1 == 3 && posy1 == 4 && posx2 == 3 && posy2 == 4
				|| posx1 == 2 && posy1 == 4 && posx2 == 2 && posy2 == 4
				|| posx1 == 1 && posy1 == 4 && posx2 == 1 && posy2 == 4
				|| posx1 == 0 && posy1 == 4 && posx2 == 0 && posy2 == 4
				|| posx1 == 1 && posy1 == 5 && posx2 == 1 && posy2 == 5
				|| posx1 == 2 && posy1 == 5 && posx2 == 2 && posy2 == 5
				|| posx1 == 3 && posy1 == 5 && posx2 == 3 && posy2 == 5
				|| posx1 == 2 && posy1 == 5 && posx2 == 2 && posy2 == 5
				|| posx1 == 1 && posy1 == 5 && posx2 == 1 && posy2 == 5
				|| posx1 == 0 && posy1 == 5 && posx2 == 0 && posy2 == 5
				|| posx1 == 1 && posy1 == 6 && posx2 == 1 && posy2 == 6
				|| posx1 == 2 && posy1 == 6 && posx2 == 2 && posy2 == 6
				|| posx1 == 3 && posy1 == 6 && posx2 == 3 && posy2 == 6
				|| posx1 == 2 && posy1 == 6 && posx2 == 2 && posy2 == 6
				|| posx1 == 1 && posy1 == 6 && posx2 == 1 && posy2 == 6
				|| posx1 == 0 && posy1 == 6 && posx2 == 0 && posy2 == 6) {
			return false;
		}
		if (posx1 > 3 || posx1 < 0 || posy1 > 3 || posy1 < 0 || posx2 > 3 || posx2 < 0 || posy2 > 3 || posy1 < 0
				|| tabuleiro[posx1][posy1] != 1 || tabuleiro[posx2][posy2] != 0) {
			return false;
		}
		if (posx1 == 0 && posy1 == 0 && posx2 == 0 && posy2 == 3
				|| posx1 == 0 && posy1 == 3 && posx2 == 0 && posy2 == 0) {
			return false;
		}
		if (posx1 == 1 && posy1 == 0 && posx2 == 1 && posy2 == 3
				|| posx1 == 1 && posy1 == 3 && posx2 == 1 && posy2 == 0) {
			return false;
		}
		if (posx1 == 2 && posy1 == 0 && posx2 == 2 && posy2 == 3
				|| posx1 == 2 && posy1 == 3 && posx2 == 2 && posy2 == 0) {
			return false;
		}
		if (posx1 == 3 && posy1 == 0 && posx2 == 3 && posy2 == 3
				|| posx1 == 3 && posy1 == 3 && posx2 == 3 && posy2 == 0) {
			return false;
		}
		if (posx1 == 3 && posy1 == 0 && posx2 == 0 && posy2 == 0
				|| posx1 == 0 && posy1 == 0 && posx2 == 3 && posy2 == 0) {
			return false;
		}
		if (posx1 == 3 && posy1 == 1 && posx2 == 0 && posy2 == 1
				|| posx1 == 0 && posy1 == 1 && posx2 == 3 && posy2 == 1) {
			return false;
		}
		if (posx1 == 3 && posy1 == 2 && posx2 == 0 && posy2 == 2
				|| posx1 == 0 && posy1 == 2 && posx2 == 3 && posy2 == 2) {
			return false;
		}
		if (posx1 == 3 && posy1 == 3 && posx2 == 0 && posy2 == 3
				|| posx1 == 0 && posy1 == 3 && posx2 == 3 && posy2 == 3) {
			return false;
		}
		if (posx1 == 0 && posy1 == 1 && posx2 == 2 && posy2 == 1)//
		{
			if (tabuleiro[1][1] == 0) {
				return false;
			} else
				tabuleiro[0][1] = 0;
			tabuleiro[2][1] = 1;
			tabuleiro[1][1] = 0;
			System.out.println();
			imprimaTabuleiro(tabuleiro);
		} else if (posx1 == 0 && posy1 == 3 && posx2 == 0 && posy2 == 1)//
		{
			if (tabuleiro[0][3] == 0) {
				return false;
			} else
				tabuleiro[0][1] = 1;
			tabuleiro[0][3] = 0;
			tabuleiro[0][2] = 0;
			System.out.println();
			imprimaTabuleiro(tabuleiro);
		} else if (posx1 == 1 && posy1 == 1 && posx2 == 3 && posy2 == 1)//
		{
			if (tabuleiro[2][1] == 0) {
				return false;
			} else
				tabuleiro[1][1] = 0;
			tabuleiro[2][1] = 0;
			tabuleiro[3][1] = 1;
			System.out.println();
			imprimaTabuleiro(tabuleiro);
		} else if (posx1 == 1 && posy1 == 3 && posx2 == 1 && posy2 == 1)//
		{
			if (tabuleiro[1][2] == 0) {
				return false;
			} else
				tabuleiro[1][3] = 0;
			tabuleiro[1][2] = 0;
			tabuleiro[1][1] = 1;
			System.out.println();
			imprimaTabuleiro(tabuleiro);
		} else if (posx1 == 0 && posy1 == 0 && posx2 == 0 && posy2 == 2)//
		{
			if (tabuleiro[0][1] == 0) {
				return false;
			} else
				tabuleiro[0][0] = 0;
			tabuleiro[0][1] = 0;
			tabuleiro[0][2] = 1;
			System.out.println();
			imprimaTabuleiro(tabuleiro);
		} else if (posx1 == 3 && posy1 == 1 && posx2 == 1 && posy2 == 1)//
		{
			if (tabuleiro[2][1] == 0) {
				return false;
			} else
				tabuleiro[3][1] = 0;
			tabuleiro[2][1] = 0;
			tabuleiro[1][1] = 1;
			System.out.println();
			imprimaTabuleiro(tabuleiro);
		} else if (posx1 == 3 && posy1 == 3 && posx2 == 3 && posy2 == 1)//
		{
			if (tabuleiro[3][2] == 0) {
				return false;
			} else
				tabuleiro[3][3] = 0;
			tabuleiro[3][2] = 0;
			tabuleiro[3][1] = 1;
			System.out.println();
			imprimaTabuleiro(tabuleiro);
		} else if (posx1 == 0 && posy1 == 3 && posx2 == 2 && posy2 == 3)//
		{
			if (tabuleiro[1][3] == 0) {
				return false;
			} else
				tabuleiro[0][3] = 0;
			tabuleiro[2][3] = 1;
			tabuleiro[1][3] = 0;
			System.out.println();
			imprimaTabuleiro(tabuleiro);
		} else if (posx1 == 2 && posy1 == 3 && posx2 == 0 && posy2 == 3)//
		{
			if (tabuleiro[1][3] == 0) {
				return false;
			} else
				tabuleiro[2][3] = 0;
			tabuleiro[0][3] = 1;
			tabuleiro[1][3] = 0;
			System.out.println();
			imprimaTabuleiro(tabuleiro);
		} else if (posx1 == 2 && posy1 == 3 && posx2 == 2 && posy2 == 1)//
		{
			if (tabuleiro[2][2] == 0) {
				return false;
			} else
				tabuleiro[2][3] = 0;
			tabuleiro[2][2] = 0;
			tabuleiro[2][1] = 1;
			System.out.println();
			imprimaTabuleiro(tabuleiro);
		} else if (posx1 == 0 && posy1 == 3 && posx2 == 2 && posy2 == 3)//
		{
			if (tabuleiro[1][3] == 0) {
				return false;
			} else
				tabuleiro[0][3] = 0;
			tabuleiro[1][3] = 0;
			tabuleiro[2][3] = 1;
			System.out.println();
			imprimaTabuleiro(tabuleiro);
		} else if (posx1 == 0 && posy1 == 2 && posx2 == 2 && posy2 == 2)//
		{
			if (tabuleiro[1][2] == 0) {
				return false;
			} else
				tabuleiro[0][2] = 0;
			tabuleiro[1][2] = 0;
			tabuleiro[2][2] = 1;
			System.out.println();
			imprimaTabuleiro(tabuleiro);
		} else if (posx1 == 2 && posy1 == 1 && posx2 == 0 && posy2 == 1)//
		{
			if (tabuleiro[1][1] == 0) {
				return false;
			} else
				tabuleiro[2][1] = 0;
			tabuleiro[1][1] = 0;
			tabuleiro[0][1] = 1;
			System.out.println();
			imprimaTabuleiro(tabuleiro);
		} else if (posx1 == 1 && posy1 == 0 && posx2 == 1 && posy2 == 2)//
		{
			if (tabuleiro[1][1] == 0) {
				return false;
			} else
				tabuleiro[1][0] = 0;
			tabuleiro[1][1] = 0;
			tabuleiro[1][2] = 1;
			System.out.println();
			imprimaTabuleiro(tabuleiro);
		} else if (posx1 == 3 && posy1 == 3 && posx2 == 1 && posy2 == 3)//
		{
			if (tabuleiro[2][3] == 0) {
				return false;
			} else
				tabuleiro[3][3] = 0;
			tabuleiro[2][3] = 0;
			tabuleiro[1][3] = 1;
			System.out.println();
			imprimaTabuleiro(tabuleiro);
		} else if (posx1 == 0 && posy1 == 1 && posx2 == 0 && posy2 == 3)//
		{
			if (tabuleiro[0][2] == 0) {
				return false;
			} else
				tabuleiro[0][1] = 0;
			tabuleiro[0][2] = 0;
			tabuleiro[0][3] = 1;
			System.out.println();
			imprimaTabuleiro(tabuleiro);
		} else if (posx1 == 2 && posy1 == 2 && posx2 == 0 && posy2 == 2)//
		{
			if (tabuleiro[1][2] == 0) {
				return false;
			} else
				tabuleiro[2][2] = 0;
			tabuleiro[1][2] = 0;
			tabuleiro[0][2] = 1;
			System.out.println();
			imprimaTabuleiro(tabuleiro);
		} else if (posx1 == 3 && posy1 == 0 && posx2 == 3 && posy2 == 2)//
		{
			if (tabuleiro[3][1] == 0) {
				return false;
			} else
				tabuleiro[3][0] = 0;
			tabuleiro[3][1] = 0;
			tabuleiro[3][2] = 1;
			System.out.println();
			imprimaTabuleiro(tabuleiro);
		} else if (posx1 == 2 && posy1 == 0 && posx2 == 2 && posy2 == 2)//
		{
			if (tabuleiro[2][1] == 0) {
				return false;
			} else
				tabuleiro[2][0] = 0;
			tabuleiro[2][1] = 0;
			tabuleiro[2][2] = 1;
			System.out.println();
			imprimaTabuleiro(tabuleiro);
		} else if (posx1 == 1 && posy1 == 0 && posx2 == 3 && posy2 == 0)//
		{
			if (tabuleiro[2][0] == 0) {
				return false;
			} else
				tabuleiro[1][0] = 0;
			tabuleiro[2][0] = 0;
			tabuleiro[3][0] = 1;
			System.out.println();
			imprimaTabuleiro(tabuleiro);
		} else if (posx1 == 1 && posy1 == 3 && posx2 == 3 && posy2 == 3)//
		{
			if (tabuleiro[2][3] == 0) {
				return false;
			} else
				tabuleiro[1][3] = 0;
			tabuleiro[2][3] = 0;
			tabuleiro[3][3] = 1;
			System.out.println();
			imprimaTabuleiro(tabuleiro);
		} else if (posx1 == 1 && posy1 == 2 && posx2 == 1 && posy2 == 0)//
		{
			if (tabuleiro[1][1] == 0) {
				return false;
			} else
				tabuleiro[1][2] = 0;
			tabuleiro[1][1] = 0;
			tabuleiro[1][0] = 1;
			System.out.println();
			imprimaTabuleiro(tabuleiro);
		} else if (posx1 == 2 && posy1 == 1 && posx2 == 2 && posy2 == 3)//
		{
			if (tabuleiro[2][2] == 0) {
				return false;
			} else
				tabuleiro[2][1] = 0;
			tabuleiro[2][2] = 0;
			tabuleiro[2][3] = 1;
			System.out.println();
			imprimaTabuleiro(tabuleiro);
		} else if (posx1 == 1 && posy1 == 2 && posx2 == 3 && posy2 == 2)//
		{
			if (tabuleiro[2][2] == 0) {
				return false;
			} else
				tabuleiro[1][2] = 0;
			tabuleiro[2][2] = 0;
			tabuleiro[3][2] = 1;
			System.out.println();
			imprimaTabuleiro(tabuleiro);
		} else if (posx1 == 1 && posy1 == 1 && posx2 == 1 && posy2 == 3)//
		{
			if (tabuleiro[1][2] == 0) {
				return false;
			} else
				tabuleiro[1][1] = 0;
			tabuleiro[1][2] = 0;
			tabuleiro[1][3] = 1;
			System.out.println();
			imprimaTabuleiro(tabuleiro);
		} else if (posx1 == 2 && posy1 == 0 && posx2 == 0 && posy2 == 0)//
		{
			if (tabuleiro[1][0] == 0) {
				return false;
			} else
				tabuleiro[2][0] = 0;
			tabuleiro[1][0] = 0;
			tabuleiro[0][0] = 1;
			System.out.println();
			imprimaTabuleiro(tabuleiro);
		} else if (posx1 == 3 && posy1 == 1 && posx2 == 3 && posy2 == 3)//
		{
			if (tabuleiro[3][2] == 0) {
				return false;
			} else
				tabuleiro[3][1] = 0;
			tabuleiro[3][2] = 0;
			tabuleiro[3][3] = 1;
			System.out.println();
			imprimaTabuleiro(tabuleiro);
		} else if (posx1 == 3 && posy1 == 2 && posx2 == 1 && posy2 == 2)//
		{
			if (tabuleiro[2][2] == 0) {
				return false;
			} else
				tabuleiro[3][2] = 0;
			tabuleiro[2][2] = 0;
			tabuleiro[1][2] = 1;
			System.out.println();
			imprimaTabuleiro(tabuleiro);
		} else if (posx1 == 2 && posy1 == 2 && posx2 == 2 && posy2 == 0)//
		{
			if (tabuleiro[2][1] == 0) {
				return false;
			} else
				tabuleiro[2][2] = 0;
			tabuleiro[2][1] = 0;
			tabuleiro[2][0] = 1;
			System.out.println();
			imprimaTabuleiro(tabuleiro);
		} else if (posx1 == 0 && posy1 == 0 && posx2 == 2 && posy2 == 0)//
		{
			if (tabuleiro[1][0] == 0) {
				return false;
			} else
				tabuleiro[0][0] = 0;
			tabuleiro[1][0] = 0;
			tabuleiro[2][0] = 1;
			System.out.println();
			imprimaTabuleiro(tabuleiro);
		} else if (posx1 == 3 && posy1 == 2 && posx2 == 3 && posy2 == 0) {
			if (tabuleiro[3][1] == 0) {
				return false;
			} else
				tabuleiro[3][2] = 0;
			tabuleiro[3][1] = 0;
			tabuleiro[3][0] = 1;
			System.out.println();
			imprimaTabuleiro(tabuleiro);
		} else if (posx1 == 3 && posy1 == 0 && posx2 == 1 && posy2 == 0)//
		{
			if (tabuleiro[2][0] == 0) {
				return false;
			} else
				tabuleiro[3][0] = 0;
			tabuleiro[2][0] = 0;
			tabuleiro[1][0] = 1;
			System.out.println();
			imprimaTabuleiro(tabuleiro);
		}
		return true;
	}

	
}
