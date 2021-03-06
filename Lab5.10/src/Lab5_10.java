import java.util.Scanner;

public class Lab5_10 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		while(true){
			System.out.println("Enter (exact) satisfaction on a scale of 1 (satisfied) to 3 (dissatisfied): ");
			String input = in.nextLine();
			
			double satisfaction = 0;
			
			try {
				satisfaction = Double.parseDouble(input);
			} catch (NumberFormatException e){
				System.out.println("Invalid number. Exiting...");
				break;
			}
			
			double tip = -5 * satisfaction + 25; // very precise tip from a very precise satisfaction
			System.out.println("Tip: " + tip + "%");
		}
		
		in.close();
	}
}
