public class ReplaceTester {
	public static void main(String[] args) {
		String str = "Mississippi";
		str = str.replace('i', '!').replace('s', '$');
		System.out.println(str +" (expected M!$$!$$!pp!)");
	}
}
