public class exercicio1 {
	
	public static int contNumeros(int [] v, int n) {
		int cont = 0;
		for (int i = 0; i < v.length;i++) {
			if (v[i] > n) cont ++;
		}
		return cont;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Exercícios para fazer em aula

		1 - Criar uma função que retorne quantos números em um vetor são maiores que o parametro n 

		// chamada
		vetor=[1,5,8,9,10];
		contador = quantos_Numeros_Maiores(vetor,3);
		System.out.println(contador); // resposta: 4.

		*/
				
		int vetor [] = {4, 5, 6, 7, 8};
		int c = contNumeros(vetor,1);
		
		System.out.println("contador =>"+c);
		System.out.println(contNumeros(vetor,2));
		System.out.println(contNumeros(vetor,3));
		System.out.println(contNumeros(vetor,6));
		
		for (int i=0; i<10000; i++) {
			
		}
		

	}

}
