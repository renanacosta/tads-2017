import javax.swing.JOptionPane;
public class teste {
	public static void imprimaMatriz(int [][] m){
		String aux = "";
		for (int i =0; i<m.length; i++){
			for (int j = 0; j<m[0].length; j++){
				aux = aux + "  " + m[i][j] + "  ";
			}
			aux = aux + "\n";
		}
		JOptionPane.showMessageDialog(null, aux);
		System.out.println(aux);
	}
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Para os enunciados que precisem de diagonais, favor listar as linhas e colunas iguais");
		System.out.println("Para os enunciados que precisem de diagonais, favor listar as linhas e colunas iguais");
		int linhas = Integer.parseInt(JOptionPane.showInputDialog(" Entre com a quantidade de linhas "));
		System.out.println(" Entre com a quantidade de linhas ");
		int colunas = Integer.parseInt(JOptionPane.showInputDialog(" Entre com a quantidade de colunas "));
		System.out.println(" Entre com a quantidade de colunas ");
		int temp=Integer.parseInt(JOptionPane.showInputDialog("Informe o valor (I) que define se é divisor: "));
		System.out.println("Informe o valor (I) que define se é divisor: ");
		int [][] matriz = new int [linhas][colunas];
		int tam = linhas;
		int [] diagonal1 = new int [tam];
		int [] diagonal2 = new int [tam]; 
		int cont5 = 0, cont_impares = 0, total = 0, cont2 = 0, totalDiagonal = 0, variavel = 0, variavel2 = 0;
		String variavelDiagonal1 = "", variavelDiagonal2 = "";
		for (int i =0; i<linhas; i++){
			for (int j = 0; j<colunas; j++){
				matriz[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Entre com o valor ["+i+"]["+j+"]"));
				System.out.println("Entre com o valor ["+i+"]["+j+"]");
				total=total+matriz[i][j];
				if (matriz[i][j] > 5){
					cont5++;
				}
				if ((matriz[i][j] % 2) != 0){
					cont_impares++; 
				}
				if(matriz[i][j] % temp ==0){
					cont2++;
				}
			}
		}
		for (int i =0; i<tam; i++){
			for (int j = 0; j<tam; j++){
				if (i==j){
					diagonal1[variavel] = matriz[i][j];
					variavel++;
					totalDiagonal = totalDiagonal + matriz[i][j];
				}
			}
		}
		for (int j=0; j<tam; j++){
			for (int i=0; i<tam; i++){
				if ((tam-j-1) == i){
					diagonal2[variavel2] = matriz[i][j];
					variavel2++;
					totalDiagonal = totalDiagonal + matriz[i][j];
				}
			}
		}
		for (int i=0; i<diagonal1.length;i++){
			variavelDiagonal1 = variavelDiagonal1 + "["+diagonal1[i]+"]";
		}
		for (int i=0; i<diagonal2.length;i++){
			variavelDiagonal2 = variavelDiagonal2 + "["+diagonal2[i]+"]";
		}
		imprimaMatriz(matriz);
		if(linhas==colunas){
			JOptionPane.showMessageDialog(null, "Diagonal 1:" +variavelDiagonal1);
			System.out.println("Diagonal 1:" +variavelDiagonal1);
			JOptionPane.showMessageDialog(null, "Diagonal 2:" +variavelDiagonal2);
			System.out.println("Diagonal 2:" +variavelDiagonal2);
			JOptionPane.showMessageDialog(null, "O somatorio total das diagonias é: " +totalDiagonal);
			System.out.println("O somatorio total das diagonias é: " +totalDiagonal);
		}
		JOptionPane.showMessageDialog(null, "Quantidade de numeros impares na matriz: " + cont_impares);
		System.out.println("Quantidade de numeros impares na matriz: " + cont_impares);
		JOptionPane.showMessageDialog(null, "Quantidade de numeros maiores do que cinco: " + cont5);
		System.out.println("Quantidade de numeros maiores do que cinco: " + cont5);
		JOptionPane.showMessageDialog(null, "O somatorio de todos os valores informados na matriz é: " + total);
		System.out.println("O somatorio de todos os valores informados na matriz é: " + total);
		JOptionPane.showMessageDialog(null, "A quantidade de numeros divisiveis por "+temp+" é: "+ cont2);
		System.out.println("A quantidade de numeros divisiveis por "+temp+" é: "+ cont2);
		for (int i =0; i<linhas; i++){
			for (int j = 0; j<colunas; j++){
				if (matriz[i][j] % 2 == 0) matriz[i][j] = matriz[i][j] / 2; 
			}
		}
		imprimaMatriz(matriz);
	}
}