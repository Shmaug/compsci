import java.util.InputMismatchException;
import java.util.Scanner;

public class PaycheckCalculator {
	static void doTheThing(Scanner scanner) {
		String name;
		double hours;
		double wage;
		double income;
		double tax, ss;
		
		System.out.print("Enter student name: ");
		name = scanner.nextLine();
		
		System.out.print("Enter hourly wage for " + name + ": $");
		try {
			wage = scanner.nextDouble();
		}catch (InputMismatchException e) {
			System.out.println("Invalid number.");
			return;
		}
		
		System.out.print("Enter hours worked for " + name + ": ");
		try {
			hours = scanner.nextDouble();
		}catch (InputMismatchException e) {
			System.out.println("Invalid number.");
			return;
		}
		
		income = wage * hours;
		tax = TaxCalculator.getFederalTax(income);
		ss = TaxCalculator.getSocialSecurity(income);
		
		System.out.println("Gross income:\t\t$" + income);
		System.out.println("Federal tax:\t\t$" + tax);
		System.out.println("Social Security:\t$" + ss);
		System.out.println("Adjusted income:\t$" + (income  - (tax + ss)));
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		doTheThing(scanner);
		scanner.close();
	}
}
