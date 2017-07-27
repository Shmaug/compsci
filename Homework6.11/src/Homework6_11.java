import java.util.Scanner;

public class Homework6_11 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String word = scanner.nextLine();
		scanner.close();
		
		int l = word.length();
		
		for (int i = 1; i < l; i++) {
			for (int j = 0; j < l; j+=i) {
				if (j+i >= l)
					System.out.println(word.substring(l-i, l));
				else
					System.out.println(word.substring(j, j+i));
			}
		}
	}
}
