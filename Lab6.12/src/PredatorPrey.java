import java.util.InputMismatchException;
import java.util.Scanner;

public class PredatorPrey {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		double a,b,c,d;
		double prey,pred;
		int p;
		try {
			System.out.print("Enter prey excess birth rate (A): ");
			a = scanner.nextDouble();
			System.out.print("Enter predation rate (B): ");
			b = scanner.nextDouble();
			System.out.print("Enter predator death rate without food (C): ");
			c = scanner.nextDouble();
			System.out.print("Enter predator food presence increase rate (D): ");
			d = scanner.nextDouble();
	
			System.out.print("Enter number of prey: ");
			prey = scanner.nextInt();
			System.out.print("Enter number of predators: ");
			pred = scanner.nextInt();
			
			System.out.print("Enter number of periods to simulate: ");
			p = scanner.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Invalid number");
			scanner.close();
			return;
		}
		
		// I wonder if prey and pred should be doubles to be more accurate, and round to int when displaying to user?
		
		double py, pd;
		for (int i = 0; i < p; i++) {
			py = prey;
			pd = pred;
			prey = py * (1 + a - b*pd);
			pred = pd * (1 - c + d*py);
			System.out.println("Period " + (i+1) + ": " + (int)prey + " prey, " + (int)pred + " predators");
		}
		
		scanner.close();
	}
}
