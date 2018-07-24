
public class exercicio4 {
	public static double somatorio () {
		double soma = 0;
		int n=10;
		for (int i=1; i<=n; i++) {
			soma = soma + i/(Math.pow(n, i+1));
		}
		return soma;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*4- Calcular o somatório de 10 termos abaixo usando o parámetro n como valor do denominador: 

			res = 1/n² + 2/n³ + 3/n⁴ ...  10/n¹¹
			Guardar o resultado em um vetor [0] e os demais resultados de cada termo no primeiro indice, segundo e assim por diante. 

*/
		
		System.out.println(somatorio());
		
	}

}
