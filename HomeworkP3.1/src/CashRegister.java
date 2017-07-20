public class CashRegister {
	private double purchase;
	private double payment;
	private int items;
	
	public CashRegister() { }
	
	public int getItemCount() {
		return items;
	}

	public void recordPurchase(double amnt) {
		purchase += amnt;
		items++;
	}
	
	public void receivePayment(double amnt) {
		payment += amnt;
	}
	
	public double giveChange() {
		double change = payment - purchase;
		purchase = 0;
		payment = 0;
		return change;
	}
}
