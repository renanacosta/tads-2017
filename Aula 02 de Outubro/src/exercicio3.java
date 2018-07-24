
public class exercicio3 {
	public static double somatorio (int n) {
		
		double soma=0;
		for (int i=1; i<=n; i++) {
			soma = soma + i/(Math.pow(Math.PI, i));
		}
		return soma;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*3 - Calcular o somatorio abaixo e retornar o resultado. Utilizar o parâmetro n para contabilizar o numero de termos.  
	    res = 1/PI + 2/PI² + 3/PI³ + 4/PI⁴ + ...
	    */
		
		System.out.println(somatorio(1));
		

	}

}
