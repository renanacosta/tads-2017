importar javax.swing.SingleSelectionModel;

classe pública Funcoes_1 {

	 static int soma3Parcelas (int p1, int p2, int p3) {
		retornar p1 + p2 + p3;
	}
	 
	 static int mediana (int [] param) {
		 int indice = param.length / 2;
		 return param [indice];
	 }
		
	 static void quadrado () {
		 System.out.println ("----------");
		 System.out.println ("- -");
		 System.out.println ("- -");
		 System.out.println ("- -");
		 System.out.println ("- -");	
		 System.out.println ("----------");
	 }
	 
    public static int primeiroElemento (int [] gen) {
        retornar gen [0];
    }
	
    static int ultimoElemento (int [] ppppp) {
    	retornar ppppp [ppppp.length - 1];
    }
    
    static boolean testaString (String frasezita) {
    	para (int i = 0; i <frasezita.length (); i ++) {
    		se (frasezita.charAt (i) == '') {
    			retornar verdadeiro;
    		}
    	}
    	retornar falso; 
    	
    }
    
    

	 static int [] copia (int [] v) {
		int auxiliar [] = novo int [v.length];
		para (int i = 0; i <auxiliar.length; i ++) {
			auxiliar [i] = v [i];
		}
	    retornar auxiliar;
	}
    
    
	public static void main (String [] args) {
		// TODO método de método gerado automaticamente
		
		int a, b, c, soma;
		a = 4;
		b = 5;
		c = 2;
		soma = soma3Parcelas (a, b, 100);
		
		System.out.println ("A soma é:" + soma);
		quadrado ();
		
		int [] vetor = {4,3,2,1};
		int m = mediana (vetor);
		System.out.println ("mediana" + m);
		int [] vetor1 = {6,4,3,2,1};
		m = mediana (vetor1);
		System.out.println ("mediana" + m);

		// criar uma função que RETORNE o 
		// primeiro elemento de um vetor.
		m = primeiroElemento (vetor1);
		int ultimo = ultimoElemento (vector1);
		
		
		String frase = "Tem espaços em branco aqui !!!";
		variação booleana = testaString (frase);
		
		int [] meu_vetor;
		
		meu_vetor = copia (vector1);
		

	}
}

