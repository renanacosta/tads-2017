public class Exercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//5 – Escreva um programa que gere um vetor com os dados 100 a 1, em ordem
		//decrescente. (100 indice 0, 99, indice 1, etc… 1 indice, 99. ) Imprimir todos os
		//dados do vetor na tela. 

		int vetor[] = new int [100];
		int temp=100;

		for (int i=0;i<vetor.length;i++){
			System.out.println("vetor["+i+"]:"+temp);

			temp--;
		}
	}
}
