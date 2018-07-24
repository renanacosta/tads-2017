package fracao;
class Fracao {
final int numerador;
final int denominador;
	//Sei que nem precisa, mas vou comentar esse tb, adoro comentar
	
	Fracao(int numerador, int denominador){
		this.numerador = numerador;
		this.denominador = denominador;
	} //Construtor de fração
	//entram 2 int (inteiro sabe), 1 numerador e 1 denominador
	Fracao add(Fracao k){
		if(k.denominador!=this.denominador)  
		return new Fracao((this.numerador * k.denominador + k.numerador * this.denominador / mdc(this.denominador, k.denominador)), k.denominador * this.denominador / mdc(this.denominador, k.denominador));
		
		return new Fracao(this.numerador + k.numerador, this.denominador);
	
	}
	/*Add, caso denominadores sejam diferentes, são
	multiplicados seus denominadores e divididos pelo seu mdc
	o numerador multiplica-se por denominador 2 vezes e depois faz-se o mesmo
	É bem verdade que parece uma gambiarra, mas foi a forma que encontrei de dar
	certo para (quase) todos os casos
	*/
	Fracao add(int x) {
		return new Fracao(x * this.denominador + this.numerador, this.denominador);
	} //Aqui é aquela comum, em que multiplicase o valor pelo seu denominador
	//e depois adiciona-se o numerador
	//ela vem assim: 3 + 1 = 3*4+1;
	//					 4
	
	Fracao sub(Fracao k) {
		if(k.denominador!=this.denominador) 
		
		return new Fracao
		((this.numerador * k.denominador
		- k.numerador * this.denominador) 
		/ mdc(this.denominador, k.denominador)
		, k.denominador * this.denominador
		/ mdc (this.denominador, k.denominador));
		
		return new Fracao
		(this.numerador - k.numerador, 
		this.denominador);
	//Subtração, a mesma coisa que a adição porém decrementando	
	}
	Fracao mult(Fracao k) {
		return new Fracao(this.numerador * k.numerador,
				this.denominador * k.denominador);
	//Multiplicação, aqui é indiferente o denominador ser diferente
	}
	
	Fracao div(Fracao k) {
		return new Fracao(k.denominador * this.numerador, k.numerador * this.denominador);
		//Inverte-se e multiplica-se
	} 
	Fracao inv() {
		return new Fracao(this.denominador, this.numerador);
	}
	//Inversa, apenas troca-se o denominador por numerador 
	//na nova fração criada
	Fracao() {
		this.numerador = 0;
		this.denominador = 1;
		return;
	}
	//Fração sem parâmetros, ela inicia com numerador em 0
	//e denominador em 1
	
	public int menor(int a, int b) {
		int menor = a < b ? a : b;
		    return menor;
	       
		  }  //será usado no MDC
	//OBS: já que o prof disse que POO tb serve pra copiar e colar
	//copiei e colei lá do livro dele, na caruda msm
	//sem chorar hein!!
	
	public int mdc(int a, int b) {
		int mdc = menor(a, b);
		    while (a % mdc != 0 || b % mdc !=0) {
		      mdc = mdc - 1;
		    }
		    	return mdc;
	  }
	
	public boolean equals(Fracao x) {
		return this.numerador == x.numerador
				&& this.denominador == x.denominador;
	} 
}	

public class Main {
	public static void main(String[] args) {
		Fracao f1 = new Fracao(3, 5);
		System.out.println(f1.numerador == 3);
		System.out.println(f1.denominador == 5);
		 
		/* 
		as seguintes duas linhas não devem compilar, comente-as
		f1.numerador = 1;
		f1.denominador = 1;
		  
		Como aqui temos um objeto imutável sabe (Atributos são todos final)
		Somente com a criação de uma nova Instancia de Objeto fração é possivel ne
		Fracao f2 = new Fracao (1,1); 
		*/
		
		Fracao t1 = new Fracao(3, 5);
		System.out.println(f1.equals(t1) == true);
		 
		Fracao f2 = new Fracao(1, 5);
		System.out.println(f2.numerador == 1);
		System.out.println(f2.denominador == 5);
		 
		System.out.println(f2.equals(t1) == false);
		 
		Fracao r1 = f1.add(f2);
		System.out.println(r1.numerador == 4);
		System.out.println(r1.denominador == 5);
		System.out.println(f1.numerador == 3);
		System.out.println(f1.denominador == 5);
		System.out.println(f2.numerador == 1);
		System.out.println(f2.denominador == 5);
		// até aqui 0.2 pts
		 
		Fracao f3 = new Fracao(3, 7);
		System.out.println(f3.numerador == 3);
		System.out.println(f3.denominador == 7);
		 
		Fracao r2 = f2.add(f3);
		System.out.println(r2.numerador == 22);
		System.out.println(r2.denominador == 35);
		System.out.println(f2.numerador == 1);
		System.out.println(f2.denominador == 5);
		System.out.println(f3.numerador == 3);
		System.out.println(f3.denominador == 7);
		// até aqui 0.4 pts
		 
		Fracao r3 = r1.sub(r2);
		System.out.println(r3.numerador == 6);
		System.out.println(r3.denominador == 35);
		 
		Fracao r4 = r1.mult(r2);
		System.out.println(r4.numerador == 88);
		System.out.println(r4.denominador == 175);
		 
		Fracao r5 = r2.div(r1);
		System.out.println(r5.numerador == 110);
		System.out.println(r5.denominador == 140);
		 
		Fracao r6 = f1.inv(); // inversa
		System.out.println(r6.numerador == 5);
		System.out.println(r6.denominador == 3);
		 
		Fracao f4 = new Fracao(); // valor padrão: 0/1
		System.out.println(f4.numerador == 0);
		System.out.println(f4.denominador == 1);
		System.out.println(f4.add(f4).numerador == 0);
		System.out.println(f4.add(f4).denominador == 1);
		 
		Fracao f5 = new Fracao(1, 2);
		System.out.println(f5.numerador == 1);
		System.out.println(f5.denominador == 2);
		System.out.println(f5.mult(f5).numerador == 1);
		System.out.println(f5.mult(f5).denominador == 4);
		// garantindo que não há efeitos colaterais:
		System.out.println(f5.numerador == 1);
		System.out.println(f5.denominador == 2);
		//
		System.out.println(f5.mult(f5.mult(f5)).denominador == 8);
		// até aqui 0.6 pts
		 
		Fracao f6 = new Fracao(1, 2);
		System.out.println(f6.numerador == 1);
		System.out.println(f6.denominador == 2);
		 
		Fracao r7 = f6.add(1);
		System.out.println(r7.numerador == 3);
		System.out.println(r7.denominador == 2);
		 
		Fracao r8 = f6.add(1);
		System.out.println(r8.numerador == 3);
		System.out.println(r8.denominador == 2);
		// até aqui 0.8 pts
		 
	}

}