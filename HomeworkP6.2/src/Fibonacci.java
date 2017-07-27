import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int num = scanner.nextInt();
		
		// ints overflow after 46
		// longs overflow after 103
		
		long f1 = 1;
		long f2 = 1;
		long fn = 0;
		for (long i = 2; i < num; i++) {
			fn = f1 + f2;
			f2 = f1;
			f1 = fn;
		}
		
		System.out.println(fn);
		
		scanner.close();
	}
}
