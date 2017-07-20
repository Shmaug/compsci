public class CashRegisterTester {
	public static void main(String[] args) {
		CashRegister register = new CashRegister();
		register.recordPurchase(29.50);
		register.recordPurchase(9.25);
		register.receivePayment(50);
		
		double change = register.giveChange();
		
		System.out.print(change);
		System.out.println(", Expected: 11.25");
		
		System.out.print(register.getItemCount());
		System.out.println(", Expected: 2");
	}
}
