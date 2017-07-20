import java.util.InputMismatchException;
import java.util.Scanner;

public class Homework4_15 {
	public static void main(String[] args) {
		System.out.print("Enter a 5-digit positive number: ");
		
		Scanner in = new Scanner(System.in);
		int i;
		
		try {
			i = in.nextInt();
		}catch (InputMismatchException e) {
			System.out.print("Input is not a number.");
			in.close();
			return;
		}
		
		if (i < 0) {
			System.out.print("Input is negative.");
			in.close();
			return;
		}
		
		String nstr = i + "";
		if (nstr.length() != 5) {
			System.out.print("Input is not 5 digits.");
			in.close();
			return;
		}
		
		String str = "";
		for (int j = 0; j < 5; j++)
			str = str + nstr.substring(j, j + 1) + (j == 4 ? "" : " ");
		// This is hacky and ugly and probably unnecessarily slow but it works
		
		System.out.println(str);
		
		in.close();
	}
}
