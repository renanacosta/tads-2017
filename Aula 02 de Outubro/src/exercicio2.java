	/* 2 - Criar uma função que retorne se um vetor é divisível por n, indicado pelo parâmetro.

		v=[2,4,7,9];
		console.log(vetor_divisivel(v,4));

*/
public class exercicio2 {

	/*public static boolean ehDivisivel(int n, int[] a) {
	boolean eDivisivel = false;
	int cont=0;
	for (int i=0; i<a.length; i++) {
		if(a[i]%n == 0) eDivisivel = true;
		
	}
	if (cont==a.length) eDivisivel=true;
	else eDivisivel = false;
	
	return eDivisivel;
	
}*/
	public static boolean ehDivisivel(int n, int[] a) {
		boolean eDivisivel = false;
		int cont=0;
		for (int i=0; i<a.length; i++) {
			if(a[i]%n == 0) eDivisivel = true;
			
		}
		if (cont==a.length) eDivisivel=true;
		else eDivisivel = false;
		
		return eDivisivel;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] vet = {3,6,9,12,15,18};
		if (ehDivisivel(3,vet)) {
			System.out.println("é divisivel");
				
		}else {
			System.out.println("NÃO É DIVISIVEL");
		}
	
		
		

	}

}
