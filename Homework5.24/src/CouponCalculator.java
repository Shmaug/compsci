import java.util.Scanner;

public class CouponCalculator {
	static final double[] couponPercents  = { 0, .08, .1, .12, .14 };
	static final double[] couponBrackets = {  10, 60, 150, 210 };
	
	static double getCouponPercent(double cost) {
		for (int i = 0; i < couponBrackets.length; i++)
			if (cost <= couponBrackets[i])
				return couponPercents[i];
		
		return couponPercents[couponBrackets.length]; // cost is greater than all the brackets
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter cost of your groceries: ");
		double cost = scanner.nextDouble();
		System.out.println(String.format("Your discount: %d%%", (int)(getCouponPercent(cost)*100)));
		scanner.close();
	}
}
