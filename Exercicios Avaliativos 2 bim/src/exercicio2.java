// 2 - UMA FUNÇÃO QUE CALCULE QUANTOS DADOS DE UM VETOR ESTÃO ACIMA DA MÉDIA
//================================================================================================

import javax.swing.JOptionPane;

public class exercicio2 {
	public static int acimaDaMedia(int [] vetor){

		int contador = 0;
		double media = 0, temp = 0;

		for (int i = 0; i < vetor.length; i++){

			temp = temp + vetor[i];
		}

		media = temp / vetor.length;

		for (int i = 0; i < vetor.length; i++){ 

			if (vetor[i] > media){ 

				contador++;	
			}
		}

		JOptionPane.showMessageDialog(null, "A MÉDIA DOS VALORES INFORMADOS É: " + media);
		System.out.println("A MÉDIA DOS VALORES INFORMADOS É: " + media);
		System.out.println();
		JOptionPane.showMessageDialog(null, "O NÚMERO DE DADOS ACIMA DA MÉDIA É: " +contador);
		System.out.println("O NÚMERO DE DADOS ACIMA DA MÉDIA É: " +contador);
		System.out.println();

		return contador;
	}

	public static void main(String[] args) {

		int n = Integer.parseInt(JOptionPane.showInputDialog("INFORME O TAMANHO DO VETOR "));

		int vetor[] = new int [n];

		for (int i = 0; i < vetor.length; i++){

			vetor[i] = Integer.parseInt(JOptionPane.showInputDialog("INSIRA OS DADOS DO VETOR "));

			System.out.println();
			JOptionPane.showMessageDialog(null, "DADO DO VETOR [" +i+ "]:"+vetor[i]);
			System.out.println("DADO DO VETOR [" +i+ "]:"+vetor[i]);
			

		} 

		acimaDaMedia(vetor); 
		
		JOptionPane.showMessageDialog(null, "FIM DO PROGRAMA!");
		System.out.println("FIM DO PROGRAMA!");
	}
}