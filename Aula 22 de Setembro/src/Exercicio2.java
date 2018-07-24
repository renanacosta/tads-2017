import javax.swing.JOptionPane;

public class Exercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// RETORNAR COMO VERDADEIRO SE EXISTIR UM PADRÃO ENTRE OS VETORES, E FALSO CASO CONTRARIO.
		
		int n = Integer.parseInt(JOptionPane.showInputDialog("Tamanho do vetor com o padrão:"));
		int padrao[] = new int [n];
		for (int i=0;i<padrao.length;i++){
			padrao[i]=Integer.parseInt(JOptionPane.showInputDialog("Dados (vetor1):"));
			System.out.println("padrao["+i+"]:"+padrao[i]);
		}
		
		n=Integer.parseInt(JOptionPane.showInputDialog("Tamanho do vetor com os dados:"));
		int data[] = new int [n];
		for (int i=0;i<data.length;i++){
			data[i]=Integer.parseInt(JOptionPane.showInputDialog("Dados (vetor2):"));
			System.out.println("data["+i+"]:"+data[i]);
		}
		
		boolean matchPadrao = false;
		int cont=0;
		for (int i =0; i<data.length; i++){
			if (data[i]==padrao[cont]){
				cont ++;		

				if (cont == padrao.length) {
					matchPadrao = true;
					break;
				}
			}else{
				cont=1;
			}
			
		}

		
		if (matchPadrao) 
			System.out.println("Padrão encontrado!!");
		else
			System.out.println("Padrão não encontrado...");

		// OU
		
		System.out.println("-------------------------------");
		System.out.println("Outra maneira de apresentar um IF");
		System.out.println("Padrão" +  ( matchPadrao?" ":" NÃO " )  + "encontrado!");				
		

	}

}