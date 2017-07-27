public class TaxCalculator {
	static final int bracketCount = 5;
	static final double[] bracketRates   = { .01,   .02,   .03,    .04,    .05,   .06 };
	static final double[] bracketIncomes = { 50000, 75000, 100000, 250000, 500000 };
	
	static double getTax(double income, int bracket, double total) {
		// recursion because why not
		if (income > bracketIncomes[bracket] && bracket+1 < bracketCount) {
			// income is over the current bracket
			double t = bracketIncomes[bracket];
			if (bracket > 0) t -= bracketIncomes[bracket-1]; // get amount of money in this bracket
			t *= bracketRates[bracket]; // tax it
			
			total += t;
			System.out.println("bracket " + bracket + ": " + t);
			return getTax(income, bracket + 1, total); // up to the next bracket
			
		} else if (bracket+1 >= bracketCount && income > bracketIncomes[bracketCount-1]) {
			// income exceeded all the brackets
			double t = income - bracketIncomes[bracketCount-1]; // get amount of money in this bracket
			t *= bracketRates[bracketCount]; // tax it
			
			System.out.println("bracket " + bracketCount + ": " + t);
			return total + t;
			
		} else {
			// income within current bracket
			double t = income;
			if (bracket > 0) t -= bracketIncomes[bracket-1]; // get amount of money in this bracket
			t *= bracketRates[bracket]; // tax it
			
			System.out.println("bracket " + bracket + ": " + t);
			return total + t;
		}
	}
	
	public static double getTax(double income) {
		return getTax(income, 0, 0);
	}
	
	public static void main(String[] args) {
		System.out.println("500000: " + getTax(500000));
		System.out.println("");
		System.out.println("130000: " + getTax(130000));
		System.out.println("");
		System.out.println("260000: " + getTax(260000));
		System.out.println("");
		System.out.println("500000: " + getTax(500000));
		System.out.println("");
		System.out.println("1000000: " + getTax(1000000));
	}
}
