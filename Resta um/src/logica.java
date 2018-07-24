import java.util.Scanner;

public class logica {
    public static void pr(String str) {
    	System.out.println(str);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int[][] tabuleiro = new int[7][7];
		int jogador = 1; // jogador 1 começa jogando
		int Linha1, Coluna1, Linha2, Coluna2;
		int pecas = 32; // quantidade de peças
		
		// imprimi o primeiro tabuleiro
		tabuleiro[0][0] = 0; // canto sem peça do tabuleiro
		tabuleiro[0][1] = 0; // canto sem peça do tabuleiro
		tabuleiro[0][2] = 1;
		tabuleiro[0][3] = 1;
		tabuleiro[0][4] = 1;
		tabuleiro[0][5] = 0; // canto sem peça do tabuleiro
		tabuleiro[0][6] = 0; // canto sem peça do tabuleiro
		tabuleiro[1][0] = 0; // canto sem peça do tabuleiro
		tabuleiro[1][1] = 0; // canto sem peça do tabuleiro
		tabuleiro[1][2] = 1;
		tabuleiro[1][3] = 1;
		tabuleiro[1][4] = 1;
		tabuleiro[1][5] = 0; // canto sem peça do tabuleiro
		tabuleiro[1][6] = 0; // canto sem peça do tabuleiro
		tabuleiro[2][0] = 1;
		tabuleiro[2][1] = 1;
		tabuleiro[2][2] = 1;
		tabuleiro[2][3] = 1;
		tabuleiro[2][4] = 1;
		tabuleiro[2][5] = 1;
		tabuleiro[2][6] = 1;
		tabuleiro[3][0] = 1;
		tabuleiro[3][1] = 1;
		tabuleiro[3][2] = 1;
		tabuleiro[3][3] = 0;// peça vazia central do tabuleiro = 0
		tabuleiro[3][4] = 1;
		tabuleiro[3][5] = 1;
		tabuleiro[3][6] = 1;
		tabuleiro[4][0] = 1;
		tabuleiro[4][1] = 1;
		tabuleiro[4][2] = 1;
		tabuleiro[4][3] = 1;
		tabuleiro[4][4] = 1;
		tabuleiro[4][5] = 1;
		tabuleiro[4][6] = 1;
		tabuleiro[5][0] = 0; // canto sem peça do tabuleiro
		tabuleiro[5][1] = 0; // canto sem peça do tabuleiro
		tabuleiro[5][2] = 1; 
		tabuleiro[5][3] = 1;
		tabuleiro[5][4] = 1;
		tabuleiro[5][5] = 0; // canto sem peça do tabuleiro
		tabuleiro[5][6] = 0; // canto sem peça do tabuleiro
		tabuleiro[6][0] = 0; // canto sem peça do tabuleiro
		tabuleiro[6][1] = 0; // canto sem peça do tabuleiro
		tabuleiro[6][2] = 1;
		tabuleiro[6][3] = 1;
		tabuleiro[6][4] = 1;
		tabuleiro[6][5] = 0; // canto sem peça do tabuleiro
		tabuleiro[6][6] = 0; // canto sem peça do tabuleiro
		
		// imprimi o tabuleiro
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				
				System.out.print(tabuleiro[i][j] + " ");
			}
			System.out.println();
		}
		do {
			System.out.println("\nJogador: " + jogador + ". Insira as duas posições iniciais (LINHA X COLUNA): ");
			Linha1 = scan.nextInt(); // LER POSIÇÃO LINHA (x) INICIAL
			Coluna1 = scan.nextInt(); //  LER POSIÇÃO COLUNA (y)INICIAL
			System.out.println("Ok, " + jogador + " Agora insira as duas posições finais (LINHA X COLUNA): ");
			Linha2 = scan.nextInt(); // LER POSIÇÃO LINHA (x) FINAL
			Coluna2 = scan.nextInt(); // LER POSIÇÃO COLUNA (y) FINAL
			boolean jogadaValida = jogar(Linha1, Linha2, Coluna1, Coluna2, tabuleiro, jogador, pecas);
			if (jogadaValida) // se jogada válida...
			{
				pecas--; // diminui uma peça
				System.out.println("Existe ainda " + pecas + " Peças"); // imprimi informando quantas peças exixtem
				if (pecas == 1) // se peças == 1....
					System.out.println("Jogador  " + jogador + "  venceu!"); // mostra vencedor
				
			} else {
				System.out.println("\nJogada Inválida!!\n");
				imprimeTabuleiro(tabuleiro);
			}
		} while (pecas > 1);
	}

	static boolean jogar(int Linha1, int Linha2, int Coluna1, int Coluna2, int[][] tabuleiro, int j, int pecas) {
		// teste se posy1 != posy2 na vertical
		if (Coluna1 < Coluna2 && Linha1 != Linha2 || Coluna1 > Coluna2 && Linha1 > Linha2 || Coluna1 < Coluna2 && Linha1 < Linha2
				|| Coluna1 > Coluna2 && Linha1 < Linha2) {
			pr("if1");
			return false;
		}
		/*/ verifica -- Na horizontal
			   if (Linha1 == 0 && Coluna1 == 0 && Linha2 == 0 && Coluna2 == 1 // nao existe 1,0 e 1,1 canto sem peças
				|| Linha1 == 0 && Coluna1 == 1 && Linha2 == 0 && Coluna2 == 2 // nao existe 1,1 e 1,2
				|| Linha1 == 0 && Coluna1 == 2 && Linha2 == 0 && Coluna2 == 3 // nao existe 1,2 e 1,3
				|| Linha1 == 0 && Coluna1 == 3 && Linha2 == 0 && Coluna2 == 2 // nao existe 1,3 e 1,2
				|| Linha1 == 0 && Coluna1 == 4 && Linha2 == 0 && Coluna2 == 1 // nao existe 1,2 e 1,1
				|| Linha1 == 0 && Coluna1 == 5 && Linha2 == 0 && Coluna2 == 0 // nao existe 1,1 e 1,0
				|| Linha1 == 0 && Coluna1 == 6 && Linha2 == 0 && Coluna2 == 1 // 1,1 e 1,1
				|| Linha1 == 1 && Coluna1 == 0 && Linha2 == 1 && Coluna2 == 2 // 0,0 e 0,1 canto sem peças
				|| Linha1 == 1 && Coluna1 == 1 && Linha2 == 1 && Coluna2 == 3 // 0,1 e 0,2
				|| Linha1 == 1 && Coluna1 == 2 && Linha2 == 1 && Coluna2 == 2 // 0,2 e 0,3
				|| Linha1 == 1 && Coluna1 == 3 && Linha2 == 1 && Coluna2 == 1 // 0,3 e 0,2
				|| Linha1 == 1 && Coluna1 == 4 && Linha2 == 1 && Coluna2 == 0 // 0,2 e 0,1
				|| Linha1 == 1 && Coluna1 == 5 && Linha2 == 1 && Coluna2 == 1 // 0,1 e 0,0
				|| Linha1 == 1 && Coluna1 == 6 && Linha2 == 1 && Coluna2 == 2 // 2,2 e 2,2
				|| Linha1 == 2 && Coluna1 == 0 && Linha2 == 2 && Coluna2 == 3 // 2,3 e 2,3
				|| Linha1 == 2 && Coluna1 == 1 && Linha2 == 2 && Coluna2 == 2 // 2,2 e 2,2
				|| Linha1 == 2 && Coluna1 == 2 && Linha2 == 2 && Coluna2 == 1 // 2,1 e 2,1
				|| Linha1 == 2 && Coluna1 == 3 && Linha2 == 2 && Coluna2 == 0 // 2,0 e 2,0
				|| Linha1 == 2 && Coluna1 == 4 && Linha2 == 2 && Coluna2 == 1 // 2,1 e 2,1
				|| Linha1 == 2 && Coluna1 == 5 && Linha2 == 2 && Coluna2 == 2 // 3,2 e 3,2
				|| Linha1 == 2 && Coluna1 == 6 && Linha2 == 2 && Coluna2 == 3 // 3,3 e 3,3
				|| Linha1 == 3 && Coluna1 == 0 && Linha2 == 3 && Coluna2 == 2 // 3,2 e 3,2
				|| Linha1 == 3 && Coluna1 == 1 && Linha2 == 3 && Coluna2 == 1 // 3,1 e 3,1
				|| Linha1 == 3 && Coluna1 == 2 && Linha2 == 3 && Coluna2 == 0 // 3,0 e 3,0
				|| Linha1 == 3 && Coluna1 == 3 && Linha2 == 3 && Coluna2 == 1 // 3,1 e 3,1
				|| Linha1 == 3 && Coluna1 == 4 && Linha2 == 3 && Coluna2 == 2 // 4,2 e 4,2
				|| Linha1 == 3 && Coluna1 == 5 && Linha2 == 3 && Coluna2 == 3 // 4,3 e 4,3
				|| Linha1 == 3 && Coluna1 == 6 && Linha2 == 3 && Coluna2 == 2 // 4,2 e 4,2
				|| Linha1 == 4 && Coluna1 == 0 && Linha2 == 4 && Coluna2 == 1 // 4,1 e 4,1
				|| Linha1 == 4 && Coluna1 == 1 && Linha2 == 4 && Coluna2 == 0 // 4,0 e 4,0
				|| Linha1 == 4 && Coluna1 == 2 && Linha2 == 4 && Coluna2 == 1 // 4,1 e 4,1
				|| Linha1 == 4 && Coluna1 == 3 && Linha2 == 4 && Coluna2 == 2 // 5,2 e 5,2
				|| Linha1 == 4 && Coluna1 == 4 && Linha2 == 4 && Coluna2 == 3 // 5,3 e 5,3
				|| Linha1 == 4 && Coluna1 == 5 && Linha2 == 4 && Coluna2 == 2 // 5,2 e 5,2
				|| Linha1 == 4 && Coluna1 == 6 && Linha2 == 4 && Coluna2 == 1 // 5,1 e 5,1
				|| Linha1 == 5 && Coluna1 == 0 && Linha2 == 5 && Coluna2 == 0 // 5,0 e 5,0
				|| Linha1 == 5 && Coluna1 == 1 && Linha2 == 5 && Coluna2 == 1 // 5,1 e 5,1
				|| Linha1 == 5 && Coluna1 == 2 && Linha2 == 5 && Coluna2 == 2 // 6,2 e 6,2
				|| Linha1 == 5 && Coluna1 == 3 && Linha2 == 5 && Coluna2 == 3 // 6,3 e 6,3
				|| Linha1 == 5 && Coluna1 == 4 && Linha2 == 5 && Coluna2 == 2 // 6,2 e 6,2
				|| Linha1 == 5 && Coluna1 == 5 && Linha2 == 5 && Coluna2 == 1 // 6,1 e 6,1
				|| Linha1 == 5 && Coluna1 == 6 && Linha2 == 5 && Coluna2 == 0 // 6,0 e 6,0
				|| Linha1 == 6 && Coluna1 == 0 && Linha2 == 6 && Coluna2 == 1 // 6,1 e 6,1
				|| Linha1 == 6 && Coluna1 == 1 && Linha2 == 6 && Coluna2 == 1 // 6,1 e 6,1
				|| Linha1 == 6 && Coluna1 == 2 && Linha2 == 6 && Coluna2 == 1 // 6,1 e 6,1
				|| Linha1 == 6 && Coluna1 == 3 && Linha2 == 6 && Coluna2 == 1 // 6,1 e 6,1
				|| Linha1 == 6 && Coluna1 == 4 && Linha2 == 6 && Coluna2 == 1 // 6,1 e 6,1
				|| Linha1 == 6 && Coluna1 == 5 && Linha2 == 6 && Coluna2 == 1 // 6,1 e 6,1
				|| Linha1 == 6 && Coluna1 == 6 && Linha2 == 6 && Coluna2 == 1) // 6,1 e 6,1
			{ 
			pr("if2");
			return false;
		}
		 */
		
		if (Linha1 > 6 || Linha1 < 0 || Coluna1 > 6 || Coluna1 < 0 || Linha2 > 6 || Linha2 < 0 || Coluna2 > 6 || Coluna1 < 0
				|| tabuleiro[Linha1][Coluna1] != 1 || tabuleiro[Linha2][Coluna2] != 0) {
			
			pr("if4");
			return false;
		}
		if (Linha1 == 0 && Coluna1 == 0 && Linha2 == 0 && Coluna2 == 6 || Linha1 == 0 && Coluna1 == 6 && Linha2 == 0 && Coluna2 == 0) {
			
			pr("if5");		
			return false;
		}
		if (Linha1 == 1 && Coluna1 == 0 && Linha2 == 1 && Coluna2 == 6 || Linha1 == 1 && Coluna1 == 6 && Linha2 == 1 && Coluna2 == 0) {
			
			pr("if6");
			return false;
		}
		if (Linha1 == 2 && Coluna1 == 0 && Linha2 == 2 && Coluna2 == 6 || Linha1 == 2 && Coluna1 == 6 && Linha2 == 2 && Coluna2 == 0) {
			
			pr("if7");
			return false;
		}
		if (Linha1 == 6 && Coluna1 == 0 && Linha2 == 6 && Coluna2 == 6 || Linha1 == 6 && Coluna1 == 6 && Linha2 == 6 && Coluna2 == 0) {
			
			pr("if8");
			return false;
		}
		if (Linha1 == 6 && Coluna1 == 0 && Linha2 == 0 && Coluna2 == 0 || Linha1 == 0 && Coluna1 == 0 && Linha2 == 6 && Coluna2 == 0) {
			
			pr("if9");
			return false;
		}
		if (Linha1 == 6 && Coluna1 == 1 && Linha2 == 0 && Coluna2 == 1 || Linha1 == 0 && Coluna1 == 1 && Linha2 == 6 && Coluna2 == 1) {
			
			pr("if10");
			return false;
		}
		if (Linha1 == 6 && Coluna1 == 2 && Linha2 == 0 && Coluna2 == 2 || Linha1 == 0 && Coluna1 == 2 && Linha2 == 6 && Coluna2 == 2) {
			pr("if11");
		
			return false;
		}
		if (Linha1 == 3 && Coluna1 == 6 && Linha2 == 0 && Coluna2 == 6 || Linha1 == 0 && Coluna1 == 6 && Linha2 == 6 && Coluna2 == 3) {
			
			pr("if12");
			return false;
		}
		if (Linha1 == 0 && Coluna1 == 1 && Linha2 == 2 && Coluna2 == 1)//
		{
			if (tabuleiro[1][1] == 0) {
				pr("if13");
			
				return false;
			} else
				tabuleiro[0][1] = 0;
			tabuleiro[2][1] = 1;
			tabuleiro[1][1] = 0;
			System.out.println();
			imprimeTabuleiro(tabuleiro);
		} else if (Linha1 == 0 && Coluna1 == 3 && Linha2 == 0 && Coluna2 == 1)//0,3 e 0,1 JOGADA INVÁLIDA
		{
			if (tabuleiro[0][3] == 0) {
				return false;
			} else
				tabuleiro[0][1] = 1;
			tabuleiro[0][3] = 0;
			tabuleiro[0][2] = 0;
			System.out.println();
			imprimeTabuleiro(tabuleiro);
		} else if (Linha1 == 1 && Coluna1 == 1 && Linha2 == 3 && Coluna2 == 1)// 1,1 e 3,1 JOGADA INVÁLIDA
		{
			if (tabuleiro[2][1] == 0) {
				return false;
			} else
				tabuleiro[1][1] = 0;
			tabuleiro[2][1] = 0;
			tabuleiro[3][1] = 1;
			System.out.println();
			imprimeTabuleiro(tabuleiro);
		} else if (Linha1 == 1 && Coluna1 == 3 && Linha2 == 1 && Coluna2 == 1)// 1,3 e 1,1 JOGADA INVÁLIDA
		{
			if (tabuleiro[1][2] == 0) {
				return false;
			} else
				tabuleiro[1][3] = 0;
			tabuleiro[1][2] = 0;
			tabuleiro[1][1] = 1;
			System.out.println();
			imprimeTabuleiro(tabuleiro);
		} else if (Linha1 == 0 && Coluna1 == 0 && Linha2 == 0 && Coluna2 == 2)// 0,0 e 0,2 JOGADA INVÁLIDA 
		{
			if (tabuleiro[0][1] == 0) {
				return false;
			} else
				tabuleiro[0][0] = 0;
			tabuleiro[0][1] = 0;
			tabuleiro[0][2] = 1;
			System.out.println();
			imprimeTabuleiro(tabuleiro);
		} else if (Linha1 == 3 && Coluna1 == 1 && Linha2 == 1 && Coluna2 == 1)//3,1 e 1,1 JOGADA INVÁLIDA
		{
			if (tabuleiro[2][1] == 0) {
				return false;
			} else
				tabuleiro[3][1] = 0;
			tabuleiro[2][1] = 0;
			tabuleiro[1][1] = 1;
			System.out.println();
			imprimeTabuleiro(tabuleiro);
		} else if (Linha1 == 3 && Coluna1 == 3 && Linha2 == 3 && Coluna2 == 1)// 3,3 e 3,1
		{
			if (tabuleiro[3][2] == 0) {
				return false;
			} else
				tabuleiro[3][3] = 0;
			tabuleiro[3][2] = 0;
			tabuleiro[3][1] = 1;
			System.out.println();
			imprimeTabuleiro(tabuleiro);
		} else if (Linha1 == 0 && Coluna1 == 3 && Linha2 == 2 && Coluna2 == 3)// 0,3 e 2,3 É UMA JOGADA VÁLIDA SE 0,3 E 1,3 TIVEREM PEÇAS E 2,3 ESTIVER VAZIA
		{
			if (tabuleiro[1][3] == 0) {
				return false;
			} else
				tabuleiro[0][3] = 0;
			tabuleiro[2][3] = 1;
			tabuleiro[1][3] = 0;
			System.out.println();
			imprimeTabuleiro(tabuleiro);
		} else if (Linha1 == 2 && Coluna1 == 3 && Linha2 == 0 && Coluna2 == 3)// 2,3 e 0,3 É UMA JOGADA VÁLIDA SE 2,3 E 1,3 TIVEREM PEÇAS E 0,3 ESTIVER VAZIA
		{
			if (tabuleiro[1][3] == 0) {
				return false;
			} else
				tabuleiro[2][3] = 0;
			tabuleiro[0][3] = 1;
			tabuleiro[1][3] = 0;
			System.out.println();
			imprimeTabuleiro(tabuleiro);
		} else if (Linha1 == 2 && Coluna1 == 3 && Linha2 == 2 && Coluna2 == 1)// 2,3 e 2,1 É UMA JOGADA VÁLIDA SE 2,3 E 2,2 TIVEREM PEÇAS E 2,1 ESTIVER VAZIA
		{
			if (tabuleiro[2][2] == 0) {
				return false;
			} else
				tabuleiro[2][3] = 0;
			tabuleiro[2][2] = 0;
			tabuleiro[2][1] = 1;
			System.out.println();
			imprimeTabuleiro(tabuleiro);
		} else if (Linha1 == 0 && Coluna1 == 3 && Linha2 == 2 && Coluna2 == 3)// 0,3 e 2,3 É UMA JOGADA VÁLIDA SE 0,3 E 1,3 TIVEREM PEÇAS E 2,3 ESTIVER VAZIA
			
		{
			if (tabuleiro[1][3] == 0) {
				return false;
			} else
				tabuleiro[0][3] = 0;
			tabuleiro[1][3] = 0;
			tabuleiro[2][3] = 1;
			System.out.println();
			imprimeTabuleiro(tabuleiro);
		} else if (Linha1 == 0 && Coluna1 == 2 && Linha2 == 2 && Coluna2 == 2)// 0,2 e 2,2 É UMA JOGADA VÁLIDA SE 0,2 E 1,2 TIVEREM PEÇAS E 2,2 ESTIVER VAZIA
		{
			if (tabuleiro[1][2] == 0) {
				return false;
			} else
				tabuleiro[0][2] = 0;
			tabuleiro[1][2] = 0;
			tabuleiro[2][2] = 1;
			System.out.println();
			imprimeTabuleiro(tabuleiro);
		} else if (Linha1 == 2 && Coluna1 == 1 && Linha2 == 0 && Coluna2 == 1)// 2,1 e 0,1 JOGADA INVÁLIDA
		{
			if (tabuleiro[1][1] == 0) {
				return false;
			} else
				tabuleiro[2][1] = 0;
			tabuleiro[1][1] = 0;
			tabuleiro[0][1] = 1;
			System.out.println();
			imprimeTabuleiro(tabuleiro);
		} else if (Linha1 == 1 && Coluna1 == 0 && Linha2 == 1 && Coluna2 == 2)//
		{
			if (tabuleiro[1][1] == 0) {
				return false;
			} else
				tabuleiro[1][0] = 0;
			tabuleiro[1][1] = 0;
			tabuleiro[1][2] = 1;
			System.out.println();
			imprimeTabuleiro(tabuleiro);
		} else if (Linha1 == 3 && Coluna1 == 3 && Linha2 == 1 && Coluna2 == 3)//
		{
			if (tabuleiro[2][3] == 0) {
				return false;
			} else
				tabuleiro[3][3] = 0;
			tabuleiro[2][3] = 0;
			tabuleiro[1][3] = 1;
			System.out.println();
			imprimeTabuleiro(tabuleiro);
		} else if (Linha1 == 0 && Coluna1 == 1 && Linha2 == 0 && Coluna2 == 3)//
		{
			if (tabuleiro[0][2] == 0) {
				return false;
			} else
				tabuleiro[0][1] = 0;
			tabuleiro[0][2] = 0;
			tabuleiro[0][3] = 1;
			System.out.println();
			imprimeTabuleiro(tabuleiro);
		} else if (Linha1 == 2 && Coluna1 == 2 && Linha2 == 0 && Coluna2 == 2)//
		{
			if (tabuleiro[1][2] == 0) {
				return false;
			} else
				tabuleiro[2][2] = 0;
			tabuleiro[1][2] = 0;
			tabuleiro[0][2] = 1;
			System.out.println();
			imprimeTabuleiro(tabuleiro);
		} else if (Linha1 == 3 && Coluna1 == 0 && Linha2 == 3 && Coluna2 == 2)//
		{
			if (tabuleiro[3][1] == 0) {
				return false;
			} else
				tabuleiro[3][0] = 0;
			tabuleiro[3][1] = 0;
			tabuleiro[3][2] = 1;
			System.out.println();
			imprimeTabuleiro(tabuleiro);
		} else if (Linha1 == 2 && Coluna1 == 0 && Linha2 == 2 && Coluna2 == 2)//
		{
			if (tabuleiro[2][1] == 0) {
				return false;
			} else
				tabuleiro[2][0] = 0;
			tabuleiro[2][1] = 0;
			tabuleiro[2][2] = 1;
			System.out.println();
			imprimeTabuleiro(tabuleiro);
		} else if (Linha1 == 1 && Coluna1 == 0 && Linha2 == 3 && Coluna2 == 0)//
		{
			if (tabuleiro[2][0] == 0) {
				return false;
			} else
				tabuleiro[1][0] = 0;
			tabuleiro[2][0] = 0;
			tabuleiro[3][0] = 1;
			System.out.println();
			imprimeTabuleiro(tabuleiro);
		} else if (Linha1 == 1 && Coluna1 == 3 && Linha2 == 3 && Coluna2 == 3)//
		{
			if (tabuleiro[2][3] == 0) {
				return false;
			} else
				tabuleiro[1][3] = 0;
			tabuleiro[2][3] = 0;
			tabuleiro[3][3] = 1;
			System.out.println();
			imprimeTabuleiro(tabuleiro);
		} else if (Linha1 == 1 && Coluna1 == 2 && Linha2 == 1 && Coluna2 == 0)//
		{
			if (tabuleiro[1][1] == 0) {
				return false;
			} else
				tabuleiro[1][2] = 0;
			tabuleiro[1][1] = 0;
			tabuleiro[1][0] = 1;
			System.out.println();
			imprimeTabuleiro(tabuleiro);
		} else if (Linha1 == 2 && Coluna1 == 1 && Linha2 == 2 && Coluna2 == 3)//
		{
			if (tabuleiro[2][2] == 0) {
				return false;
			} else
				tabuleiro[2][1] = 0;
			tabuleiro[2][2] = 0;
			tabuleiro[2][3] = 1;
			System.out.println();
			imprimeTabuleiro(tabuleiro);
		} else if (Linha1 == 1 && Coluna1 == 2 && Linha2 == 3 && Coluna2 == 2)//
		{
			if (tabuleiro[2][2] == 0) {
				return false;
			} else
				tabuleiro[1][2] = 0;
			tabuleiro[2][2] = 0;
			tabuleiro[3][2] = 1;
			System.out.println();
			imprimeTabuleiro(tabuleiro);
		} else if (Linha1 == 1 && Coluna1 == 1 && Linha2 == 1 && Coluna2 == 3)//
		{
			if (tabuleiro[1][2] == 0) {
				return false;
			} else
				tabuleiro[1][1] = 0;
			tabuleiro[1][2] = 0;
			tabuleiro[1][3] = 1;
			System.out.println();
			imprimeTabuleiro(tabuleiro);
		} else if (Linha1 == 2 && Coluna1 == 0 && Linha2 == 0 && Coluna2 == 0)//
		{
			if (tabuleiro[1][0] == 0) {
				return false;
			} else
				tabuleiro[2][0] = 0;
			tabuleiro[1][0] = 0;
			tabuleiro[0][0] = 1;
			System.out.println();
			imprimeTabuleiro(tabuleiro);
		} else if (Linha1 == 3 && Coluna1 == 1 && Linha2 == 3 && Coluna2 == 3)//
		{
			if (tabuleiro[3][2] == 0) {
				return false;
			} else
				tabuleiro[3][1] = 0;
			tabuleiro[3][2] = 0;
			tabuleiro[3][3] = 1;
			System.out.println();
			imprimeTabuleiro(tabuleiro);
		} else if (Linha1 == 3 && Coluna1 == 2 && Linha2 == 1 && Coluna2 == 2)//
		{
			if (tabuleiro[2][2] == 0) {
				return false;
			} else
				tabuleiro[3][2] = 0;
			tabuleiro[2][2] = 0;
			tabuleiro[1][2] = 1;
			System.out.println();
			imprimeTabuleiro(tabuleiro);
		} else if (Linha1 == 2 && Coluna1 == 2 && Linha2 == 2 && Coluna2 == 0)//
		{
			if (tabuleiro[2][1] == 0) {
				return false;
			} else
				tabuleiro[2][2] = 0;
			tabuleiro[2][1] = 0;
			tabuleiro[2][0] = 1;
			System.out.println();
			imprimeTabuleiro(tabuleiro);
		} else if (Linha1 == 0 && Coluna1 == 0 && Linha2 == 2 && Coluna2 == 0)//
		{
			if (tabuleiro[1][0] == 0) {
				return false;
			} else
				tabuleiro[0][0] = 0;
			tabuleiro[1][0] = 0;
			tabuleiro[2][0] = 1;
			System.out.println();
			imprimeTabuleiro(tabuleiro);
		} else if (Linha1 == 3 && Coluna1 == 2 && Linha2 == 3 && Coluna2 == 0) {
			if (tabuleiro[3][1] == 0) {
				return false;
			} else
				tabuleiro[3][2] = 0;
			tabuleiro[3][1] = 0;
			tabuleiro[3][0] = 1;
			System.out.println();
			imprimeTabuleiro(tabuleiro);
		} else if (Linha1 == 3 && Coluna1 == 0 && Linha2 == 1 && Coluna2 == 0)//
		{
			if (tabuleiro[2][0] == 0) {
				return false;
			} else
				tabuleiro[3][0] = 0;
			tabuleiro[2][0] = 0;
			tabuleiro[1][0] = 1;
			System.out.println();
			imprimeTabuleiro(tabuleiro);
		}
		return true;
	}

	// PARTE DE IMPRIMIR do MÉTODO print
	static void imprimeTabuleiro(int[][] m) {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}
}