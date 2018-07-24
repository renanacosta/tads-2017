import javax.swing.JOptionPane;

public class Exercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1 – O usuário deverá entrar com o tamanho do vetor e com os seus valores.
		//Pesquisar quantos valores são maiores que a média, que estão contidos no
		//vetor. Valores em double. 

		int n =Integer.parseInt(JOptionPane.showInputDialog("Tamanho do vetor"));
		double vetor[] = new double [n];

		int cont = 0;
		double media=0,soma=0;

		for (int i=0;i<vetor.length;i++){
			vetor[i]=Double.parseDouble(JOptionPane.showInputDialog("Dados da posição do vetor:"));

			soma=soma+vetor[i];
			System.out.println("O número digitado foi: " +vetor[i]);
			
		}

		media =soma/n;
		System.out.println("A média dos números informados é: "+media);

		for (int temp=0;temp<vetor.length;temp++){

			if (vetor[temp]>media) {
				cont++;

			}
		}


		if(cont==0) {
			System.out.println(" Não existe numeros maiores que a média ");
			JOptionPane.showMessageDialog(null, " Não existe numeros maiores que a média ");
		}else 
			System.out.println(" Existe(m) número(s) maior(es) que a média ");
			JOptionPane.showMessageDialog(null, " Existe(m) "+cont+" número(s) maior(es) que a média ");
		
	}

}

