
// FAZER UM PROGRAMA QUE CALCULE A MÉDIA DOS DADOS DO VETOR

public class ex1 {

	public static double calcMedia(int [] anyName){
		int soma = 0;
		double med;
		for (int i=0; i<anyName.length; i++){
			soma = soma + anyName[i];
		}

		med = soma/anyName.length;

		return med;


	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int vet[] = new int [4];
		vet[0] = 4;
		vet[1] = 5;
		vet[2] = 10;
		vet[3] = 9;

		double media = calcMedia(vet);
		System.out.println("a média é " + media);

	}


}


