public class CarTester {
	public static void main(String[] args) {
		Car hybrid = new Car(50);
		hybrid.addGas(20);
		System.out.println(hybrid.getGasInTank());
		
		hybrid.drive(100);
		double gasLeft = hybrid.getGasInTank();
		System.out.println(gasLeft);
		
		hybrid.drive(2000);
		System.out.println(hybrid.getGasInTank());
	}
}
