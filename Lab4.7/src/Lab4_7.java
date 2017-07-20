import java.util.Scanner;

public class Lab4_7 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		while (true){
			System.out.print("Enter a price: ");
			String input = in.nextLine();
			
			double price = 0;
			
			try{
				price = Double.parseDouble(input);
			}catch (java.lang.NumberFormatException e){
				System.out.println("Invalid number. Exiting...");
				break;
			}
			
			int dollars = (int)Math.floor(price);
			int cents = (int)((price - dollars) * 100 + 0.5);
			
			System.out.println(dollars + " dollars and " + cents + " cents");
		}
		
		in.close();
	}
}
