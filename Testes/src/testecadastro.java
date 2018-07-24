import javax.swing.JOptionPane;



public class testecadastro {



	public static void main(String[]args){



		/*DECLARAÇÃO DAS VARIAVEIS*/

		int  n= Integer.parseInt(JOptionPane.showInputDialog("INFORME QUANTOS PRODUTOS DESEJA CADASTRAR"))+1;


		String produto[] = new String [n];

		String cadastro_valor_Un[] = new String [n];

		String cadastro_quantidade[] = new String [n];

		double valor_Un[] = new double [n];

		int quantidade[] = new int [n];



		/*LOOP DE ENTRADA PARA RECEBER O NOME DO PRODUTO*/

		for (int i=1; i<produto.length; i++){

			produto[i] = JOptionPane.showInputDialog(null, 

					"FAVOR INFORMAR O NOME DO "+i+"º"+ " PRODUTO: ", 

					"ACOSTA'S AUTO PEÇAS", 

					JOptionPane.PLAIN_MESSAGE);

		}



		/*MENSAGEM DE SUCESSO NA INCLUSAO DOS PRODUTO*/

		JOptionPane.showMessageDialog(null, 

				"PRODUTOS CADASTRADOS COM SUCESSO", 

				"ACOSTA'S AUTO PEÇAS",  

				JOptionPane.INFORMATION_MESSAGE);



		/*LOOP DE ENTRADA PARA RECEBER A QUANTIDADE DO ESTOQUE*/

		for (int i=1; i<quantidade.length; i++){

			quantidade[i] = Integer.parseInt(JOptionPane.showInputDialog(null,

					"FAVOR INFORMA QUANTIDADE(UN) EM ESTOQUE DO "+i+"º"+ " PRODUTO CADASTRADO: "+ "[ "+ produto[i]+" ]",

					"ACOSTA'S AUTO PEÇAS", 

					JOptionPane.PLAIN_MESSAGE));

		}



		/*MENSAGEM DE SUCESSO NA INCLUSAO DA QUANTIDADE*/

		JOptionPane.showMessageDialog(null, 

				"QUANTIDADES CADASTRADAS COM SUCESSO", 

				"ACOSTA'S AUTO PEÇAS",  

				JOptionPane.INFORMATION_MESSAGE);



		/*LOOP DE ENTRADA PARA RECEBER O VALOR UNITÁRIO*/

		for (int i=1; i<valor_Un.length; i++){

			valor_Un[i] = Double.parseDouble(JOptionPane.showInputDialog(null, 

					"FAVOR INFORMA O VALOR(UN) DO "+i+"º"+ " PRODUTO CADASTRADO "+ "[ "+ produto[i]+" ]",

					"ACOSTA'S AUTO PEÇAS", 

					JOptionPane.PLAIN_MESSAGE));         

		}



		/*MENSAGEM DE SUCESSO NA INCLUSAO DOS VALORES*/

		JOptionPane.showMessageDialog(null, 

				"VALORES CADASTRADOS COM SUCESSO", 

				"ACOSTA'S AUTO PEÇAS",  

				JOptionPane.INFORMATION_MESSAGE);



		int opcao = 1;

		String sOpcao = (JOptionPane.showInputDialog(null,

				"DIGITE [0] SAIR " + " [1] CADASTRO " + " [2] PESQUISA",

				"ACOSTA'S AUTO PEÇAS", 

				JOptionPane.INFORMATION_MESSAGE));

		opcao = Integer.parseInt(sOpcao);

		switch(opcao){

		case 0:

			break;

		case 1:{



			/*TITULO DO CADASTRO*/

			System.out.println("*****************************************");

			System.out.println(" ACOSTA'S AUTO PEÇAS ");

			System.out.println("CADASTRO DE PRODUTOS");

			System.out.println("=========================================");



			/*LOOP DE SAIDA PARA RECEBER E IMPRIMIR O PRODUTO JUNTO COM A QUANTIDADE*/

			System.out.println("ESTOQUE DO PRODUTO POR UNIDADE");



			for (int i=1; i<valor_Un.length; i++){

				cadastro_quantidade[i] = ("["+i+"]"+produto[i]+": "+ quantidade[i]);

				System.out.println(cadastro_quantidade[i]+ " Unidade");

			}



			/*LOOP DE SAIDA PARA REBECER E IMPRIMIR O PRODUTO JUNTO COM VALOR POR UNIDADE*/

			System.out.println("=========================================");

			System.out.println("VALOR DO PRODUTO UNITÁRIO");



			for (int i=1; i<cadastro_valor_Un.length; i++){

				cadastro_valor_Un[i] = ("["+i+"]"+produto[i]+": "+"R$"+ valor_Un[i]);

				System.out.println(cadastro_valor_Un[i]);

			}


			break;

		}

		default:{

			JOptionPane.showMessageDialog(null, 

					"A OPÇÃO INFORMADA É INVALIDA.",

					"ACOSTA'S AUTO PEÇAS", 

					JOptionPane.ERROR_MESSAGE);

			break;

		}

		}

	}

}
