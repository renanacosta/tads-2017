
public class exercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String g;
		g = "Eduardo";
		System.out.println(g.charAt(0)); // "E"
		System.out.println(g.charAt(3)); // "a"
		System.out.println(g.contains("duar")); // true
		System.out.println(g.contains("ary")); // false
		System.out.println(g.substring(3,5)); // ar
		System.out.println(g.substring(3)); // ardo
		System.out.println(g.indexOf("a")); // 3
		System.out.println(g.replace("a","b" ));
		System.out.println(g.equalsIgnoreCase("teste"));
		
	}

}