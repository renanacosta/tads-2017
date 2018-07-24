package jogorestaum;

public class Principal {

	public static void main(String[] args) {
		
		int escolha = 2;
		escolherTela(escolha);

	}
	
	public static void escolherTela(int v){
		
		TelaInicio t= null;
		Jogo j= null;
		TelaPontos p = null;
		TelaRegras r= null;
		
		
		switch (v) {
		case 1:
		  j = new Jogo();
		  
		break;
		
		case 2:
			t = new TelaInicio();
		  			
		break;
			
		case 3:
			p = new TelaPontos();
		  			
			System.out.println("tela pontos valor e: "+p.hashCode());
			
		break;
		
		case 4:
			r = new TelaRegras();
		  
		break;

		default:
			t = new TelaInicio();
		  
		break;
	 }
		
	}
	
}
