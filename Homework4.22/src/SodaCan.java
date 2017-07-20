public class SodaCan {
	private double height;
	private double radius;
	
	public SodaCan(double height, double diameter) {
		this.height = height;
		radius = diameter * .5;
	}
	
	public double getVolume() {
		return Math.PI * radius * radius * height;
	}
	
	public double getSurfaceArea() {
		return 2 * Math.PI * radius * height + 2 * Math.PI * radius * radius;
	}
}
