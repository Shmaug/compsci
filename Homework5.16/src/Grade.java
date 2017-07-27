public class Grade {
	static final int minusRange = 25;
	static final int plusRange = 75;
	
	public static String getNumericGrade(double grade) {
		final String[] grades = { "F", "D", "C", "B", "A" };
		
		int g = (int)Math.ceil(grade);
		String m = "";
		
		if (g != 0) { // F's dont get +'s or -'s
			int frac = (int)((grade - (int)grade)*100 + .5); // round it because doubles dont == very well
			if (frac < minusRange)
				m = "-";
			else if (frac >= plusRange)
				m = "+";
		}
		
		return grades[g] + m;
	}
	
	public static void main(String[] args) {
		// I really don't understand the grade scale the. 2.8 = B- and 2.85 = a tie between B- and B
		// My scale is from 0(F) to 4 (A+), where:
		// 0 = F
		// 0 < x < 1 = D
		// 1 <= x < 2 = C
		// 2 <= x < 3 = B
		// 3 <= x <= 4 = A
		// and in each integer range, the decimals make the + or -:
		// <.25 = '-'
		// >.75 = '+'
		// ^^ these values defined with the variables minusRange and plusRange
		
		for (double x = 0; x <= 4.0; x += .05)
			System.out.println(String.format("%.2f: %s", x, Grade.getNumericGrade(x)));
	}
}
