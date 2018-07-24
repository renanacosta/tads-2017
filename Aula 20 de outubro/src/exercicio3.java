
//3-  Faça uma função que retorne a mediana de um vetor.


public class exercicio3 {

	// FUNÇÃO QUE RETORNA A MEDIANA DE UM VETOR.
	
	public static int mediana( int[] parametro) {
		
		// MEDIANA
		
        int indice = parametro.length/2;
        return parametro[indice];
        
         }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int vetor[] = {4,7,9,10,12};
		int m =mediana(vetor);
		
		System.out.println("A mediana do vetor é: "+m);
		
		int vetor1[] = {3,6,11,13};
		m= mediana(vetor1);
		
		System.out.println("A mediana do vetor1 é: "+m);
		
	
		
		
		
	}

}
