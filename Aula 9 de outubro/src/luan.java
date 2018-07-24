
import javax.swing.JOptionPane;
public class luan{


	public static int[] codigoPecas, quantPecas;
	public static double[] precoPecas;
	public static String[] nomePecas;

	public static void cadastro() {
		for (int i=0;i<codigoPecas.length;i++){
			codigoPecas[i] =  Integer.parseInt(JOptionPane.showInputDialog("Entre com o codigo do item "+ (i+1)+ ": "));
			nomePecas[i] =    JOptionPane.showInputDialog("Entre com o nome da peca: ");
			quantPecas[i] =   Integer.parseInt(JOptionPane.showInputDialog("Entre com a quantidade do item "+'"'+nomePecas[i]+'"'+':'));
			precoPecas[i] =   Integer.parseInt(JOptionPane.showInputDialog("Preço do item "+'"'+nomePecas[i]+'"'+':'));
		}
	}


	// caso 1

	public static void maiorPrecoUnitario(){
		double maiorpreco= Integer.MIN_VALUE;
		String maior_preco="";
		for (int i=0;i<codigoPecas.length;i++){
			if (precoPecas[i]>maiorpreco){
				maiorpreco=precoPecas[i];
				maior_preco= nomePecas[i];
			}
		}
		JOptionPane.showMessageDialog(null, "Nome da peça com maior preço unitario: "+maior_preco+"\nPreço total: "+ maiorpreco );
	}

	// caso 2

	public static void maiorPrecoTotal(){
		double maiorprecoTOTAL=Integer.MIN_VALUE;
		double somaTotal=0;
		String maior_preco="";
		for (int i=0;i<codigoPecas.length;i++){
			somaTotal = (quantPecas[i] * precoPecas[i]);
			if(somaTotal > maiorprecoTOTAL){
				maiorprecoTOTAL=somaTotal;
				maior_preco=nomePecas[i];
			}
		}
		JOptionPane.showMessageDialog(null, "Nome da peça com maior preço total: "+maior_preco+"\nPreço total: "+ maiorprecoTOTAL);

	}

	//caso3

	public static void listarDados(){
		String temp="";
		for (int i=0;i<codigoPecas.length;i++){
			temp= temp+"\n ______________________________________\n" + "Nome da peça: "+nomePecas[i]+"\nQuantidade: "+quantPecas[i]+ "\nPreço: "+ precoPecas[i]+ "\nPreco Total: " + (quantPecas[i] * precoPecas[i]);
		}
		JOptionPane.showMessageDialog(null, temp);
	}

	//caso4 - Realizar busca da peça pelo codigo

	public static void buscarCodigo(){
		int busca = Integer.parseInt(JOptionPane.showInputDialog("Entre com o codigo a ser pesquisado: "));
		int temp=0;
		String pecaTemp="";
		for (int i=0;i<codigoPecas.length;i++){
			if (busca == codigoPecas[i]){
				temp++;
				pecaTemp= nomePecas[i];
			}
		}
		if(temp==1){
			JOptionPane.showMessageDialog(null, "Codigo pesquisado: " +busca+"\nNome da peça encontrada: "+ pecaTemp );
		}else{
			JOptionPane.showMessageDialog(null, "Não foi encontrado peças com o codigo pesquisado.\n Digite "+'"'+'3'+'"'+" no menu anterior para listagem de dados de todas as peças para checagem de codigos a serem pesquisado!");
		}
	}
	public static void pesquisa() {
		int opcaoDePesquisa;
		do{
			opcaoDePesquisa = Integer.parseInt(JOptionPane.showInputDialog("Entre com a opcao desejada: \n 1 - Apresentar o nome da peca com o maior preco unitário \n 2 - Apresentar o nome da peca com o maior preco total \n 3 - Listar todas as peças e seus dados com os precos totais \n 4 - Realizar busca da peça pelo codigo \n 5 - Buscar a peca pelo pedaço do nome \n 6 - Apresentar todas as peças que tenham uma quantidade 'x' \n 7 - Apresentar todas as peças com quantidade menor que 10 \n 8 - Apresentar todas as peças que tenham preço unitario maior que 500 reais \n 9 - Apresentar o valor total de preços totais no sistema   \n 0 - Volta um nivel "));

			switch(opcaoDePesquisa){
			case 1: maiorPrecoUnitario(); break;
			case 2: maiorPrecoTotal();    break;
			case 3: listarDados();        break;
			case 4:	buscarCodigo();       break;
			case 5: 
				break;
			case 6: 
				break;
			case 7: 
				break;
			case 8: 
				break;
			case 9: 
				break;
			}
		}while(opcaoDePesquisa!=0);
	}
	public static void main(String[] args) {
		int contPecas = Integer.parseInt(JOptionPane.showInputDialog("Entre com o número de peças:"));
		codigoPecas = new int [contPecas];
		nomePecas =   new String[contPecas];
		quantPecas =  new int [contPecas];
		precoPecas =  new double [contPecas];
		int opcao;
		do{
			opcao = Integer.parseInt(JOptionPane.showInputDialog(" ---MENU--- \n 1 - Cadastro de pecas \n 2 - Pesquisa \n 0 - Sair"));
			switch(opcao){
			case 1: cadastro(); break;
			case 2: pesquisa(); break;
			}
		}while(opcao!=0);
	}
}