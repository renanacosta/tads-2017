import javax.swing.JOptionPane;

public class restaUm {

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
					peca = ".";
					break;
				case 2:
					peca = "*";
					break;
				}
				tabuleiro_grafico += "   " + peca;
			}
		}

		JOptionPane.showMessageDialog(null, tabuleiro_grafico);
		System.out.println(tabuleiro_grafico);

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

		}
}


/*
 * 
 * posicao inicial 5,3 
 * posicao final 3,3
 * 
 * 
if tab[pix,piy] = "*" {
		if tab[pfx,pfy] = "."
				if Math.abs(pix-pfx) == 2 && piy-pfy == 0
				if pix > pfx step = pix-1;
				else step = pix+1;
		if tab[step,pfy] = "*"
				tab[pix][piy]="."
				tab[step,pfy] = "."
				tab[pfx,pfy] = "*";     
		
		if tab[pix,piy] = "*" {
				if tab[pfx,pfy] = "."
						if Math.abs(piy-pfy) == 2 && pix-pfx == 0
						
 * 
 * 
 * 
 */

