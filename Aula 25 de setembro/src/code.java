import javax.swing.JOptionPane;

public class code {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int contPecas = Integer.parseInt(JOptionPane.showInputDialog("Entre com o numero de peças:"));
		
		int codigoPecas[] = new int [contPecas];
		String nomePecas[] = new String [contPecas];
		int quantPecas[] = new int [contPecas];
		double precoPecas [] = new double [contPecas];
		
		int opcao;
		
		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog("---MENU--- \n 1- CADASTRO DE PEÇAS \n 2- PESQUISA \n 0 - SAIR "));
			
		}
		while(opcao!=0);
		System.out.println("FIM!");
	}
		

}
