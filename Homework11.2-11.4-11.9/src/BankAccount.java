
public class BankAccount {
	private int accountNumber;
	private double balance;
	
	public BankAccount() {
		accountNumber = -1;
		balance = 0;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	
	public boolean read(String input) {
		String[] inputs = input.trim().split("\\s+");
		
		if (inputs.length != 2) return false;
		
		try {
			accountNumber = Integer.parseInt(inputs[0]);
			balance = Double.parseDouble(inputs[1]);
			
			return true;
		}catch (NumberFormatException e) {
			return false;
		}
	}
	
	public String toString() {
		return accountNumber + " $" + balance;
	}
}
