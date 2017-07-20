public class Balloon {
	private double volume;
	
	public Balloon() {
		volume = 0;
	}
	
	public void addAir(double amnt) {
		volume += amnt;
	}
	
	public double getVolume() {
		return volume;
	}
	
	public double getSurfaceArea() {
		double r = getRadius();
		return 4.0 * Math.PI * r * r;
	}
	
	public double getRadius() {
		// v = 4/3 * pi * r^3;
		// r^3 = v / (4/3 * pi)
		// r = (v / (4/3 * pi) ^ (1/3)
		return Math.pow(volume / (Math.PI * 4.0 / 3.0), 1.0 / 3.0);
	}
}
