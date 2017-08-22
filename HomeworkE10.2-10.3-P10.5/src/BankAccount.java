
public class BankAccount implements Measurable {
	public double balance;
	
	public BankAccount(double balance) {
		this.balance = balance;
	}
	
	public double getMeasure() {
		return balance;
	}
	
	public static void main(String[] args) {
		BankAccount[] acc = new BankAccount[1000];
		for (int i = 0; i < acc.length; i++)
			acc[i] = new BankAccount(Math.random() * 50000);
		
		BankAccountFilter filter = new BankAccountFilter();
		
		double avg = Data.average(acc, filter);
		Measurable max = Data.max(acc, filter);
		System.out.println("Avg:\t" + String.format("%.2f", avg));
		System.out.println("Max:\t" + String.format("%.2f", max.getMeasure()));
	}
}
