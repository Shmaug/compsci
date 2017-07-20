public class Car {
	private double mpg;
	private double gas;
	
	public Car(double mpg) {
		this.mpg = mpg;
	}
	
	public void addGas(double amnt) {
		gas += amnt;
	}
	
	public void drive(double distance) {
		if (gas - distance / mpg < 0) {
			System.out.println("Ran out of gas. Only made it " + (gas * mpg) + " miles.");
			gas = 0;
		} else
			gas -= distance / mpg;
	}
	
	public double getGasInTank() {
		return gas;
	}
}
