
class ValoresInt
{
	public int calculadora()
	{
		int a = 10;
		int b = 20;
		int c = a + b;

		return c;
	}
}

public class testeMetodos {

	public static void main(String[] args) {

		ValoresInt valores = new ValoresInt();

		System.out.print("O resultado da soma é = "+valores.calculadora());
	}

}
