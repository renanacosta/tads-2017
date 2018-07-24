
// 3 - CADASTRO DE PRESOS
//================================================================================================

import javax.swing.JOptionPane;

public class exercicio3 {

	static int contCadastro = Integer.parseInt(JOptionPane.showInputDialog(null, "QUANTOS DETENTOS DESEJA CADASTRAR? ",
			"BEM VINDO AO SISTEMA ACOSTA'S PRISION ", JOptionPane.INFORMATION_MESSAGE));
	static int[] matriculaDetento = new int[contCadastro];
	static String[] nomeDetento = new String[contCadastro];
	static int[] tempoDePena = new int[contCadastro];
	static int[] periculosidade = new int[contCadastro];
	static int aux = 0;
	static boolean pesquisa_habilitada = false;

	// ================================================================================================
	// DETENTO COM MAIOR PERICULOSIDADE
	// CASO 1

	public static void detentoDeMaiorPericulosidade() {

		int temp = Integer.MIN_VALUE;
		int cont = 0;
		String aux = "";
		String maiorPericulosidade = "";

		for (int i = 0; i < contCadastro; i++) {
			if (periculosidade[i] > temp) {
				temp = periculosidade[i];
				maiorPericulosidade = "\n==============================\n Nome: " + nomeDetento[i] + "\n MATRICULA: "
						+ matriculaDetento[i] + "\n PERICULOSIDADE: NIVEL " + periculosidade[i];
			}
		}
		for (int j = 0; j < contCadastro; j++) {
			if (periculosidade[j] == temp) {
				aux = aux + "\n==============================\n Nome: " + nomeDetento[j] + "\n MATRICULA: "
						+ matriculaDetento[j] + "\n PERICULOSIDADE: NIVEL " + periculosidade[j];
				cont++;
			}
		}
		if (cont <= 1) {
			JOptionPane.showMessageDialog(null, "O DETENTO COM A MAIOR PERICULOSIDADE É:\n" + maiorPericulosidade,
					"ACOSTA'S PRISION", JOptionPane.INFORMATION_MESSAGE);
		}
		if (cont > 1) {
			JOptionPane.showMessageDialog(null, "FOI ENCONTRADO MAIS DE UM DETENTO COM A MAIOR PERICULOSIDADE!\n" + aux,
					"ACOSTA'S PRISION", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	// ================================================================================================
	// DETENTO COM MENOR PERICULOSIDADE
	// CASO 2

	public static void detentoDeMenorPericulosidade() {
		int temp = Integer.MAX_VALUE;
		int cont = 0;
		String aux = "";
		String menorPericulosidade = "";

		for (int i = 0; i < contCadastro; i++) {
			if (periculosidade[i] < temp) {
				temp = periculosidade[i];
				menorPericulosidade = "\n==============================\n Nome: " + nomeDetento[i] + "\n MATRICULA: "
						+ matriculaDetento[i] + "\n PERICULOSIDADE: NIVEL " + periculosidade[i];
			}
		}
		for (int j = 0; j < contCadastro; j++) {
			if (periculosidade[j] == temp) {
				aux = aux + "\n==============================\n Nome: " + nomeDetento[j] + "\n MATRICULA: "
						+ matriculaDetento[j] + "\n PERICULOSIDADE: NIVEL " + periculosidade[j];
				cont++;
			}
		}
		if (cont <= 1) {
			JOptionPane.showMessageDialog(null, "O DETENTO COM A MENOR PERICULOSIDADE É:\n" + menorPericulosidade,
					"ACOSTA'S PRISION", JOptionPane.INFORMATION_MESSAGE);
		}
		if (cont > 1) {
			JOptionPane.showMessageDialog(null, "FOI ENCONTRADO MAIS DE UM DETENTO COM A MENOR PERICULOSIDADE!\n" + aux,
					"ACOSTA'S PRISION", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	// ================================================================================================
	// LISTA DE SERIAL KILLERS / CONGRESSISTA (POLÍTICO) / CORRUPTOS
	// CASO 3

	public static void listarSerialsCongressistas() {

		int cont = 0;
		String aux = "";

		for (int i = 0; i < contCadastro; i++) {
			if (periculosidade[i] == 5) {
				aux = aux + "\n==============================\n Nome: " + nomeDetento[i] + "\n MATRICULA: "
						+ matriculaDetento[i] + "\n PERICULOSIDADE: NIVEL " + periculosidade[i];
				cont++;
			}
		}
		if (cont == 0) {
			JOptionPane.showMessageDialog(null, "NÃO FORAM CADASTRADOS DETENTOS COM ESSA PERICULOSIDADE",
					"ACOSTA'S PRISION", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null,
					"FOI ENCONTRADO ( " + cont + " ) DETENTO(S) COM ESSA PERICULOSIDADE:\n" + aux, "ACOSTA'S PRISION",
					JOptionPane.INFORMATION_MESSAGE);

		}
	}

	// ================================================================================================
	// DETENTO COM MAIOR TEMPO DE PENA
	// CASO 4

	public static void maiorTempoDePena() {

		int temp = Integer.MIN_VALUE;
		int cont = 0;
		String aux = "";
		String maiorApenado = "";

		for (int i = 0; i < contCadastro; i++) {
			if (tempoDePena[i] > temp) {
				temp = tempoDePena[i];
				maiorApenado = "\n==============================\n Nome: " + nomeDetento[i] + "\n TEMPO DA PENA: "
						+ tempoDePena[i] + " MESES";
			}
		}
		for (int j = 0; j < contCadastro; j++) {
			if (tempoDePena[j] == temp) {
				aux = aux + "\n==============================\n Nome: " + nomeDetento[j] + "\n TEMPO DA PENA: "
						+ tempoDePena[j] + " MESES";
				cont++;
			}
		}
		if (cont <= 1) {
			JOptionPane.showMessageDialog(null, "O DETENTO COM MAIOR TEMPO DE PENA É: " + maiorApenado,
					"ACOSTA'S PRISION", JOptionPane.INFORMATION_MESSAGE);
		}
		if (cont > 1) {
			JOptionPane.showMessageDialog(null,
					"FOI ENCONTRADO MAIS DE UM DETENTO COM O MESMO TEMPO DE PENA!\n  " + aux, "ACOSTA'S PRISION",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	// ================================================================================================
	// LISTAR TODOS OS DETENTOS
	// CASO 5

	public static void listarTodosOsDetentos() {

		String aux = "";
		for (int i = 0; i < contCadastro; i++) {
			aux = aux + "==============================\n Nome: " + nomeDetento[i] + "\n MATRICULA: "
					+ matriculaDetento[i] + "\n TEMPO DA PENA: " + tempoDePena[i] + " MESES \n PERICULOSIDADE: NIVEL "
					+ periculosidade[i] + "\n";
		}
		JOptionPane.showMessageDialog(null, aux, "ACOSTA'S PRISION", JOptionPane.INFORMATION_MESSAGE);
	}

	// ================================================================================================
	// CADASTRO

	public static boolean cadastro() {

		if (aux == 0) {
			aux++;
			for (int i = 0; i < contCadastro; i++) {
				matriculaDetento[i] = Integer.parseInt(JOptionPane.showInputDialog(null,
						"ENTRE COM A MATRICULA DO DETENTO:", "ACOSTA'S PRISION", JOptionPane.INFORMATION_MESSAGE));
				nomeDetento[i] = JOptionPane.showInputDialog(null, "ENTRE COM O NOME DO DETENTO:", "ACOSTA'S PRISION",
						JOptionPane.INFORMATION_MESSAGE);
				tempoDePena[i] = Integer
						.parseInt(JOptionPane.showInputDialog(null, "ENTRE COM O TEMPO DA PENA  DO DETENTO (EM MESÊS):",
								"ACOSTA'S PRISION", JOptionPane.INFORMATION_MESSAGE));
				periculosidade[i] = Integer.parseInt(JOptionPane.showInputDialog(null,
						">> INFORME A PERICULOSIDADE DO DETENTO << \n ------------------------------------------------\n [1] – LADRÃO DE GALINHA \n [2] – GATUNO/TRAFICANTE NIVEL BÁSICO \n [3] – LADRÃO PROFISSIONAL/TRAFICANTE NIVEL AVANÇADO \n [4] – CHEFE DE ORGANIZAÇÃO/CEO DO TRAFICO/MATADOR DE ALUGUEL \n [5] – SERIAL KILLER/CONGRESSISTA (POLITICO) CORRUPTO",
						"ACOSTA'S PRISION", JOptionPane.INFORMATION_MESSAGE));
				JOptionPane.showMessageDialog(null, "CADASTRO REALIZADO COM SUCESSO", "ACOSTA'S PRISION",
						JOptionPane.INFORMATION_MESSAGE);
				while ((periculosidade[i] < 1) || (periculosidade[i] > 5)) {
					JOptionPane.showMessageDialog(null, "FAVOR INFORMAR UM VALOR VÁLIDO", "OCORREU UM ERRO",
							JOptionPane.ERROR_MESSAGE);
					periculosidade[i] = Integer.parseInt(JOptionPane.showInputDialog(null,
							">> INFORME A PERICULOSIDADE DO DETENTO << \n ------------------------------------------------\n [1] – LADRÃO DE GALINHA \n [2] – GATUNO/TRAFICANTE NIVEL BÁSICO \n [3] – LADRÃO PROFISSIONAL/TRAFICANTE NIVEL AVANÇADO \n [4] – CHEFE DE ORGANIZAÇÃO/CEO DO TRAFICO/MATADOR DE ALUGUEL \n [5] – SERIAL KILLER/CONGRESSISTA (POLITICO) CORRUPTO",
							"ACOSTA'S PRISION", JOptionPane.INFORMATION_MESSAGE));
					JOptionPane.showMessageDialog(null, "CADASTRO REALIZADO COM SUCESSO", "ACOSTA'S PRISION",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"DESCULPE. A QUANTIDADE INFORMADA DE DETENTOS JÁ FOI CADASTRADA! ( " + contCadastro + " )",
					"ACOSTA'S PRISION", JOptionPane.INFORMATION_MESSAGE);

		}
		return true;
	}

	// ================================================================================================
	// PESQUISA

	public static void pesquisa() {

		int opcao;

		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
					"############ MENU DE PESQUISA ############ \n ->	INFORME A OPÇÃO DESEJADA	<- \n ------------------------------------------------\n [1] - DETENTO COM A MAIOR PERICULOSIDADE \n [2] - DETENTO COM A MENOR PERICULOSIDADE \n [3] - LISTAR NOME DOS SERIAL KILLERS/CONGRESSISTAS (POLÍTICOS) CORRUPTOS \n [4] - LISTAR DETENTO COM MAIOR TEMPO DE PENA \n [5] - LISTAR TODOS OS DETENTOS \n [0] - RETORNAR AO MENU ANTERIOR",
					"ACOSTA'S PRISION", JOptionPane.INFORMATION_MESSAGE));
			switch (opcao) {

			case 1:
				detentoDeMaiorPericulosidade();
				break;
			case 2:
				detentoDeMenorPericulosidade();
				break;
			case 3:
				listarSerialsCongressistas();
				break;
			case 4:
				maiorTempoDePena();
				break;
			case 5:
				listarTodosOsDetentos();
				break;

			}
		} while (opcao != 0);
	}

	public static void main(String[] args) {

		int opcao;
		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
					" ########## MENU ########## \n -> INFORME A OPÇÃO DESEJADA <- \n ------------------------------------------------\n [1] - CADASTRO DE DETENTOS \n [2] - PESQUISA \n [0] - SAIR \n #########################",
					"ACOSTA'S PRISION", JOptionPane.INFORMATION_MESSAGE));

			switch (opcao) {
			case 1:
				pesquisa_habilitada = cadastro();
				break;
			case 2:
				if (pesquisa_habilitada) {
					pesquisa();
					break;
				} else {
					JOptionPane.showMessageDialog(null,
							" DESCULPE!!! \n PARA FAZER UMA PESQUISA, ANTES É NECESSÁRIO REALIZAR UM CADASTRO!",
							"OCORREU UM ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		} while (opcao != 0);
		JOptionPane.showMessageDialog(null, "FIM DO PROGRAMA!", "ACOSTA'S PRISION", JOptionPane.INFORMATION_MESSAGE);
	}
}