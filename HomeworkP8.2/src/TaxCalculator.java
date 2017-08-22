public class TaxCalculator {
	static final int bracketCount_fed = 5;
	static final double[] bracketRates_fed   = { .01,   .02,   .03,    .04,    .05,   .06 };
	static final double[] bracketIncomes_fed = { 50000, 75000, 100000, 250000, 500000 };

	static final double socialSecurityRate = .062; // from https://www.ssa.gov/pubs/EN-05-10003.pdf
	static final double socialSecurityLimit = 127200;
	
	static double getFederalTax(double income, int bracket, double total) {
		// recursion because why not
		if (income > bracketIncomes_fed[bracket] && bracket+1 < bracketCount_fed) {
			// income is over the current bracket
			double t = bracketIncomes_fed[bracket];
			if (bracket > 0) t -= bracketIncomes_fed[bracket-1]; // get amount of money in this bracket
			t *= bracketRates_fed[bracket]; // tax it
			
			total += t;
			return getFederalTax(income, bracket + 1, total); // up to the next bracket
			
		} else if (bracket+1 >= bracketCount_fed && income > bracketIncomes_fed[bracketCount_fed-1]) {
			// income exceeded all the brackets
			double t = income - bracketIncomes_fed[bracketCount_fed-1]; // get amount of money in this bracket
			t *= bracketRates_fed[bracketCount_fed]; // tax it
			
			return total + t;
			
		} else {
			// income within current bracket
			double t = income;
			if (bracket > 0) t -= bracketIncomes_fed[bracket-1]; // get amount of money in this bracket
			t *= bracketRates_fed[bracket]; // tax it
			
			return total + t;
		}
	}
	public static double getFederalTax(double income) {
		return getFederalTax(income, 0, 0);
	}
	
	static double getSocialSecurity(double income) {
		return Math.min(income, socialSecurityLimit) * socialSecurityRate;
	}
}
