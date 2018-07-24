// 1 – FAZER UMA FUNÇÃO QUE CALCULE (RETORNE) QUANTOS DIVISORES DE 7, 
// EXISTEM EM UM UNIVERSO DE DADOS DE 'N_INICIO' A 'N_FIM' COM PARAMETROS DA FUNÇÃO. 

//================================================================================================

import javax.swing.JOptionPane;

public class exercicio1{

	public static int divisoresDe7(){
		
		int contador = 0;
		int nInicio = Integer.parseInt(JOptionPane.showInputDialog("INSIRA O VALOR INICIAL: "));
		System.out.println("VALOR INICIAL = "+nInicio);
		int nFim = Integer.parseInt(JOptionPane.showInputDialog("INSIRA O VALOR FINAL: "));
		System.out.println("VALOR FINAL = "+nFim);
		System.out.println();
		
		for(int i = nInicio; i <= nFim; i++){
			if(i%7 == 0){
				contador++;
			}
		}
		JOptionPane.showMessageDialog(null, "A QUANTIDADE DE NUMEROS DIVISIVEIS POR 7 ENTRE "+nInicio+ " E " +nFim+ " É: " + contador);
		System.out.println("A QUANTIDADE DE NÚMEROS DIVISÍVEIS POR 7 ENTRE "+nInicio+ " E " +nFim+ " É: " + contador);
		return contador;
	}

	public static void main(String[] args) {
		divisoresDe7();
		
		JOptionPane.showMessageDialog(null,"FIM DO PROGRAMA!");
		System.out.println();
		System.out.println("FIM DO PROGRAMA!");
	}
}