import javax.swing.JOptionPane;

public class Exercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//2 – Contar quantos números divisíveis por 10 existem em um vetor. O usuário
		//deverá entrar com o tamanho do vetor e com os seus valores. Valores inteiros. 
		
		int n =Integer.parseInt(JOptionPane.showInputDialog("Tamanho do vetor"));
		int vetor[] = new int [n];
		
		int cont = 0;
				
		for (int i=0;i<vetor.length;i++){
			vetor[i]=Integer.parseInt(JOptionPane.showInputDialog("Dados da posição do vetor:"+i));
			
					
					
			if ((vetor[i]%10)==0) {
				cont++;
			}
		}
		JOptionPane.showMessageDialog(null, " Existe(m) "+cont+" número(s) divisível(eis) por 10 (DEZ) ");
		System.out.println(" Existe(m) "+cont+" número(s) divisível(eis) por 10 (DEZ) ");
	}

}
