//4- Faça uma função que retorne true se uma string tem pelo menos um espaço em branco.


public class exercicio4 {

	
	static boolean testaString(String frasezita) { 
	for (int i = 0; i<frasezita.length();i++){
		if (frasezita.charAt(i)== ' ') {
			return true;
		}
	}
	return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String frase = "tem espaços em branco aqui!!!";
		boolean variavel = testaString(frase);

	}

}
