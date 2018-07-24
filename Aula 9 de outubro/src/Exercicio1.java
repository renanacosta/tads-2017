import javax.swing.JOptionPane;

public class Exercicio1 {

	public static int[] codigoPecas,quantPecas;
	public static String[] nomePecas;
	public static double [] precoPecas;

	// -------------------------------------------------------------
	private static void apresentaUMApeca(int i) {
		// TODO Auto-generated method stub
		String aux = "";

		if (i!=-1){
			aux = "\n------------------------------\n" + "Peça index [" + i + "]\n" + "Codigo da peça:" + codigoPecas[i]+"\nPeça:" + nomePecas[i] + "\nQuantidade:" + quantPecas[i]  + "\nPreço:" +precoPecas[i] + "\nPreço total: " + (precoPecas[i] * quantPecas[i]);
		}
		else aux = "Não encontrado!";
		
		JOptionPane.showMessageDialog(null, aux);

	}


	// -------------------------------------------------------------
	private static void buscarMaiorPrecoTotal() {
		double maior =0;
		int p=-1;
		double precoTOTAL=0.0;
		for (int i =0; i<codigoPecas.length;i++){
			precoTOTAL = precoPecas[i] * quantPecas[i];

			if (maior < precoTOTAL){
				maior = precoTOTAL;
				p = i;
			}
		}		

		apresentaUMApeca(p);

	}

	// -----------------------------------------------------
	private static void buscarMaiorPrecoUnitario() {
		// TODO Auto-generated method stub
		double maior =0;
		int p=-1;
		for (int i =0; i<codigoPecas.length;i++){
			if (maior < precoPecas[i]){
				maior = precoPecas[i];
				p = i;
			}
		}
		apresentaUMApeca(p);

	}

	// -------------------------------------------------------------
	private static void buscarPecaPedacoNome() {
		String nome = JOptionPane.showInputDialog("Entre com o nome.");
		String aux;

		int p=-1;
		for (int i = 0; i < codigoPecas.length;i++){
			aux = nomePecas[i].toLowerCase();
			if (aux.startsWith(nome.toLowerCase()) == true){
				p=i;
				apresentaUMApeca(p);
			}
		}
	}

	// ------------------------------------------------------
	
	private static void buscarQuantidadeX() {
		// TODO Auto-generated method stub
		int quantX = Integer.parseInt(JOptionPane.showInputDialog(" Entre com a quantidade para busca:"));
		int p=-1;
		for (int i=0;i<codigoPecas.length;i++){
			if (quantPecas [i] == quantX){
				p=i;
				apresentaUMApeca(p);
			}
			
		}
		 if (p==-1) apresentaUMApeca(p);
	}

	
    // -----------------------------------------------------
	private static void buscarQuantidadesMenoresQue10() {
		// TODO Auto-generated method stub
		int p=-1;
		for (int i=0;i<codigoPecas.length;i++){
			if (quantPecas [i] < 10){
				p=i;
				apresentaUMApeca(p);
			}
			
		}
		 if (p==-1) apresentaUMApeca(p);
		
	}

	// -----------------------------------------------------


	public static void cadastro() {
		// TODO Auto-generated method stub
		for (int i=0;i<codigoPecas.length;i++){
			codigoPecas[i] = Integer.parseInt(JOptionPane.showInputDialog(i+" Entre com o codigo:"));
			nomePecas[i] = JOptionPane.showInputDialog(i+" Entre com o nome da peca:");
			quantPecas[i] = Integer.parseInt(JOptionPane.showInputDialog(i+ "Entre com a quantidade:"));
			precoPecas[i] = Double.parseDouble(JOptionPane.showInputDialog(i+ "Entre com o preço:"));
		}
	}

	// -------------------------------------------------------------

	public static void pesquisa(){
		int opcao;
		do{

			opcao = Integer.parseInt(JOptionPane.showInputDialog(" ---MENU-PESQUISA \n 1 - Nome da peça com maior preço unitário \n 2 - Nome da peça com maior preço TOTAL \n 3 - Listar  \n 4 - Buscar peca pelo código\n 5 - Buscar peca pelo pedaço do nome \n 6 - Apresentar todas as peças que tenham quantidade X \n 7 - Apresentar todas as peças com quantidade < 10 \n 8 - Apresentar todas as peças que tenham preço unitário > 500 \n 9 - Apresentar o valor total de preços TOTAIS no sistema \n 0 - Sair"));

			switch (opcao){
			case 1: buscarMaiorPrecoUnitario(); break;
			case 2: buscarMaiorPrecoTotal(); break;
			case 3: mostraDadosJanelas(); break;
			case 4: buscarPecaCodigo(); break;
			case 5: buscarPecaPedacoNome(); break;
			case 6: buscarQuantidadeX(); break;
			case 7: buscarQuantidadesMenoresQue10(); break;
			case 8: break;
			}	

		}while (opcao!=0);
	}



	// -------------------------------------------------------------

	private static void buscarPecaCodigo() {
		// TODO Auto-generated method stub
		int codigo = Integer.parseInt(JOptionPane.showInputDialog("Entre com o codigo da peça a ser buscada:"));
		int p =-1;
		for (int i =0; i<codigoPecas.length; i++){
			if (codigo == codigoPecas[i]){
				p=i;
				break;
			}
		}

		apresentaUMApeca(p);

	}


	// -------------------------------------------------------------

	public static void mostraDados() {
		// TODO Auto-generated method stub
		for (int i=0;i<codigoPecas.length;i++){
			System.out.println("------------------------------");
			System.out.println("Peça index [" + i + "]");
			System.out.println("Peça:" + nomePecas[i]);
			System.out.println("Quantidade:" + quantPecas[i]);
			System.out.println("Preço:" +precoPecas[i] );
			System.out.println("Preço total: " + (precoPecas[i] * quantPecas[i]));
		}

	}

	// -------------------------------------------------------------

	private static void mostraDadosJanelas() {
		// TODO Auto-generated method stub
		String aux = "";
		for (int i=0;i<codigoPecas.length;i++){
			aux = aux + "\n------------------------------\n" + "Peça index [" + i + "]\n" + "\nCodigo da Peça:" + codigoPecas[i] + "\nPeça:" + nomePecas[i] + "\nQuantidade:" + quantPecas[i]  + "\nPreço:" +precoPecas[i] + "\nPreço total: " + (precoPecas[i] * quantPecas[i]);

		}
		JOptionPane.showMessageDialog(null, aux);
	}

	// -------------------------------------------------------------


	public static void main(String[] args) {
		// TODO Auto-generated method stub


		int contPecas = Integer.parseInt(JOptionPane.showInputDialog("Entre com o número de peças:"));

		codigoPecas = new int [contPecas];
		nomePecas = new String[contPecas];
		quantPecas = new int [contPecas];
		precoPecas = new double [contPecas];

		int opcao;

		do{
			opcao = Integer.parseInt(JOptionPane.showInputDialog(" ---MENU--- \n 1 - Cadastro de pecas \n 2 - Pesquisa \n  0 - Sair"));
			switch(opcao){
			case 1: cadastro(); break;
			case 2: pesquisa(); break;

			}

		}while(opcao!=0);
		System.out.println("fim!");

	}

}



