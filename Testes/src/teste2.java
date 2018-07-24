import javax.swing.JOptionPane;

public class teste2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//6 – Vale 1 ponto a mais no bimestre. 
		//Fazer um programa que, através de dois vetores com o mesmo tamanho e tamanho e dados definidos 
		//pelo usuário, apresente verdadeiro, se os dois vetores estão de ordem inversa, e falso caso contrário. 
		
		//Resultado esperado: “Verdadeiro, ou seja os dados do vetor 2 tem dados do
		//vetor 1 porém de maneira invertida.
		
		//Regras!:
		//Usar UM “for”. pode usar 2
		//Usar uma váriável TEMP de troca.
		//O resto é “pensar”!!!!!
		
		
		int  n= Integer.parseInt(JOptionPane.showInputDialog("Tamanho dos vetores"));


		int v1[] = new int [n], v2[] = new int [n];

		int cont1=n, cont2=0;   


		for (int i=0;i<v1.length;i++){
			v1[i]=Integer.parseInt(JOptionPane.showInputDialog("Dados do vetor 1, posição: "+i));
			System.out.println("vetor 1["+i+"]: "+v1[i]);

		} for (int i=0;i<v1.length;i++){
			v2[i]=Integer.parseInt(JOptionPane.showInputDialog("Dados do vetor 2, posição: "+i));
			System.out.println("vetor 2["+i+"]: "+v2[i]);
		}
		
		cont1=cont2=0;
		while (cont1 < n ) {   
			if(((v1[cont1])==v2[n-1-cont1])){
					
			cont2++; 												
	}
			cont1++;
		}
		if(cont2==n){
			System.out.println("Verdadeiro, os valores estão em ordem inversa!");
			JOptionPane.showMessageDialog(null, "Verdadeiro");
			
		}else {
			System.out.println("Falso, os valores não estão em ordem inversa!");
			JOptionPane.showMessageDialog(null, "Falso");
		}

	}

}

