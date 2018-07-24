import javax.swing.JOptionPane;


// verificar se uma palavra digitada pelo usuario é um palindromo ou não

public class exercicio2 {
	public static void main(String[] args) {

		String palavra = JOptionPane.showInputDialog("Entre com a palavra: ");
		boolean palindromo = true;
		int cont = palavra.length()-1; 

		for(int i=0; i<palavra.length()/2; i++){

			if(palavra.charAt(i) != palavra.charAt(cont)){

				palindromo = false;
				break;

			}
			cont--;
		}
		if(palindromo)System.out.println("A palavra "+palavra+ " é um PALINDROMO");
		else System.out.println("A palavra "+palavra+ " NÃO é um PALINDROMO");;
	}
}
