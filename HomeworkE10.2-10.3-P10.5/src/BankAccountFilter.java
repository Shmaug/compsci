public class BankAccountFilter implements Filter {
	public boolean accept(Object x) {
		if (!(x instanceof Measurable)) return false;
		return ((Measurable)x).getMeasure() > 1000;
	}
}
