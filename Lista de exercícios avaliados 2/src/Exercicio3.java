import javax.swing.JOptionPane;

public class Exercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//3 – O usuário deverá entrar com o tamanho do vetor e com os seus valores.
		//Contar quantos valores negativos existem no vetor. Valores inteiros.
		
		int n =Integer.parseInt(JOptionPane.showInputDialog("Tamanho do vetor"));
		int vetor[] = new int [n];
		
		int cont = 0;
				
		for (int i=0;i<vetor.length;i++){
			vetor[i]=Integer.parseInt(JOptionPane.showInputDialog("Dados da posição do vetor:"+i));
			
					
					
			if ((vetor[i]<0)) {
				cont++;
			}
		}
		JOptionPane.showMessageDialog(null, " Existe(m) "+cont+" número(s) menor(s) que 0 (ZERO) ");
		System.out.println(" Existe(m) "+cont+" número(s) menor(s) que 0 (ZERO) ");

	}

}
