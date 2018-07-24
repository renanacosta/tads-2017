//5- Faça uma função que retorne a cópia de um array passado por parâmetro.


public class exercicio5 {
	
	static int[] copia(int[]v) {
		int auxiliar [] = new int [v.length];
		for (int i=0; i<auxiliar.length; i++) {
			auxiliar[i] = v[i];
		}
		
		return auxiliar;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int vetor1[] = {3,6,11,13};
		int [] meu_vetor;
				
		meu_vetor = copia (vetor1);
		for (int i=0; i<meu_vetor.length;i++) {
			System.out.println(meu_vetor[i]);
		}

		}
   
}
