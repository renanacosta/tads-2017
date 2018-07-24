package jogorestaum;

public class Pontos {

	public int numero;
	private String nome;
	private int pontos;

	public Pontos() {
		gerarPontos();
	}

	public Pontos(String nome, int pontos) {
		this.nome = nome;
		this.pontos = pontos;
		gerarPontos();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public String toString() {
		return nome + ";" + pontos;
	}

	public int gerarPontos() {
		numero = (numero > 0) ? this.numero = numero * 100 : 0;
		return numero;
	}

	public void gerarPontos(int numero) {
		numero = (numero > 0) ? this.numero = numero * 100 : 0;
	}

}
