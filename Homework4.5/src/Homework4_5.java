import java.util.InputMismatchException;
import java.util.Scanner;

public class Homework4_5 {
	public static void main(String[] args) {
		System.out.print("Enter a number: ");
		
		Scanner in = new Scanner(System.in);
		int i0, i1;
		
		try {
			i0 = in.nextInt();
			System.out.print("Enter another number: ");
			i1 = in.nextInt();
		}catch (InputMismatchException e) {
			System.out.print("Input was not a number.");
			in.close();
			return;
		}

		System.out.println("Sum:       \t" + (i0 + i1));
		System.out.println("Difference:\t" + (i0 - i1));
		System.out.println("Product:   \t" + (i0 * i1));
		System.out.println("Average:   \t" + ((i0 + i1) * .5));
		System.out.println("Distance:  \t" + Math.abs(i0 - i1));
		System.out.println("Maximum:   \t" + Math.max(i0, i1));
		System.out.println("Minimum:   \t" + Math.min(i0, i1));
		
		in.close();
	}
}
