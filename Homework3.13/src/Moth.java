public class Moth {
	private double position;
	
	public Moth(double position) {
		this.position = position;
	}
	
	public void moveToLight(double lightPos) {
		position = (lightPos + position) * 0.5;
	}
	
	public double getPosition() {
		return position;
	}
}
