
		// FAZER UMA FUNÇÃO QUE UNE DOIS VETORES
		// v3=concatenar (v1,v2);
		
		public class ex2 {

	public static int[]  concatenar (int [] v1, int [] v2){
		int []  temp = new int [v1.length + v2.length];
		
		for (int i=0; i<v1.length; i++){
			temp[i] = v1[i];
		
		}
		int j=0;
		for (int i=v1.length; i<temp.length; i++){
			temp[i]=v2[j];
			j++;
		}
		
		
		return temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

		int [] vet1 = {5,4,3,2};
		int [] vet2 = {7,2,1,8};
		
		int [] vet3;
		
		vet3 = concatenar(vet1,vet2);
		for(int i=0; i<vet3.length; i++){
			System.out.println("vet3["+i+"]:" + vet3[i]);
		}
		
	}

}