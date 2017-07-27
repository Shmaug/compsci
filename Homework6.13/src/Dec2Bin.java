import java.util.Scanner;

public class Dec2Bin {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int num = scanner.nextInt();
		
		String str = "";
		
		while (num != 0) {
			str = (num % 2) + str;
			num /= 2;
		}
		
		System.out.println(str);
		
		scanner.close();
	}
}
