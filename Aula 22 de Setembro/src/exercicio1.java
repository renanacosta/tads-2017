import javax.swing.JOptionPane;

public class exercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1- CONCATENAR O VALOR DE UM VETOR NO OUTRO.

		int n =Integer.parseInt(JOptionPane.showInputDialog("Tamanho do vet1"));

		int v1[] = new int [n];

		for (int i=0;i<v1.length;i++){
			v1[i]=Integer.parseInt(JOptionPane.showInputDialog("Dados do vetor 1, posição: "+i));
			System.out.println("vetor 1["+i+"]: "+v1[i]);
			
			
		} 
		System.out.println("##############################");
		n =Integer.parseInt(JOptionPane.showInputDialog("Tamanho do vet2"));
		int v2[] = new int [n];
		for (int i=0;i<v2.length;i++){
			v2[i]=Integer.parseInt(JOptionPane.showInputDialog("Dados do vetor 2, posição: "+i));
			System.out.println("vetor 2["+i+"]: "+v2[i]);
			
		}

		int v3[] = new int [v1.length+v2.length];
		int p=0;
		
		System.out.println("==============================");
		System.out.println("A concatenação dos vetores é: ");
		System.out.println("==============================");
		
		for (int i=0;i<v3.length;i++){
			if (i<v1.length) {
				v3[i]=v1[i];
			}else {
				v3[i]=v2[p];
				p++;
			}
			
		}
		for (int i=0; i<v3.length; i++) {
			
			System.out.print(" "+v3[i]);
			
		}
		 
	}
		
}

