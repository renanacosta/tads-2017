import javax.swing.JOptionPane;




public class matriz {
	//1-) Quantos numeros maiores que 5 existem na matriz
	//2-) Quantos numeros impares existem na matriz
	//3-) Divida todos os valores pares por 2 na matriz
	public static void imprimaMatriz(int [][] m){
		String aux = "";
		for (int i =0; i<m.length; i++){
			for (int j = 0; j<m[0].length; j++){
				aux = aux + "  " + m[i][j] + "  ";
			}
			aux = aux + "\n";
		}
		JOptionPane.showMessageDialog(null,aux);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int linhas = Integer.parseInt(JOptionPane.showInputDialog(" Entre com a quantidade de linhas "));
		int colunas = Integer.parseInt(JOptionPane.showInputDialog(" Entre com a quantidade de colunas "));
		
		int [][] matriz = new int [linhas][colunas];
		int cont5 = 0;
		int cont_impares = 0;
		for (int i =0; i<linhas; i++){
			for (int j = 0; j<colunas; j++){
				matriz[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Entre com o valor ["+i+"]["+j+"]"));
				if (matriz[i][j] > 5) cont5++;
				if ((matriz[i][j] % 2) != 0) cont_impares++; 
			}
		}
		
		
		imprimaMatriz(matriz);
		
		JOptionPane.showMessageDialog(null,"Numeros impares:" + cont_impares+ "\nNumeros maiores que 5: "+cont5);
		
		for (int i =0; i<linhas; i++){
			for (int j = 0; j<colunas; j++){
				if (matriz[i][j] % 2 == 0)	matriz[i][j] = matriz[i][j] / 2; 
				
			}
		}
		
		imprimaMatriz(matriz);

		
		

	}

}
