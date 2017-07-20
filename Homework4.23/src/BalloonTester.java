public class BalloonTester {
	public static void main(String[] args) {
		Balloon b = new Balloon();
		
		b.addAir(100);
		System.out.println(b.getRadius());
		System.out.println(b.getSurfaceArea());
		System.out.println(b.getVolume());
		
		b.addAir(100);
		System.out.println(b.getRadius());
		System.out.println(b.getSurfaceArea());
		System.out.println(b.getVolume());
	}
}
