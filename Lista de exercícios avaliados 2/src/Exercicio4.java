import javax.swing.JOptionPane;

public class Exercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//4 – O usuário deverá entrar com o tamanho do vetor e com os seus valores.
		//Calcule quantos números existem maiores que 10.
		
		int n =Integer.parseInt(JOptionPane.showInputDialog("Tamanho do vetor"));
		int vetor[] = new int [n];
		
		int cont = 0;
				
		for (int i=0;i<vetor.length;i++){
			vetor[i]=Integer.parseInt(JOptionPane.showInputDialog("Dados da posição do vetor:"+i));
			
					
					
			if ((vetor[i]>10)) {
				cont++;
			}
		}
		JOptionPane.showMessageDialog(null, " Existe(m) "+cont+" número(s) maior(es) que 10 (DEZ) ");
		System.out.println(" Existe(m) "+cont+" número(s) maior(es) que 10 (DEZ) ");

	}

}
