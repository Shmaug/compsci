public class HelloPrinter {
	public static void main(String[] args) {
		String str = "Hello, World!";
		str = str.replace("e", "*").replace("o", "e").replace("*", "o");
		System.out.println(str);
	}
}
