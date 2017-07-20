import java.util.Scanner;

public class Lab4_13 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		while (true){
			System.out.print("Input thermistor resistance: ");
			String input = in.nextLine();
			double r = 0;
			
			try{
				r = Double.parseDouble(input);
			} catch (NumberFormatException e){
				System.out.println("Invalid number. Exiting...");
				break;
			}
			
			
			double b = 3996;
			double t0 = 85 + 273; // 85 celsius to kelvin
			double r0 = 1075;
			
			double t = b * t0 / (t0 * Math.log(r / r0) + b) - 273;
			
			System.out.println("Temperature: " + t + " degrees celsius");
		}
		
		in.close();
	}
}
